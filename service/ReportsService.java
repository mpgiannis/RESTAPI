package springboot.askisi3.service;

import java.time.LocalDate;
import java.util.List;

import springboot.askisi3.dto.ReportsDto;
import springboot.askisi3.entity.Reports;

public interface ReportsService {
	public List<Reports> findAll();
	
	public Reports findById(int theId);
	
	public ReportsDto save(ReportsDto theReportsDto);
	
	public void deleteById(int theId);
	
	public ReportsDto update(ReportsDto newReports);
	
	public List<ReportsDto> findbyDateRep(LocalDate dateRep);
	
	public List<ReportsDto> ReportsListToDtoList(List<Reports> entitylist);
	

	
}
