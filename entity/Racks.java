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
		private Integer id;
		
		@Column(name="description")
		private String description;
	
		@ManyToOne( fetch=FetchType.LAZY)
		@JoinColumn(name = "stores_id" )
		private Stores store;
		
		@OneToMany(mappedBy = "rack", fetch=FetchType.LAZY)
		private List<ImportsExports> importsExports;
		
		public Racks() {}


		public Racks(String description) {
			
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



		
		public Stores getStore() {
			return store;
		}


		public void setStore(Stores store) {
			this.store = store;
		}

		
		public List<ImportsExports> getImportsExports() {
			return importsExports;
		}


		public void setImportsExports(List<ImportsExports> importsExports) {
			this.importsExports = importsExports;
		}


		@Override
		public String toString() {
			return "Racks [id=" + id + ", description=" + description + ", store=" + store + ", importsExports="
					+ importsExports + "]";
		}



	
		
		
}
