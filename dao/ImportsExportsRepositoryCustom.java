package springboot.askisi3.dao;
import java.util.List;

import springboot.askisi3.dto.ImExDto;
import springboot.askisi3.dto.ImExSearch;
import springboot.askisi3.entity.ImportsExports;

public interface ImportsExportsRepositoryCustom  {
	
	public List<ImportsExports> findByDateAndProductId(String str,int id);
	
	public List<ImExDto> searchImEx(ImExSearch search);

}
