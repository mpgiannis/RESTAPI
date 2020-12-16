package springboot.askisi3.dto;

import java.util.ArrayList;
import java.util.List;

import springboot.askisi3.entity.Racks;
import springboot.askisi3.entity.Stores;

public class StoresDto {
	
	
	Integer id;
	
	String description;
	
	List<RacksDto> racks ;
	
	public StoresDto() {}


	public StoresDto(Stores store) {
		
		this.id =store.getId();
		this.description = store.getDescription();
		List<RacksDto> racksDto = new ArrayList<RacksDto>();
		for(Racks rack : store.getRacks()) {
			racksDto.add(new RacksDto(rack));			
		   }
		this.racks=racksDto;
		
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

	public List<RacksDto> getRacks() {
		return racks;
	}

	public void setRacks(List<RacksDto> racksDto) {
		this.racks = racksDto;
	}
	
	

}
