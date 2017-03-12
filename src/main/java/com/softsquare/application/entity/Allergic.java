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
@Table(name = "ALLERGIC")
public class Allergic extends BaseEntity  implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7130471867789749891L;

	@Id
    @GeneratedValue
    @Column(name = "ALLERGICID")
	private Integer allergicId;
	
	@NotEmpty
	@Column(name = "ALLERGICCODE", nullable = false)
	private String allergicCode;
	
	@Column(name = "ALLERGICNAME", nullable = false)
	private String allergicName;
	
	@Column(name = "ALLERGICDETAIL", nullable = false)
	private String allergicDetail;
	
	@Column(name = "PATIENTID", unique=true, nullable = false)
	private Integer patientId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PATIENTID", referencedColumnName = "PATIENTID", insertable=false, updatable=false)
    private Patient patient;

	

	public Integer getAllergicId() {
		return allergicId;
	}

	public void setAllergicId(Integer allergicId) {
		this.allergicId = allergicId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAllergicCode() {
		return allergicCode;
	}

	public void setAllergicCode(String allergicCode) {
		this.allergicCode = allergicCode;
	}

	public String getAllergicName() {
		return allergicName;
	}

	public void setAllergicName(String allergicName) {
		this.allergicName = allergicName;
	}

	public String getAllergicDetail() {
		return allergicDetail;
	}

	public void setAllergicDetail(String allergicDetail) {
		this.allergicDetail = allergicDetail;
	}


	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
	
}
