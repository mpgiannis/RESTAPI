package springboot.askisi3.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.askisi3.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {


	
}
