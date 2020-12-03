package springboot.askisi3.dto;

import springboot.askisi3.entity.Stores;

public class StoresDto {
	
	Integer id;
	
	String description;
	public StoresDto() {}

	public StoresDto(Stores store) {
		
		this.id =store.getId();
		this.description = store.getDescription();
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
	
	

}
