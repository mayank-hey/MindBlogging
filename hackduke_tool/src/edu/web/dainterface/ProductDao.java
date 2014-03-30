package edu.web.dainterface;

import java.util.List;

import edu.web.bean.Product;

public interface ProductDao {

	public List<Product> getProductList();

	public void saveProduct(Product prod);
	
	public void batchsaveProduct(List<Product> prods);

}
