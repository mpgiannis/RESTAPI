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
@Table(name="stores")
public class Stores {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="description")
	private String description;
	
	

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="stores_id")
	private List<Racks> racks;
	
	
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
