package springboot.askisi3.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.askisi3.dao.StoresRepository;
import springboot.askisi3.dto.StoresDto;
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
	public void save(StoresDto theStoresDto) {
		storesRepository.save(dtoToEntity(theStoresDto));
	}
	
	@Override
	public StoresDto update(StoresDto newStoreDto) {
		
		Optional<Stores> oldStore = storesRepository.findById(newStoreDto.getId());
		
		
		Stores updateStore = null;
		
		if(oldStore.isPresent()) {
			
			
			updateStore=storesRepository.save(dtoToEntity(newStoreDto));
		}
		else {
			throw new RuntimeException("Did not found store id :"+ newStoreDto.getId());
			
		}
	
		
		return new StoresDto(updateStore);
		
		
	}

	@Override
	public void deleteById(int theId) {
		storesRepository.deleteById(theId);
	}


	
	
	public Stores dtoToEntity(StoresDto storeDto) {
		
		Stores store = new Stores();
		
		store.setId(storeDto.getId());
		store.setDescription(storeDto.getDescription());
		
		return store;
	}
	
	
	
	public List<StoresDto> StoresListToDtoList(List<Stores> entitylist)
	{
		List<StoresDto> listDto = new ArrayList<>();
		for(Stores store : entitylist) {
			StoresDto temp = new StoresDto(store);
			listDto.add(temp);			
		   }

		return listDto;
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	//@Override
	//public boolean existsbyId(Integer id) {
		// TODO Auto-generated method stub
	//	return storesRepository.existsById(id);
	//}
	
}
