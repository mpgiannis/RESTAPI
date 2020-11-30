package springboot.askisi3.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="imports_exports")
public class ImportsExports {
	
	
	// define fields
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private Integer id;
		
		@Column(name="reports_id", insertable = false, updatable = false)
		private int reportsId;
		
		@Column(name="product_id", insertable = false, updatable = false)
		private int productId;
		
		@Column(name="rack_id", insertable = false, updatable = false)
		private int rackId;
		
		@Column(name="amount")
		private int amount;
	
		@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
		@JoinColumn(name = "rack_id" )
		private Racks rack;
		
		@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
		@JoinColumn(name="product_id")
		private Product product;
		
		@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
		@JoinColumn(name="reports_id")
		private Reports report;
		


	public ImportsExports() {}


	public ImportsExports(int reports_id, int product_id, int rack_id, int amount) {
	
		this.reportsId = reports_id;
		this.productId = product_id;
		this.rackId = rack_id;
		this.amount = amount;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getReports_id() {
		return reportsId;
	}


	public void setReports_id(int reports_id) {
		this.reportsId = reports_id;
	}


	public int getProduct_id() {
		return productId;
	}


	public void setProduct_id(int product_id) {
		this.productId = product_id;
	}


	public int getRack_id() {
		return rackId;
	}


	public void setRack_id(int rack_id) {
		this.rackId = rack_id;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}

	
	
	@JsonIgnore
    public Racks getRack() {
		return rack;
	}


	public void setRack(Racks rack) {
		this.rack = rack;
	}

	@JsonIgnore
	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}

	@JsonIgnore
	public Reports getReport() {
		return report;
	}


	public void setReport(Reports report) {
		this.report = report;
	}


	@Override
	public String toString() {
		return "Imports_Exports [id=" + id + ", reports_id=" + reportsId + ", product_id=" + productId + ", rack_id="
				+ rackId + ", amount=" + amount + "]";
	}
	
	
	
	

}
