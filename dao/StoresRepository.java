package springboot.askisi3.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.askisi3.entity.Stores;

public interface StoresRepository extends JpaRepository<Stores, Integer> {


	
}