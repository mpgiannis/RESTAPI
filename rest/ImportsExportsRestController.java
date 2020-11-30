package springboot.askisi3.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springboot.askisi3.entity.ImportsExports;
import springboot.askisi3.service.ImportsExportsService;

@RestController
@RequestMapping("/imports_exports")
public class ImportsExportsRestController {
	
	
	private ImportsExportsService importsExportsService;
	
	
	@Autowired
	public ImportsExportsRestController(ImportsExportsService theImports_ExportsService) {
		importsExportsService = theImports_ExportsService;
	}
	
	@GetMapping("/imports_exports")
	public List<ImportsExports> findAll() {
		return importsExportsService.findAll();
	}

	
	@GetMapping("/imports_exports/{imports_exportsId}")
	public ImportsExports getImports_Exports(@PathVariable int imports_exportsId) {
		
		ImportsExports theImports_Exports = importsExportsService.findById(imports_exportsId);
		
		if (theImports_Exports == null) {
			throw new RuntimeException("Imports_Exports id not found - " + imports_exportsId);
		}
		
		return theImports_Exports;
	}

	
	@PostMapping("/imports_exports")
	public ImportsExports addImports_Exports(@RequestBody ImportsExports theImports_Exports) {
		theImports_Exports.setId(0);
		importsExportsService.save(theImports_Exports);
		return theImports_Exports;
	}
	
	@PutMapping("/imports_exports")
	public ImportsExports updateImports_Exports(@RequestBody ImportsExports theImports_Exports) {
		importsExportsService.save(theImports_Exports);
		return theImports_Exports;
	}
	
	@DeleteMapping("/imports_exports/{imports_exportsId}")
	public String deleteImports_Exports(@PathVariable int imports_exportsId) {	
		ImportsExports tempImports_Exports = importsExportsService.findById(imports_exportsId);
		if (tempImports_Exports == null) {
			throw new RuntimeException("Imports_Exports id not found - " + imports_exportsId);
		}
		
		importsExportsService.deleteById(imports_exportsId);
		
		return "Deleted imports_exports id - " + imports_exportsId;
	}
	
	
	@GetMapping("/apothema/{date}/{productid}")
	public List<ImportsExports> apothema(@RequestParam Date date, @RequestParam int productid){
		List<ImportsExports> a = importsExportsService.findapothema(date,productid);
				
		if (a == null) {
			throw new RuntimeException(" imports_exports not found - ");
		}
	
		return a;
		
	}
	
	@GetMapping("/apothema/{productid}")
	public int findApothema(@PathVariable int productid) {
		List<ImportsExports> a =importsExportsService.findbyProduct_id(productid);
		if (a == null) {
			throw new RuntimeException("Imports_Exports productid not found - " + productid);
		}
		int apothema=0;
		for (ImportsExports temp : a) {
            if(temp.getReport().getType().equals("import")) {
            	apothema=apothema+temp.getAmount();
            }
            else {
            	apothema=apothema-temp.getAmount();
            }
        }
		
		return apothema;
	}
	
	
	
	
	
	
	

}
