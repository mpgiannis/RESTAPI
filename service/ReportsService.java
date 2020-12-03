package springboot.askisi3.service;

import java.util.Date;
import java.util.List;

import springboot.askisi3.dto.ReportsDto;
import springboot.askisi3.entity.Reports;

public interface ReportsService {
	public List<Reports> findAll();
	
	public Reports findById(int theId);
	
	public void save(ReportsDto theReportsDto);
	
	public void deleteById(int theId);
	
	public ReportsDto update(ReportsDto newReports);
	
	public List<Reports> findbyDateRep(Date dateRep);
	

	
}
