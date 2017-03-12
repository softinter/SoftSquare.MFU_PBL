package com.softsquare.application.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CALENDAR")
public class Calendar extends BaseEntity implements Serializable{

	private static final long serialVersionUID = -4237515934267167298L;

	@Id
	@Column(name = "CID")
    private Integer cId;
	
	@Column(name = "CTITLE")
    private String cTitle;
	
	@Column(name = "CDESC")
    private String cDesc;
	
	@Column(name = "CSTARTDATE")
    private Date cStartDate;
	
	@Column(name = "CSTARTTIME")
    private String cStartTime;
    
	@Column(name = "CENDDATE")
    private Date cEndDate;
	
	@Column(name = "CENDTIME")
    private String cEndTime;

	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}
	
	public String getcDesc() {
		return cDesc;
	}

	public void setcDesc(String cDesc) {
		this.cDesc = cDesc;
	}

	public String getcTitle() {
		return cTitle;
	}

	public void setcTitle(String cTitle) {
		this.cTitle = cTitle;
	}

	public Date getcStartDate() {
		return cStartDate;
	}

	public void setcStartDate(Date cStartDate) {
		this.cStartDate = cStartDate;
	}

	public String getcStartTime() {
		return cStartTime;
	}

	public void setcStartTime(String cStartTime) {
		this.cStartTime = cStartTime;
	}

	public Date getcEndDate() {
		return cEndDate;
	}

	public void setcEndDate(Date cEndDate) {
		this.cEndDate = cEndDate;
	}

	public String getcEndTime() {
		return cEndTime;
	}

	public void setcEndTime(String cEndTime) {
		this.cEndTime = cEndTime;
	}
	
}