package com.softsquare.application.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "PATIENT")
public class Patient extends BaseEntity  implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7217449819765365203L;

	@Id
    @GeneratedValue
    @Column(name = "PATIENTID")
	private Integer patientId;
	
	@NotEmpty
	@Column(name = "PATIENTNAME", nullable = false)
	private String patientName;
	
	@Column(name = "PATIENTBIRTHDAY", nullable = false)
	private String patientBirthday;
	
	@Column(name = "PATIENTADDRESS", nullable = false)
	private String patientAddress;

	@Column(name = "PATIENTPHONE", nullable = false)
	private String patientPhone;
	
	@Column(name = "PATIENTEMAIL", nullable = false)
	private String patientEmail;
	
	@Column(name = "PATIENTGENDER", nullable = false)
	private String patientGender;
	
	@Column(name = "PATIENTJOB", nullable = false)
	private String patientJob;
	
	@Column(name = "PATIENTBLOODGROUP", nullable = false)
	private String patientBloodGroup;

	

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientBirthday() {
		return patientBirthday;
	}

	public void setPatientBirthday(String patientBirthday) {
		this.patientBirthday = patientBirthday;
	}

	public String getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}

	public String getPatientPhone() {
		return patientPhone;
	}

	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
	}

	public String getPatientEmail() {
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	public String getPatientGender() {
		return patientGender;
	}

	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}

	public String getPatientJob() {
		return patientJob;
	}

	public void setPatientJob(String patientJob) {
		this.patientJob = patientJob;
	}

	public String getPatientBloodGroup() {
		return patientBloodGroup;
	}

	public void setPatientBloodGroup(String patientBloodGroup) {
		this.patientBloodGroup = patientBloodGroup;
	}

	

}
