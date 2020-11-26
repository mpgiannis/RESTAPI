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

import springboot.askisi3.entity.Imports_exports;
import springboot.askisi3.service.Imports_ExportsService;

@RestController
@RequestMapping("/api")
public class Imports_ExportsRestController {
	
	
	private Imports_ExportsService imports_exportsService;
	
	
	@Autowired
	public Imports_ExportsRestController(Imports_ExportsService theImports_ExportsService) {
		imports_exportsService = theImports_ExportsService;
	}
	
	@GetMapping("/imports_exports")
	public List<Imports_exports> findAll() {
		return imports_exportsService.findAll();
	}

	
	@GetMapping("/imports_exports/{imports_exportsId}")
	public Imports_exports getImports_Exports(@PathVariable int imports_exportsId) {
		
		Imports_exports theImports_Exports = imports_exportsService.findById(imports_exportsId);
		
		if (theImports_Exports == null) {
			throw new RuntimeException("Imports_Exports id not found - " + imports_exportsId);
		}
		
		return theImports_Exports;
	}

	
	@PostMapping("/imports_exports")
	public Imports_exports addImports_Exports(@RequestBody Imports_exports theImports_Exports) {
		theImports_Exports.setId(0);
		imports_exportsService.save(theImports_Exports);
		return theImports_Exports;
	}
	
	@PutMapping("/imports_exports")
	public Imports_exports updateImports_Exports(@RequestBody Imports_exports theImports_Exports) {
		imports_exportsService.save(theImports_Exports);
		return theImports_Exports;
	}
	
	@DeleteMapping("/imports_exports/{imports_exportsId}")
	public String deleteImports_Exports(@PathVariable int imports_exportsId) {	
		Imports_exports tempImports_Exports = imports_exportsService.findById(imports_exportsId);
		if (tempImports_Exports == null) {
			throw new RuntimeException("Imports_Exports id not found - " + imports_exportsId);
		}
		
		imports_exportsService.deleteById(imports_exportsId);
		
		return "Deleted imports_exports id - " + imports_exportsId;
	}
	
	
	/*@GetMapping("/apothema/{type}/{productid}")
	public List<Imports_exports> apothema(@PathVariable String type, @PathVariable int productid){
		List<Imports_exports> a = imports_exportsService.findapothema(type,productid);
				
		if (a == null) {
			throw new RuntimeException(" imports_exports not found - ");
		}
	
		return a;
		
	}*/
	
	
	
	
	
	
	
	
	

}
