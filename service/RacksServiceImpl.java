package springboot.askisi3.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.askisi3.dao.RacksRepository;
import springboot.askisi3.dto.RacksDto;
import springboot.askisi3.entity.Racks;

@Service
public class RacksServiceImpl implements RacksService{
	
	
	private RacksRepository racksRepository;
	@Autowired
	private StoresService storeService;
	@Autowired
	public RacksServiceImpl(RacksRepository theRacksRepository) {
		racksRepository = theRacksRepository;
	}
	

	@Override
	public List<Racks> findAll() {
		List<Racks> racks=racksRepository.findAll();	
		return racks;}

	
	@Override
	public Racks findById(int theId) {
		Optional<Racks> result = racksRepository.findById(theId);

		Racks theRack=null;
		if (result.isPresent()) {
			
			theRack=result.get();
		}
		else {
			
			throw new RuntimeException("Did not find racks id - " + theId);
		}
		
		return theRack;
	}

	
	@Override
	public RacksDto save(RacksDto theRacksDto) {
		if( storeService.findById(theRacksDto.getStoreId())!=null){
			racksRepository.save(dtoToEntity(theRacksDto));
			return theRacksDto;}
		
		else {
			throw new RuntimeException("Did not found store with this id :"+ theRacksDto.getStoreId());
			}
	}

	
	@Override
	public RacksDto update(RacksDto newRackDto) {
		
		Optional<Racks> oldRack = racksRepository.findById(newRackDto.getId());
		
		Racks updateRack = null;
		
		if(oldRack.isPresent()) {
			
			
			updateRack=racksRepository.save(dtoToEntity(newRackDto));
		}
		else {
			throw new RuntimeException("Did not found rack id :"+ newRackDto.getId());
			
		}
	
		
		return new RacksDto(updateRack);

	}
	

	
	@Override
	public void deleteById(int theId) {
		racksRepository.deleteById(theId);
	}

	

	public Racks dtoToEntity(RacksDto rackDto) {
		
		Racks rack = new Racks();
		
		rack.setId(rackDto.getId());
		rack.setDescription(rackDto.getDescription());
		rack.setStore(storeService.findById(rackDto.getStoreId()));
		
		return rack;
	}
	
	
	public List<RacksDto> RacksListToDtoList(List<Racks> entitylist)
	{
		List<RacksDto> listDto = new ArrayList<>();
		for(Racks rack : entitylist) {
			RacksDto temp = new RacksDto(rack);
			listDto.add(temp);			
		   }

		return listDto;
	 }






}
