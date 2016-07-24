package jwd.parcijalni.web.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import jwd.parcijalni.model.Activity;
import jwd.parcijalni.model.Log;


public class ActivityDTO {
	
	private Long id;
	private String name;
	private Date updated;
	private String descroption;
	private Integer logCount;
	private List<Double> ocene = new ArrayList<>();
	
	public ActivityDTO() {
		super();
	}
	
	public ActivityDTO(Activity activity){
		super();
		this.id = activity.getId();
		this.name = activity.getName();
		this.logCount = 0;
	}
	public ActivityDTO(String name) {
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
