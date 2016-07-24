package jwd.parcijalni.model;

import java.util.Date;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tbl_log")
public class Log {
	
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	@Column
	private Integer duration;
	
	@ManyToOne
	@JoinColumn(name="activity_id")
	private Activity activity;
	

	public Log() {
		super();
	}

	public Log(Date date, Integer duration, Activity activity) {
		super();
		this.date = date;
		this.duration = duration;
		this.activity = activity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	
	

}
