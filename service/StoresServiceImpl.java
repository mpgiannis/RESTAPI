package springboot.askisi3.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.askisi3.dao.StoresRepository;
import springboot.askisi3.entity.Stores;


@Service
public class StoresServiceImpl implements StoresService
{
	private StoresRepository storesRepository;
	
	@Autowired
	public StoresServiceImpl(StoresRepository theStoresRepository) {
		storesRepository = theStoresRepository;
	}
	
	@Override
	public List<Stores> findAll() {
	
		return storesRepository.findAll();
    }
	
	

	@Override
	public Stores findById(int theId) {
		Optional<Stores> result = storesRepository.findById(theId);
		
		Stores theStores = null;
		
		if (result.isPresent()) {
			theStores = result.get();
		}
		else {
			// we didn't find the stores
			throw new RuntimeException("Did not find stores id - " + theId);
		}
		
		return theStores;
	}

	
	
	@Override
	public void save(Stores theStores) {
		storesRepository.save(theStores);
	}
	
	

	@Override
	public void deleteById(int theId) {
		storesRepository.deleteById(theId);
	}
	
}
