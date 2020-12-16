package springboot.askisi3.service;


import java.time.LocalDate;
import java.util.List;

import springboot.askisi3.dto.ImExDto;
import springboot.askisi3.dto.ImExSearch;
import springboot.askisi3.dto.ImportsExportsDto;
import springboot.askisi3.entity.ImportsExports;

public interface ImportsExportsService {
	
    public List<ImportsExports> findAll();
	
	public ImportsExports findById(int theId);
	
	public ImportsExportsDto save(ImportsExportsDto theImportsExportsDto);
	
	public void deleteById(int theId);

	public ImportsExportsDto update(ImportsExportsDto newImportsExports);
	
	public List<ImportsExports> findbyProduct_id(int productid);
	
	public List<ImportsExportsDto> ImportsExportsListToDtoList(List<ImportsExports> entitylist);
	
	public List<ImportsExports> findapothema(String date,int productId);
	
	public List<ImExDto> searchImEx(ImExSearch search);
	
}
