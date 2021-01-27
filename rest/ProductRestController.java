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

@RestController
@RequestMapping("/products")
public class ProductRestController {

	private ProductService productService;
	@Autowired
	public ProductRestController(ProductService theProductService) {
		productService = theProductService;
	}
	
	// expose "/products" and return list of products
	@GetMapping("")
	public List<ProductDto> findAll() {
		return productService.ProductListToDtoList(productService.findAll());
	}

	// add mapping for GET /products/{productId}
	
	@GetMapping("/{productId}")
	public ProductDto getProduct(@PathVariable int productId) {
		
		Product theProduct = productService.findById(productId);
		ProductDto a =null;
		
		if (theProduct == null) 
		
		{
			throw new NoFoundException("Product id not found - " + productId);
		}
		else {a=new ProductDto(theProduct);}
		
		
		
		
		return  a;
	}
	
	// add mapping for POST /products - add new product
	
	@PostMapping("")
	public ProductDto addProduct(@RequestBody ProductDto theProductDto) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theProductDto.setId(0);
		
		return productService.save(theProductDto);
	}
	
	// add mapping for PUT /products - update existing product
	
	@PutMapping("")
	public ProductDto updateProduct(@RequestBody ProductDto theProduct) {
	
		return productService.update(theProduct);
	}
	
	// add mapping for DELETE /products/{productId} - delete product
	
	@DeleteMapping("/{productId}")
	public String deleteProduct(@PathVariable int productId) {
		
		Product tempProduct = productService.findById(productId);
		
		// throw exception if null
		
		if (tempProduct == null) {
			throw new NoFoundException("Employee id not found - " + productId);
		}
		
		productService.deleteById(productId);
		
		return "Deleted product id - " + productId;
	}
	

	
	
}










