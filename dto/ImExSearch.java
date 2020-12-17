package springboot.askisi3.dto;

public class ImExSearch {
	
	Integer productId;
	
	String typeRep;

	public ImExSearch(Integer productId, String typeRep) {

		this.productId = productId;
		this.typeRep = typeRep;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getTypeRep() {
		return typeRep;
	}

	public void setTypeRep(String typeRep) {
		this.typeRep = typeRep;
	}

	@Override
	public String toString() {
		return "ImExSearch [productId=" + productId + ", typeRep=" + typeRep + "]";
	}
	

}
