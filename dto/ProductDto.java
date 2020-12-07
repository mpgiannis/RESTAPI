package springboot.askisi3.dto;

import java.util.List;

import springboot.askisi3.entity.Product;
import springboot.askisi3.service.ImportsExportsService;

public class ProductDto {

	private ImportsExportsService imexService;
	
	Integer id;
	
	String name;
	
	String description;
	
	Integer barcode;
	
	String measureUnit;
	
	List<ImportsExportsDto> importsExportsDto;
	
	public ProductDto() {}
	
	public ProductDto(Product product) {
		
		this.id=product.getId();
		this.name=product.getName();
		this.description=product.getDescription();
		this.barcode=product.getBarcode();
		this.measureUnit=product.getMeasure_unit();
		this.importsExportsDto=imexService.ImportsExportsListToDtoList(product.getImports_exports());
		
		
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
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



	public Integer getBarcode() {
		return barcode;
	}



	public void setBarcode(Integer barcode) {
		this.barcode = barcode;
	}



	public String getMeasureUnit() {
		return measureUnit;
	}



	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}

	public List<ImportsExportsDto> getImportsExportsDto() {
		return importsExportsDto;
	}

	public void setImportsExportsDto(List<ImportsExportsDto> importsExportsDto) {
		this.importsExportsDto = importsExportsDto;
	}
	
	
	
	
	
	

}
