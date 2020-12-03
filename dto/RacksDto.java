package springboot.askisi3.dto;

import springboot.askisi3.entity.Racks;

public class RacksDto {
	
	Integer id;
	
	String description;
	
	Integer storeId;
	public RacksDto() {}
	
	public RacksDto(Racks rack) {
		
		this.id=rack.getId();
		this.description=rack.getDescription();
		this.storeId=rack.getStore().getId();
	
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

	
	
	
	
}
