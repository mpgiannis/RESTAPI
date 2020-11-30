package springboot.askisi3.service;

import java.util.Date;
import java.util.List;

import springboot.askisi3.entity.Reports;

public interface ReportsService {
	public List<Reports> findAll();
	
	public Reports findById(int theId);
	
	public void save(Reports theReports);
	
	public void deleteById(int theId);
	
	public List<Reports> findbyDateRep(Date dateRep);
	

	
}
