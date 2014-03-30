/**
 * 
 */
package edu.web.dainterface;

/**
 * @author rohansabnis
 *
 */
import java.io.Serializable;
import java.util.List;

import edu.web.bean.Product;

public interface ProductManager extends Serializable {

	public void increasePrice(int percentage);

	public void batchincreasePrice(int percentage);

	public List<Product> getProducts();

}
