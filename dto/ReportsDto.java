package springboot.askisi3.dto;

import java.time.LocalDate;
import java.util.List;

import springboot.askisi3.entity.Reports;
import springboot.askisi3.service.ImportsExportsService;

public class ReportsDto {

	private ImportsExportsService imexService;
	
	private Integer id;
	
	private LocalDate dateRep;
	
	private String type;
	
	private String descriptionReason;
	
	private String receivedDeliveredBy;
	
	private String infos;
	
	 List<ImportsExportsDto> importsExportsDto;
	
	public ReportsDto() {}
	
	public ReportsDto(Reports reports) {
		this.id=reports.getId();
		this.dateRep=reports.getDateRep();
		this.type=reports.getType();
		this.descriptionReason=reports.getDescriptionReason();
		this.receivedDeliveredBy=reports.getReceivedDeliveredBy();
		this.infos=reports.getInfos();
		this.importsExportsDto=imexService.ImportsExportsListToDtoList(reports.getImports_exports());
		
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDateRep() {
		return dateRep;
	}

	public void setDateRep(LocalDate dateRep) {
		this.dateRep = dateRep;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescriptionReason() {
		return descriptionReason;
	}

	public void setDescriptionReason(String descriptionReason) {
		this.descriptionReason = descriptionReason;
	}

	public String getReceivedDeliveredBy() {
		return receivedDeliveredBy;
	}

	public void setReceivedDeliveredBy(String receivedDeliveredBy) {
		this.receivedDeliveredBy = receivedDeliveredBy;
	}

	public String getInfos() {
		return infos;
	}

	public void setInfos(String infos) {
		this.infos = infos;
	}

	public List<ImportsExportsDto> getImportsExportsDto() {
		return importsExportsDto;
	}

	public void setImportsExportsDto(List<ImportsExportsDto> importsExportsDto) {
		this.importsExportsDto = importsExportsDto;
	}
	
	
	
}
