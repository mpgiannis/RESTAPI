package springboot.askisi3.dto;

import java.util.ArrayList;
import java.util.List;

import springboot.askisi3.entity.ImportsExports;
import springboot.askisi3.entity.Racks;

public class RacksDto {

	
	Integer id;
	
	String description;
	
	Integer storeId;
	
	List<ImportsExportsDto> importsExports;
	
	public RacksDto() {}
	
	public RacksDto(Racks rack) {
		
		this.id=rack.getId();
		this.description=rack.getDescription();
		this.storeId=rack.getStore().getId();
		if(rack.getImportsExports()!=null) {
			List<ImportsExportsDto> importsExportsDto =new ArrayList<ImportsExportsDto>();
			for(ImportsExports imex : rack.getImportsExports()) {
				importsExportsDto.add(new ImportsExportsDto(imex));			
			}
		    this.importsExports=importsExportsDto;
	    }
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public List<ImportsExportsDto> getImportsExports() {
		return importsExports;
	}

	public void setImportsExports(List<ImportsExportsDto> importsExportsDto) {
		this.importsExports = importsExportsDto;
	}

	
	
	
	
}
