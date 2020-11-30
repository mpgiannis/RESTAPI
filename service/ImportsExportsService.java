package springboot.askisi3.service;

import java.util.Date;
import java.util.List;

import springboot.askisi3.entity.ImportsExports;

public interface ImportsExportsService {
	
public List<ImportsExports> findAll();
	
	public ImportsExports findById(int theId);
	
	public void save(ImportsExports theImports_Exports);
	
	public void deleteById(int theId);

	
	
	public List<ImportsExports> findapothema(Date date,int productId);
	
	public List<ImportsExports> findbyProduct_id(int productid);
	
}
