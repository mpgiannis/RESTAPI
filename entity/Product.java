package springboot.askisi3.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="barcode")
	private int barcode;
	
	@Column(name="measure_unit")
	private String measure_unit;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="product_id")
	private List<Imports_exports> imports_exports;
	
		
	// define constructors
	
	public Product() {
		
	}

	

	public Product(String name, String description, int barcode, String measure_unit) {
		super();
		this.name = name;
		this.description = description;
		this.barcode = barcode;
		this.measure_unit = measure_unit;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public int getBarcode() {
		return barcode;
	}



	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}



	public String getMeasure_unit() {
		return measure_unit;
	}



	public void setMeasure_unit(String measure_unit) {
		this.measure_unit = measure_unit;
	}


	

	public List<Imports_exports> getImports_exports() {
		return imports_exports;
	}



	public void setImports_exports(List<Imports_exports> imports_exports) {
		this.imports_exports = imports_exports;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", description=" + description + ", barcode=" + barcode
				+ ", measure_unit=" + measure_unit + "]";
	}



	
	

		
}











