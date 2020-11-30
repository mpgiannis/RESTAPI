package springboot.askisi3.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="barcode")
	private int barcode;
	
	@Column(name="measure_unit")
	private String measureUnit;
	
	@OneToMany(mappedBy = "product",orphanRemoval = true, cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<ImportsExports> importsExports;
	
		
	// define constructors
	
	public Product() {
		
	}

	

	public Product(String name, String description, int barcode, String measure_unit) {
		super();
		this.name = name;
		this.description = description;
		this.barcode = barcode;
		this.measureUnit = measure_unit;
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
		return measureUnit;
	}



	public void setMeasure_unit(String measure_unit) {
		this.measureUnit = measure_unit;
	}


	

	public List<ImportsExports> getImports_exports() {
		return importsExports;
	}



	public void setImports_exports(List<ImportsExports> importsExports) {
		this.importsExports = importsExports;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", description=" + description + ", barcode=" + barcode
				+ ", measure_unit=" + measureUnit + "]";
	}



	
	

		
}











