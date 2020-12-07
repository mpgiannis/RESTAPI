package springboot.askisi3.service;

import java.util.List;

import springboot.askisi3.dto.StoresDto;
import springboot.askisi3.entity.Stores;


public interface StoresService {

	public List<Stores> findAll();
	
	public Stores findById(int theId);
	
	public StoresDto save(StoresDto theStore);
	
	public void deleteById(int theId);
	
	public StoresDto update(StoresDto newStore);
	
	public List<StoresDto> StoresListToDtoList(List<Stores> entitylist);
	
	//public boolean existsbyId(Integer id);
	
	
}