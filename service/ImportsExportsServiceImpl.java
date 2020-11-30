package springboot.askisi3.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.askisi3.dao.ImportsExportsRepository;
import springboot.askisi3.entity.ImportsExports;

@Service
public class ImportsExportsServiceImpl implements ImportsExportsService {
	
private ImportsExportsRepository importsExportsRepository;
	
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
	public void save(ImportsExports theImports_Exports) {
		importsExportsRepository.save(theImports_Exports);
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

	@Override
	public List<ImportsExports> findapothema(Date date, int productid) {
		List<ImportsExports> result = importsExportsRepository.findApothema(date, productid);
		
		List<ImportsExports> theImportsExports = null;
		
		if (result!=null) {
			theImportsExports = importsExportsRepository.findApothema(date, productid);
				
		}
		else {
			
			throw new RuntimeException("Did not find theImportsExports - ");
		}
		
		return theImportsExports;
		
	
	

	}
}
