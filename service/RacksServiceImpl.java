package springboot.askisi3.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.askisi3.dao.RacksRepository;
import springboot.askisi3.entity.Racks;


@Service
public class RacksServiceImpl implements RacksService{
	
	private RacksRepository racksRepository;
	
	@Autowired
	public RacksServiceImpl(RacksRepository theRacksRepository) {
		racksRepository = theRacksRepository;
	}
	

	@Override
	public List<Racks> findAll() {
		// TODO Auto-generated method stub
		return racksRepository.findAll();
	}

	@Override
	public Racks findById(int theId) {
	Optional<Racks> result = racksRepository.findById(theId);
		
	Racks theRacks = null;
		
		if (result.isPresent()) {
			theRacks = result.get();
		}
		else {
			// we didn't find the racks
			throw new RuntimeException("Did not find racks id - " + theId);
		}
		
		return theRacks;
	}

	@Override
	public void save(Racks theRacks) {
		// TODO Auto-generated method stub
		racksRepository.save(theRacks);
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		racksRepository.deleteById(theId);
	}

	







}
