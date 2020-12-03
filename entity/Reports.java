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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="reports")
public class Reports {
	
	
	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="date_rep")
	private Date dateRep;
	
	@Column(name="type")
	private String type;
	
	@Column(name="description_reason")
	private String descriptionReason;
	
	@Column(name="received_delivered_by")
	private String receivedDeliveredBy;
	
	@Column(name="infos")
	private String infos;
	
	@OneToMany(mappedBy = "report",orphanRemoval = true, cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<ImportsExports> importsExports;
	
	public Reports() {}

	public Reports(Date date_rep,String type, String description_reason, String received_delivered_by, String infos) {
		
		this.dateRep =  date_rep;
		this.type = type;
		this.descriptionReason = description_reason;
		this.receivedDeliveredBy = received_delivered_by;
		this.infos = infos;
	
	}

	public Date getDateRep() {
		return dateRep;
	}

	public void setDateRep(Date dateRep) {
		this.dateRep = dateRep;
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

	public String getDescriptionReason() {
		return descriptionReason;
	}

	public void setDescriptionReason(String description_reason) {
		this.descriptionReason = description_reason;
	}

	public String getReceivedDeliveredBy() {
		return receivedDeliveredBy;
	}

	public void setReceivedDeliveredBy(String received_delivered_by) {
		this.receivedDeliveredBy = received_delivered_by;
	}

	public String getInfos() {
		return infos;
	}

	public void setInfos(String infos) {
		this.infos = infos;
	}
	@JsonIgnore
	public List<ImportsExports> getImports_exports() {
		return importsExports;
	}

	public void setImports_exports(List<ImportsExports> importsExports) {
		this.importsExports = importsExports;
	}

	@Override
	public String toString() {
		return "Reports [id=" + id + ", date_rep=" + dateRep + ", type=" + type + ", description_reason="
				+ descriptionReason + ", received_delivered_by=" + receivedDeliveredBy + ", infos=" + infos
				+ ", imports_exports=" + importsExports + "]";
	}

	


	
	
	
	
	

}
