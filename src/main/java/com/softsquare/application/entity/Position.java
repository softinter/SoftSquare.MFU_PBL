package com.softsquare.application.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "POSITION")
public class Position extends BaseEntity  implements Serializable{
	
	private static final long serialVersionUID = 6019490232774665113L;

	@Id
    @GeneratedValue
    @Column(name = "POSITIONID")
	private Integer positionID;
	
	@NotEmpty
	@Column(name = "POSITIONCODE",  nullable = false)
	private String positionCode;
	
	@Column(name = "POSITIONNAME",  nullable = false)
	private String positionName;
	
	@Column(name = "POSITIONDETAIL", nullable = false)
	private String positionDetail;

	public Integer getPositionID() {
		return positionID;
	}

	public void setPositionID(Integer positionID) {
		this.positionID = positionID;
	}

	public String getPositionCode() {
		return positionCode;
	}

	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getPositionDetail() {
		return positionDetail;
	}

	public void setPositionDetail(String positionDetail) {
		this.positionDetail = positionDetail;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}}



	