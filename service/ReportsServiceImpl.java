package springboot.askisi3.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.askisi3.dao.ReportsRepository;
import springboot.askisi3.dto.ReportsDto;
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
	public ReportsDto save(ReportsDto theReportsDto) {
		 reportsRepository.save(dtoToEntity(theReportsDto));
		return theReportsDto;
	}
	

	@Override
	public ReportsDto update(ReportsDto newReportsDto) {
        Optional<Reports> oldReports = reportsRepository.findById(newReportsDto.getId());
		
		
        Reports updateReports = null;
		
		if(oldReports.isPresent()) {
			
			
			updateReports=reportsRepository.save(dtoToEntity(newReportsDto));
		}
		else {
			throw new RuntimeException("Did not found Reports id :"+ newReportsDto.getId());
			
		}
	
		
		return new ReportsDto(updateReports);	
	}


	
	
	@Override
	public void deleteById(int theId) {
		reportsRepository.deleteById(theId);
		
	}

	
	
	
	@Override
	public List<ReportsDto> findbyDateRep(LocalDate dateRep) {
   
		   List<Reports> result = reportsRepository.findByDateRep(dateRep);
			
			if (result!=null) {
				return ReportsListToDtoList(result);
					
			}
			else {
				
				throw new RuntimeException("Did not find Date_rep - " + dateRep);
			}

	}
	

	public Reports dtoToEntity(ReportsDto reportsDto) {
		
		Reports reports = new Reports();
		
		reports.setId(reportsDto.getId());
		reports.setDateRep(reportsDto.getDateRep());
		reports.setType(reportsDto.getType());
		reports.setDescriptionReason(reportsDto.getDescriptionReason());
		reports.setReceivedDeliveredBy(reportsDto.getReceivedDeliveredBy());
		reports.setInfos(reportsDto.getInfos());
		
		return reports;
	}
	
	
	
	public List<ReportsDto> ReportsListToDtoList(List<Reports> entitylist)
	{
		List<ReportsDto> listDto = new ArrayList<>();
		for(Reports reports : entitylist) {
			ReportsDto temp = new ReportsDto(reports);
			listDto.add(temp);			
		   }

		return listDto;
	 }

}
