package springboot.askisi3.service;

import java.util.List;

import springboot.askisi3.dto.ProductDto;
import springboot.askisi3.entity.Product;

public interface ProductService {

	public List<Product> findAll();
	
	public Product findById(int theId);
	
	public ProductDto save(ProductDto theProductDto);
	
	public void deleteById(int theId);
	
	public ProductDto update(ProductDto newProduct);
	
	public List<ProductDto> ProductListToDtoList(List<Product> entitylist);
	
}
