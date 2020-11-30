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

import springboot.askisi3.entity.Reports;
import springboot.askisi3.service.ReportsService;

@RestController
@RequestMapping("/api")
public class ReportsRestController {
	private ReportsService reportsService;
	
	
	@Autowired
	public ReportsRestController(ReportsService theReportsService) {
		reportsService = theReportsService;
	}
	
	@GetMapping("/reports")
	public List<Reports> findAll() {
		return reportsService.findAll();
	}

	
	
	@GetMapping("/reports/{reportsId}")
	public Reports getReports(@PathVariable int reportsId) {		
		Reports theReports = reportsService.findById(reportsId);
		
		if (theReports == null) {
			throw new RuntimeException("Reports id not found - " + reportsId);
		}
		
		return theReports;
	}
	

	
		@PostMapping("/reports")
		public Reports addReports(@RequestBody Reports theReports) {
			theReports.setId(0);
			reportsService.save(theReports);			
			return theReports;
		}
		
	
		
		@PutMapping("/reports")
		public Reports updateReports(@RequestBody Reports theReports) {
			reportsService.save(theReports);
			return theReports;
		}

		
		@DeleteMapping("/reports/{reportsId}")
		public String deleteReports(@PathVariable int reportsId) {
			Reports tempReports = reportsService.findById(reportsId);
			
			if (tempReports == null) {
				throw new RuntimeException("Reports id not found - " + reportsId);
			}
			
			reportsService.deleteById(reportsId);
			return "Deleted Reports id - " + reportsId;
		}
		
		
		
		@GetMapping("/reportsdate/{date_rep}")
		public List<Reports> findDateRep(@RequestParam Date dateRep) {
			
			List<Reports> tempReports = reportsService.findbyDateRep(dateRep);
			
			if (tempReports == null) {
				throw new RuntimeException("Reports not found - " + dateRep);
			}
		
		
			return tempReports;
		
		}
	
	
	
	
}
