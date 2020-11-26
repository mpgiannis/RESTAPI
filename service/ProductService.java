package springboot.askisi3.service;

import java.util.List;

import springboot.askisi3.entity.Product;

public interface ProductService {

	public List<Product> findAll();
	
	public Product findById(int theId);
	
	public void save(Product theProduct);
	
	public void deleteById(int theId);
	
}
