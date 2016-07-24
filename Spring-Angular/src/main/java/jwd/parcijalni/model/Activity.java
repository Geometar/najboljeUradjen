package jwd.parcijalni.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tbl_activity")
public class Activity {
	

	
	public Activity(String name, String descroption) {
		super();
		this.name = name;
		this.descroption = descroption;
	}

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;

	@Column(name="name")
	private String name;
	@Column(name="admin_comment")
	private String adminComment = "test";
	
	@Column
	private String descroption;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="tbl_ocene")
	private List<Double> ocene = new ArrayList<>();
	
	@PreUpdate
	public void Update(){
		updated = new Date();
	}
	
	@PrePersist
	public void Create(){
		created = new Date();
		ocene.add(6.0);
		ocene.add(5.0);
		ocene.add(9.0);
		ocene.add(8.0);
	}
	
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Activity() {
		super();
	}
	
	public Activity(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdminComment() {
		return adminComment;
	}
	public void setAdminComment(String adminComment) {
		this.adminComment = adminComment;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public String getDescroption() {
		return descroption;
	}

	public void setDescroption(String descroption) {
		this.descroption = descroption;
	}

	public List<Double> getOcene() {
		return ocene;
	}

	public void setOcene(List<Double> ocene) {
		this.ocene = ocene;
	}

	

}
