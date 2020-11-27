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
public class Imports_exports {
	
	
	// define fields
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
		
		@Column(name="reports_id")
		private int reports_id;
		
		@Column(name="product_id")
		private int product_id;
		
		@Column(name="rack_id")
		private int rack_id;
		
		@Column(name="amount")
		private int amount;
	
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="rack_id", insertable = false, updatable = false)
		private Racks rack;
		
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="product_id", insertable = false, updatable = false)
		private Product product;
		
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="reports_id", insertable = false, updatable = false)
		private Reports report;
		


	public Imports_exports() {}


	public Imports_exports(int reports_id, int product_id, int rack_id, int amount) {
	
		this.reports_id = reports_id;
		this.product_id = product_id;
		this.rack_id = rack_id;
		this.amount = amount;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getReports_id() {
		return reports_id;
	}


	public void setReports_id(int reports_id) {
		this.reports_id = reports_id;
	}


	public int getProduct_id() {
		return product_id;
	}


	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}


	public int getRack_id() {
		return rack_id;
	}


	public void setRack_id(int rack_id) {
		this.rack_id = rack_id;
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
		return "Imports_Exports [id=" + id + ", reports_id=" + reports_id + ", product_id=" + product_id + ", rack_id="
				+ rack_id + ", amount=" + amount + "]";
	}
	
	
	
	

}
