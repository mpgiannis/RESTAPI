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

import springboot.askisi3.dto.RacksDto;
import springboot.askisi3.entity.Racks;
import springboot.askisi3.service.RacksService;


@RestController
@RequestMapping("/racks")
public class RacksRestController {

	
	private RacksService racksService;
	@Autowired
	public RacksRestController(RacksService theRacksService) {
		racksService = theRacksService;
	}
	
	// expose "/racks" and return list of racks
	@GetMapping("")
	public List<RacksDto> findAll() {
		List<Racks> list = racksService.findAll();
		return  racksService.RacksListToDtoList(list);
	}
	
	@GetMapping("/{racksId}")
	public RacksDto getRacks(@PathVariable int racksId) {
		
		Racks theRacks = racksService.findById(racksId);
		
		if (theRacks == null) {
			throw new NoFoundException("Racks id not found - " + racksId);
		}
		
		return new RacksDto(theRacks);
	}
	
	// add mapping for POST /racks - add new racks
	
		@PostMapping("")
		public RacksDto addRacks(@RequestBody RacksDto theRackDto) {
			theRackDto.setId(0);
			return racksService.save(theRackDto);
			}
		
		// add mapping for PUT /racks  - update existing racks
		
		@PutMapping("")
		public RacksDto updateRacks(@RequestBody RacksDto theRacksDto) {
			
			
			return racksService.update(theRacksDto);
			
		
		}
		
		// add mapping for DELETE /racks/{racksId} - delete racks
		
		@DeleteMapping("/{racksId}")
		public String deleteRacks(@PathVariable int racksId) {
			
			Racks tempRacks = racksService.findById(racksId);
			
			// throw exception if null
			
			if (tempRacks == null) {
				throw new NoFoundException("Racks id not found - " + racksId);
			}
			
			racksService.deleteById(racksId);
			
			return "Deleted Racks id - " + racksId;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
