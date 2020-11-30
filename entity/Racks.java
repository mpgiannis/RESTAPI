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

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
		@Column(name="stores_id", insertable = false, updatable = false)
		private int storesId;
		
		@OneToMany(mappedBy = "rack",orphanRemoval = true, cascade=CascadeType.ALL, fetch=FetchType.LAZY)
		private List<ImportsExports> importsExports;

		
		@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
		@JoinColumn(name = "stores_id" )
		private Stores store;
		
		
		public Racks() {}


		public Racks(String description, int stores_id) {
			
			this.description = description;
			this.storesId = stores_id;
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


		public int getStoresId() {
			return storesId;
		}


		public void setStoresId(int storesid) {
			this.storesId = storesid;
		}



		
		public List<ImportsExports> getImports_exports() {
			return importsExports;
		}


		public void setImports_exports(List<ImportsExports> importsExports) {
			this.importsExports = importsExports;
		}

		@JsonIgnore
		public Stores getStore() {
			return store;
		}


		public void setStore(Stores store) {
			this.store = store;
		}


		@Override
		public String toString() {
			return "Racks [id=" + id + ", description=" + description + ", stores_id=" + storesId + "]";
		}
		
		
		
}
