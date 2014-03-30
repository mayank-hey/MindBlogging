/**
 * 
 */
package edu.web.controller;

/**
 * @author rohansabnis
 *
 */
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import edu.web.dainterface.ProductManager;

public class InventoryController implements Controller {

	protected final Log logger = LogFactory.getLog(getClass());

	private ProductManager productManager;

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String user_id = "";
		Map<String, String[]> parameters = request.getParameterMap();
		if (parameters.get("user_id") != null) {
			user_id = parameters.get("user_id")[0].toString();
			session.setAttribute("user_id", user_id);
		}

		String now = (new java.util.Date()).toString();
		logger.info("returning hello view with " + now);

		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("now", now);
		myModel.put("products", this.productManager.getProducts());
		logger.info(session.getAttribute("user_id").toString());

		return new ModelAndView("hello", "model", myModel);
	}

	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}

}
