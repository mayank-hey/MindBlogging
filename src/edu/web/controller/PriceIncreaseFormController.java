package edu.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import edu.web.bean.PriceIncrease;
import edu.web.dainterface.ProductManager;

public class PriceIncreaseFormController extends SimpleFormController {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	private ProductManager productManager;

	public ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws ServletException {
		HttpSession session = request.getSession();
		int increase = ((PriceIncrease) command).getPercentage();
		String datefield = ((PriceIncrease) command).getDatefield();
		logger.info("Increasing prices by " + increase + "%." + datefield);
		logger.info("Session Object-"
				+ session.getAttribute("user_id").toString());

		// productManager.increasePrice(increase);
		productManager.batchincreasePrice(increase);

		logger.info("returning from PriceIncreaseForm view to "
				+ getSuccessView());

		return new ModelAndView(new RedirectView(getSuccessView()));
	}

	protected Object formBackingObject(HttpServletRequest request)
			throws ServletException {
		PriceIncrease priceIncrease = new PriceIncrease();
		priceIncrease.setPercentage(20);
		priceIncrease.setDatefield("2013-08-28");
		return priceIncrease;
	}

	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}

	public ProductManager getProductManager() {
		return productManager;
	}

}
