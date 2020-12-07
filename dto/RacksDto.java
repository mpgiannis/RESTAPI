package springboot.askisi3.dto;

import java.util.List;

import springboot.askisi3.entity.Racks;
import springboot.askisi3.service.ImportsExportsService;

public class RacksDto {

	private ImportsExportsService imexService;
	
	Integer id;
	
	String description;
	
	Integer storeId;
	
	List<ImportsExportsDto> importsExportsDto;
	
	public RacksDto() {}
	
	public RacksDto(Racks rack) {
		
		this.id=rack.getId();
		this.description=rack.getDescription();
		this.storeId=rack.getStore().getId();
		this.importsExportsDto=imexService.ImportsExportsListToDtoList(rack.getImports_exports());
	
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

	public List<ImportsExportsDto> getImportsExportsDto() {
		return importsExportsDto;
	}

	public void setImportsExportsDto(List<ImportsExportsDto> importsExportsDto) {
		this.importsExportsDto = importsExportsDto;
	}

	
	
	
	
}
