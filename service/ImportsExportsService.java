package springboot.askisi3.service;


import java.util.List;

import springboot.askisi3.dto.ImportsExportsDto;
import springboot.askisi3.entity.ImportsExports;

public interface ImportsExportsService {
	
    public List<ImportsExports> findAll();
	
	public ImportsExports findById(int theId);
	
	public void save(ImportsExportsDto theImportsExportsDto);
	
	public void deleteById(int theId);

	public ImportsExportsDto update(ImportsExportsDto newImportsExports);
	
	//public List<ImportsExports> findapothema(Date date,int productId);
	
	public List<ImportsExports> findbyProduct_id(int productid);
	
}
