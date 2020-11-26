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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="racks")
public class Racks {
	
	
	// define fields
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
		
		@Column(name="description")
		private String description;
		
		@ManyToOne
		@JoinColumn(name="stores_id")
		private int stores_id;
		
		@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
		@JoinColumn(name="rack_id")
		private List<Imports_exports> imports_exports;

		
		
		public Racks() {}


		public Racks(String description, int stores_id) {
			
			this.description = description;
			this.stores_id = stores_id;
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


		public int getStores_id() {
			return stores_id;
		}


		public void setStores_id(int stores_id) {
			this.stores_id = stores_id;
		}




		public List<Imports_exports> getImports_exports() {
			return imports_exports;
		}


		public void setImports_exports(List<Imports_exports> imports_exports) {
			this.imports_exports = imports_exports;
		}


		@Override
		public String toString() {
			return "Racks [id=" + id + ", description=" + description + ", stores_id=" + stores_id + "]";
		}
		
		
		
}
