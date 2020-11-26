package springboot.askisi3.service;

import java.util.List;

import springboot.askisi3.entity.Racks;

public interface RacksService {

	public List<Racks> findAll();
	
	public Racks findById(int theId);
	
	public void save(Racks theRacks);
	
	public void deleteById(int theId);
	
}