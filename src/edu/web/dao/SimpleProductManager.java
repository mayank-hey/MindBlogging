/**
 * 
 */
package edu.web.dao;

/**
 * @author rohansabnis
 *
 */
import java.util.ArrayList;
import java.util.List;

import edu.web.bean.Product;
import edu.web.dainterface.ProductDao;
import edu.web.dainterface.ProductManager;

public class SimpleProductManager implements ProductManager {

	// private List<Product> products;
	private ProductDao productDao;

	public List<Product> getProducts() {
		// return products;
		return productDao.getProductList();
	}

	public void increasePrice(int percentage) {
		List<Product> products = productDao.getProductList();
		if (products != null) {
			for (Product product : products) {
				double newPrice = product.getPrice().doubleValue()
						* (100 + percentage) / 100;
				product.setPrice(newPrice);
				productDao.saveProduct(product);
			}
		}
	}

	@SuppressWarnings("null")
	public void batchincreasePrice(int percentage) {
		List<Product> oldproducts = productDao.getProductList();
		List<Product> newproducts = new ArrayList();
		if (oldproducts != null) {
			for (Product product : oldproducts) {
				double newPrice = product.getPrice().doubleValue()
						* (100 + percentage) / 100;
				product.setPrice(newPrice);
				newproducts.add(product);
			}
			productDao.batchsaveProduct(newproducts);
		}
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	/*
	 * public void setProducts(List<Product> products) { this.products =
	 * products; }
	 */
}
