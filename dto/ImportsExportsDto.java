package springboot.askisi3.dto;

import springboot.askisi3.entity.ImportsExports;

public class ImportsExportsDto {

	Integer id;
	
	Integer reportId;
	
	Integer productId;
	
	Integer rackId;
	
	Integer amount;
	
	public ImportsExportsDto() {}

	public ImportsExportsDto(ImportsExports importexport) {
		
		this.id =importexport.getId();
		this.reportId = importexport.getReport().getId();
		this.productId = importexport.getProduct().getId();
		this.rackId =importexport.getRack().getId();
		this.amount =importexport.getAmount();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getReportId() {
		return reportId;
	}

	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getRackId() {
		return rackId;
	}

	public void setRackId(Integer rackId) {
		this.rackId = rackId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	
	
}
