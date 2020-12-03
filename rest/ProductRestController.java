package springboot.askisi3.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.askisi3.dto.ProductDto;
import springboot.askisi3.entity.Product;
import springboot.askisi3.service.ProductService;
import springboot.askisi3.service.ProductServiceImpl;

@RestController
@RequestMapping("/api")
public class ProductRestController {

	private ProductService productService;
	private ProductServiceImpl productServiceImpl;
	@Autowired
	public ProductRestController(ProductService theProductService,ProductServiceImpl a) {
		productService = theProductService;
		productServiceImpl=a;
	}
	
	// expose "/products" and return list of products
	@GetMapping("/products")
	public List<ProductDto> findAll() {
		return productServiceImpl.ProductListToDtoList(productService.findAll());
	}

	// add mapping for GET /products/{productId}
	
	@GetMapping("/products/{productId}")
	public ProductDto getProduct(@PathVariable int productId) {
		
		Product theProduct = productService.findById(productId);
		
		if (theProduct == null) {
			throw new RuntimeException("Product id not found - " + productId);
		}
		
		return new ProductDto(theProduct);
	}
	
	// add mapping for POST /products - add new product
	
	@PostMapping("/products")
	public ProductDto addProduct(@RequestBody ProductDto theProductDto) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theProductDto.setId(0);
		
		productService.save(theProductDto);
		
		return theProductDto;
	}
	
	// add mapping for PUT /products - update existing product
	
	@PutMapping("/products")
	public ProductDto updateProduct(@RequestBody ProductDto theProduct) {
	
		return productService.update(theProduct);
	}
	
	// add mapping for DELETE /products/{productId} - delete product
	
	@DeleteMapping("/product/{productId}")
	public String deleteProduct(@PathVariable int productId) {
		
		Product tempProduct = productService.findById(productId);
		
		// throw exception if null
		
		if (tempProduct == null) {
			throw new RuntimeException("Employee id not found - " + productId);
		}
		
		productService.deleteById(productId);
		
		return "Deleted product id - " + productId;
	}
	
}










