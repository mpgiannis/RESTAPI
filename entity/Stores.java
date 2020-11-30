package springboot.askisi3.entity;

import java.util.ArrayList;
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
@Table(name="stores")
public class Stores {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="description")
	private String description;
	
	
	
	@OneToMany(mappedBy = "store",orphanRemoval = true, cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Racks> racks = new ArrayList<>();

	public Stores() {}



	public Stores(String description) {

		this.description = description;
	
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public List<Racks> getRacks() {
		return racks;
	}



	public void setRacks(List<Racks> racks) {
		this.racks = racks;
	}



	@Override
	public String toString() {
		return "Stores [id=" + id + ", description=" + description +  "]";
	}
	
	
	
}
