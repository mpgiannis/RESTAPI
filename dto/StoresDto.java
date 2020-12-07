package springboot.askisi3.dto;

import java.util.List;

import springboot.askisi3.entity.Stores;
import springboot.askisi3.service.RacksService;

public class StoresDto {
	private RacksService racksService;
	
	Integer id;
	
	String description;
	
	List<RacksDto> racksDto;
	public StoresDto() {}


	public StoresDto(Stores store) {
		
		this.id =store.getId();
		this.description = store.getDescription();
		this.racksDto=racksService.RacksListToDtoList(store.getRacks());
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

	public List<RacksDto> getRacksDto() {
		return racksDto;
	}

	public void setRacksDto(List<RacksDto> racksDto) {
		this.racksDto = racksDto;
	}
	
	

}
