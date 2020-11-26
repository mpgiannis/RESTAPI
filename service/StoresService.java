package springboot.askisi3.service;

import java.util.List;

import springboot.askisi3.entity.Stores;

public interface StoresService {

	public List<Stores> findAll();
	
	public Stores findById(int theId);
	
	public void save(Stores theStore);
	
	public void deleteById(int theId);
	
}