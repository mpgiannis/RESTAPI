package springboot.askisi3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.askisi3.dao.ProductRepository;
import springboot.askisi3.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;
	
	@Autowired
	public ProductServiceImpl(ProductRepository theProductRepository) {
		productRepository = theProductRepository;
	}
	
	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product findById(int theId) {
		Optional<Product> result = productRepository.findById(theId);
		
		Product theProduct = null;
		
		if (result.isPresent()) {
			theProduct = result.get();
		}
		else {
			// we didn't find the product
			throw new RuntimeException("Did not find product id - " + theId);
		}
		
		return theProduct;
	}

	@Override
	public void save(Product theProduct) {
		productRepository.save(theProduct);
	}

	@Override
	public void deleteById(int theId) {
		productRepository.deleteById(theId);
	}

}






