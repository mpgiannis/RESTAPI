package springboot.askisi3.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.askisi3.dao.ReportsRepository;
import springboot.askisi3.entity.Reports;


@Service
public class ReportsServiceImpl implements ReportsService {
	private ReportsRepository reportsRepository;

	
	@Autowired
	public ReportsServiceImpl(ReportsRepository theReportsRepository) {
		reportsRepository = theReportsRepository;
	}
	
	
	
	
	@Override
	public List<Reports> findAll() {
		// TODO Auto-generated method stub
		return reportsRepository.findAll();
	}

	@Override
	public Reports findById(int theId) {
		
       Optional<Reports> result = reportsRepository.findById(theId);
		
       Reports theReports = null;
		
		if (result.isPresent()) {
			theReports = result.get();
		}
		else {
			// we didn't find the reports
			throw new RuntimeException("Did not find reports id - " + theId);
		}
		
		return theReports;
	}

	@Override
	public void save(Reports theReports) {
		 reportsRepository.save(theReports);
		
	}

	@Override
	public void deleteById(int theId) {
		reportsRepository.deleteById(theId);
		
	}
/*
	@Override
	public List<Reports> findbyDate_rep(Date date_rep) {
		
		   List<Reports> result = reportsRepository.findByDate_rep(date_rep);
			
			if (result!=null) {
				return result;
					
			}
			else {
				
				throw new RuntimeException("Did not find Date_rep - " + date_rep);
			}

	}
    */
}
