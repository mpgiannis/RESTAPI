package springboot.askisi3.dto;

import java.util.Date;

import springboot.askisi3.entity.Reports;

public class ReportsDto {

	
	private Integer id;
	
	private Date dateRep;
	
	private String type;
	
	private String descriptionReason;
	
	private String receivedDeliveredBy;
	
	private String infos;
	
	public ReportsDto() {}
	
	public ReportsDto(Reports reports) {
		this.id=reports.getId();
		this.dateRep=reports.getDateRep();
		this.type=reports.getType();
		this.descriptionReason=reports.getDescriptionReason();
		this.receivedDeliveredBy=reports.getReceivedDeliveredBy();
		this.infos=reports.getInfos();
		
		
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateRep() {
		return dateRep;
	}

	public void setDateRep(Date dateRep) {
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
	
	
	
}
