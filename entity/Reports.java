package springboot.askisi3.entity;

import java.util.Date;
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
@Table(name="reports")
public class Reports {
	
	
	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="date_rep")
	private Date date_rep;
	
	@Column(name="type")
	private String type;
	
	@Column(name="description_reason")
	private String description_reason;
	
	@Column(name="received_delivered_by")
	private String received_delivered_by;
	
	@Column(name="infos")
	private String infos;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="reports_id")
	private List<Imports_exports> imports_exports;
	
	public Reports() {}

	public Reports(Date date_rep,String type, String description_reason, String received_delivered_by, String infos) {
		
		this.date_rep =  date_rep;
		this.type = type;
		this.description_reason = description_reason;
		this.received_delivered_by = received_delivered_by;
		this.infos = infos;
	
	}

	public Date getDate_rep() {
		return date_rep;
	}

	public void setDate_rep(Date date_rep) {
		this.date_rep = date_rep;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription_reason() {
		return description_reason;
	}

	public void setDescription_reason(String description_reason) {
		this.description_reason = description_reason;
	}

	public String getReceived_delivered_by() {
		return received_delivered_by;
	}

	public void setReceived_delivered_by(String received_delivered_by) {
		this.received_delivered_by = received_delivered_by;
	}

	public String getInfos() {
		return infos;
	}

	public void setInfos(String infos) {
		this.infos = infos;
	}

	public List<Imports_exports> getImports_exports() {
		return imports_exports;
	}

	public void setImports_exports(List<Imports_exports> imports_exports) {
		this.imports_exports = imports_exports;
	}

	@Override
	public String toString() {
		return "Reports [id=" + id + ", date_rep=" + date_rep + ", type=" + type + ", description_reason="
				+ description_reason + ", received_delivered_by=" + received_delivered_by + ", infos=" + infos
				+ ", imports_exports=" + imports_exports + "]";
	}

	


	
	
	
	
	

}
