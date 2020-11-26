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

import springboot.askisi3.entity.Stores;
import springboot.askisi3.service.StoresService;

@RestController
@RequestMapping("/api")
public class StoresRestController {
	private StoresService storesService;
	
	
	@Autowired
	public StoresRestController(StoresService theStoresService) {
		storesService = theStoresService;
	}
	
	// expose "/stores" and return list of stores
	@GetMapping("/stores")
	public List<Stores> findAll() {
		return storesService.findAll();
	}

	// add mapping for GET /stores/{storesId}
	
	@GetMapping("/stores/{storesId}")
	public Stores getStores(@PathVariable int storesId) {
		
		Stores theStores = storesService.findById(storesId);
		
		if (theStores == null) {
			throw new RuntimeException("Stores id not found - " + storesId);
		}
		
		return theStores;
	}
	
	// add mapping for POST /stores - add new stores
	
		@PostMapping("/stores")
		public Stores addStores(@RequestBody Stores theStores) {
			
			// also just in case they pass an id in JSON ... set id to 0
			// this is to force a save of new item ... instead of update
			
			theStores.setId(0);
			
			storesService.save(theStores);
			
			return theStores;
		}
		
		// add mapping for PUT /stores - update existing stores
		
		@PutMapping("/stores")
		public Stores updateStores(@RequestBody Stores theStores) {
			
			storesService.save(theStores);
			
			return theStores;
		}
		
		// add mapping for DELETE /stores/{storesId} - delete stores
		
		@DeleteMapping("/stores/{storesId}")
		public String deleteStores(@PathVariable int storesId) {
			
			Stores tempStores = storesService.findById(storesId);
			
			// throw exception if null
			
			if (tempStores == null) {
				throw new RuntimeException("Stores id not found - " + storesId);
			}
			
			storesService.deleteById(storesId);
			
			return "Deleted Stores id - " + storesId;
		}
	
	
	
	
	
	
}
