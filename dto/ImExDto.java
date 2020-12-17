package springboot.askisi3.dto;

public class ImExDto {

	private Integer id;
	
	private Integer repId;
	
	private String repType;
	
	private Integer storeId;
	
	private Integer rackId;
	
	private Integer productId;
	
	private String productName;
	
	private Integer amount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRepId() {
		return repId;
	}

	public void setRepId(Integer repId) {
		this.repId = repId;
	}

	public String getRepType() {
		return repType;
	}

	public void setRepType(String repType) {
		this.repType = repType;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Integer getRackId() {
		return rackId;
	}

	public void setRackId(Integer rackId) {
		this.rackId = rackId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "ImExDto [id=" + id + ", repId=" + repId + ", repType=" + repType + ", storeId=" + storeId + ", rackId="
				+ rackId + ", productId=" + productId + ", productName=" + productName + ", amount=" + amount + "]";
	}
	

	
	
}
