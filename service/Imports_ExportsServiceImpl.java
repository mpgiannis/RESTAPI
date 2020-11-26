package springboot.askisi3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.askisi3.dao.Imports_ExportsRepository;
import springboot.askisi3.entity.Imports_exports;

@Service
public class Imports_ExportsServiceImpl implements Imports_ExportsService {
	
private Imports_ExportsRepository imports_exportsRepository;
	
	@Autowired
	public Imports_ExportsServiceImpl(Imports_ExportsRepository theImports_ExportsRepository) {
		imports_exportsRepository = theImports_ExportsRepository;
	}
	
	@Override
	public List<Imports_exports> findAll() {
		return imports_exportsRepository.findAll();
	}

	@Override
	public Imports_exports findById(int theId) {
		Optional<Imports_exports> result = imports_exportsRepository.findById(theId);
		
		Imports_exports theImports_Exports = null;
		
		if (result.isPresent()) {
			theImports_Exports = result.get();
		}
		else {
			
			throw new RuntimeException("Did not find Imports_Exports id - " + theId);
		}
		
		return theImports_Exports;
	}

	@Override
	public void save(Imports_exports theImports_Exports) {
		imports_exportsRepository.save(theImports_Exports);
	}

	@Override
	public void deleteById(int theId) {
		imports_exportsRepository.deleteById(theId);
	}

	/*@Override
	public List<Imports_exports> findapothema(String type, int productid) {
		List<Imports_exports> result = imports_exportsRepository.findApothema(type, productid);
		
		List<Imports_exports> theImports_Exports = null;
		
		if (result!=null) {
			theImports_Exports = imports_exportsRepository.findApothema(type, productid);
				
		}
		else {
			// we didn't find the Imports_Exports
			throw new RuntimeException("Did not find theImports_Exports - ");
		}
		
		return theImports_Exports;
		
	
	

	}*/
}
