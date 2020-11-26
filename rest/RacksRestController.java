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


import springboot.askisi3.entity.Racks;
import springboot.askisi3.service.RacksService;


@RestController
@RequestMapping("/api")
public class RacksRestController {

	
	private RacksService racksService;
	
	@Autowired
	public RacksRestController(RacksService theRacksService) {
		racksService = theRacksService;
	}
	
	// expose "/racks" and return list of racks
	@GetMapping("/racks")
	public List<Racks> findAll() {
		return racksService.findAll();
	}
	
	@GetMapping("/racks/{racksId}")
	public Racks getRacks(@PathVariable int racksId) {
		
		Racks theRacks = racksService.findById(racksId);
		
		if (theRacks == null) {
			throw new RuntimeException("Racks id not found - " + racksId);
		}
		
		return theRacks;
	}
	
	// add mapping for POST /racks - add new racks
	
		@PostMapping("/racks")
		public Racks addRacks(@RequestBody Racks theRacks) {
			
			// also just in case they pass an id in JSON ... set id to 0
			// this is to force a save of new item ... instead of update
			
			theRacks.setId(0);
			
			racksService.save(theRacks);
			
			return theRacks;
		}
		
		// add mapping for PUT /racks  - update existing racks
		
		@PutMapping("/racks")
		public Racks updateRacks(@RequestBody Racks theRacks) {
			
			racksService.save(theRacks);
			
			return theRacks;
		}
		
		// add mapping for DELETE /racks/{racksId} - delete racks
		
		@DeleteMapping("/racks/{racksId}")
		public String deleteRacks(@PathVariable int racksId) {
			
			Racks tempRacks = racksService.findById(racksId);
			
			// throw exception if null
			
			if (tempRacks == null) {
				throw new RuntimeException("Racks id not found - " + racksId);
			}
			
			racksService.deleteById(racksId);
			
			return "Deleted Racks id - " + racksId;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
