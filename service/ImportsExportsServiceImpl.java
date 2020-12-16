package springboot.askisi3.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.askisi3.dao.ImportsExportsRepository;
import springboot.askisi3.dto.ImExDto;
import springboot.askisi3.dto.ImExSearch;
import springboot.askisi3.dto.ImportsExportsDto;
import springboot.askisi3.entity.ImportsExports;
import springboot.askisi3.entity.Product;
import springboot.askisi3.entity.Racks;
import springboot.askisi3.entity.Reports;

@Service
public class ImportsExportsServiceImpl implements ImportsExportsService {
	
private ImportsExportsRepository importsExportsRepository;
@Autowired
private ReportsService reportsService;
@Autowired
private ProductService productService;
@Autowired
private RacksService racksService;


@Autowired
	public ImportsExportsServiceImpl(ImportsExportsRepository theImports_ExportsRepository) {
		importsExportsRepository = theImports_ExportsRepository;
	
	}
	
	@Override
	public List<ImportsExports> findAll() {
		return importsExportsRepository.findAll();
	
	}

	@Override
	public ImportsExports findById(int theId) {
		Optional<ImportsExports> result = importsExportsRepository.findById(theId);
		
		ImportsExports theImports_Exports = null;
		
		if (result.isPresent()) {
			theImports_Exports = result.get();
		}
		else {
			
			throw new RuntimeException("Did not find Imports_Exports id - " + theId);
		}
		
		return theImports_Exports;
	}

	@Override
	public ImportsExportsDto save(ImportsExportsDto theImportsExportsDto) {
		
		Reports report = reportsService.findById(theImportsExportsDto.getReportId());
		ImportsExportsDto imex =null;
		if(report!=null) {
			Product product = productService.findById(theImportsExportsDto.getProductId());
			if(product!=null) {
				Racks rack = racksService.findById(theImportsExportsDto.getRackId());
				    
				if(rack!=null) {
					importsExportsRepository.save(dtoToEntity(theImportsExportsDto));
				    imex=theImportsExportsDto;
				}
				else {
					
					throw new RuntimeException("Did not found rack with this id :"+ theImportsExportsDto.getRackId());
				   }	
			}
			else 
			{
				throw new RuntimeException("Did not found product with this id :"+ theImportsExportsDto.getProductId());
			}
			
		}
		else 
		{
			throw new RuntimeException("Did not found report with this id :"+ theImportsExportsDto.getReportId());
		}
		return imex;
	}
	
	
	@Override
	public ImportsExportsDto update(ImportsExportsDto newImportsExportsDto) {
		
		Optional<ImportsExports> oldImportsExports = importsExportsRepository.findById(newImportsExportsDto.getId());
		
		
		ImportsExports updateImportsExports = null;
		
         if(oldImportsExports.isPresent()) {
			
			
        	 updateImportsExports=importsExportsRepository.save(dtoToEntity(newImportsExportsDto));
            
		}
		else {
			throw new RuntimeException("Did not found ImportsExports id :"+ newImportsExportsDto.getId());
			
		}
		
         return new ImportsExportsDto(updateImportsExports);
		
	}

	@Override
	public void deleteById(int theId) {
		importsExportsRepository.deleteById(theId);
	}

	@Override
	public List<ImportsExports> findbyProduct_id(int product_id) {
		List<ImportsExports> result = importsExportsRepository.findByProduct_id(product_id);
		if (result!=null) {
			return result;
				
		}
		else {
			
			throw new RuntimeException("Did not find Date_rep - " + product_id);
		}
	}
	
	
	
	
	public ImportsExports dtoToEntity(ImportsExportsDto importexportDto) {
		
		ImportsExports imex = new ImportsExports();
		
		imex.setId(importexportDto.getId());
		imex.setReport(reportsService.findById(importexportDto.getReportId()));
		imex.setProduct(productService.findById(importexportDto.getProductId()));
		imex.setRack(racksService.findById(importexportDto.getRackId()));
		imex.setAmount(importexportDto.getAmount());
		return imex;
	}
	
	
	
	public List<ImportsExportsDto> ImportsExportsListToDtoList(List<ImportsExports> entitylist)
	{
		List<ImportsExportsDto> listDto = new ArrayList<>();
		for(ImportsExports imex : entitylist) {
			ImportsExportsDto temp = new ImportsExportsDto(imex);
			listDto.add(temp);			
		   }

		return listDto;
	 }


	@Override
	public List<ImportsExports> findapothema(String date, int productid) {
		List<ImportsExports> result = importsExportsRepository.findByDateAndProductId(date, productid);
		
		List<ImportsExports> theImportsExports = null;
		
		if (result!=null) {
			theImportsExports =result;
				
		}
		else {
			
			throw new RuntimeException("Did not find theImportsExports - ");
		}
		
		return theImportsExports;
		
	
	

	}

	@Override
	public List<ImExDto> searchImEx(ImExSearch search) {
		// TODO Auto-generated method stub
		return importsExportsRepository.searchImEx(search);
	}
	



}
