package springboot.askisi3.service;

import java.util.List;

import springboot.askisi3.entity.Imports_exports;

public interface Imports_ExportsService {
	
public List<Imports_exports> findAll();
	
	public Imports_exports findById(int theId);
	
	public void save(Imports_exports theImports_Exports);
	
	public void deleteById(int theId);

	
	
	//public List<Imports_exports> findapothema(String type,int productid);
	
	public List<Imports_exports> findbyProduct_id(int productid);
	
}
