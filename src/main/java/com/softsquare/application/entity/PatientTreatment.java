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
@Table(name = "PATIENTTREATMENT")
public class PatientTreatment extends BaseEntity  implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -6681051524052450042L;

	@Id
    @GeneratedValue
    @Column(name = "PATIENTTREATMENTID")
	private Integer patienttreatmentId;
	
	@NotEmpty
	@Column(name = "PATIENTTREATMENTDISEASENAME", nullable = false)
	private String patienttreatmentDiseaseName;
	
	@Column(name = "PATIENTTREATMENTDATE", nullable = false)
	private String patienttreatmentDate;
	
	@Column(name = "PATIENTTREATMENTHEARTRATE", nullable = false)
	private String patienttreatmentHeartRate;
	
	@Column(name = "PATIENTTREATMENTPRESSURE", nullable = false)
	private String patienttreatmentPressure;

	@Column(name = "PATIENTTREATMENTAGE", nullable = false)
	private Integer patienttreatmentAge;
	
	@Column(name = "PATIENTTREATMENTWEIGHT", nullable = false)
	private String patienttreatmentWeight;
		
	@Column(name = "PATIENTTREATMENTHEIGHT", nullable = false)
	private String patienttreatmentHeight;
	
	@Column(name = "PATIENTTREATMENTSTATUS", nullable = false)
	private String patienttreatmentStatus;
	
	@Column(name = "PATIENTID", unique=true, nullable = false)
	private Integer patientId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PATIENTID", referencedColumnName = "PATIENTID", insertable=false, updatable=false)
    private Patient patient;
	
		
	public Integer getPatienttreatmentId() {
		return patienttreatmentId;
	}

	public void setPatienttreatmentId(Integer patienttreatmentId) {
		this.patienttreatmentId = patienttreatmentId;
	}

	public String getPatienttreatmentDiseaseName() {
		return patienttreatmentDiseaseName;
	}

	public void setPatienttreatmentDiseaseName(String patienttreatmentDiseaseName) {
		this.patienttreatmentDiseaseName = patienttreatmentDiseaseName;
	}

	public String getPatienttreatmentDate() {
		return patienttreatmentDate;
	}

	public void setPatienttreatmentDate(String patienttreatmentDate) {
		this.patienttreatmentDate = patienttreatmentDate;
	}

	public String getPatienttreatmentHeartRate() {
		return patienttreatmentHeartRate;
	}

	public void setPatienttreatmentHeartRate(String patienttreatmentHeartRate) {
		this.patienttreatmentHeartRate = patienttreatmentHeartRate;
	}

	public String getPatienttreatmentPressure() {
		return patienttreatmentPressure;
	}

	public void setPatienttreatmentPressure(String patienttreatmentPressure) {
		this.patienttreatmentPressure = patienttreatmentPressure;
	}
	
	public Integer getPatienttreatmentAge() {
		return patienttreatmentAge;
	}

	public void setPatienttreatmentAge(Integer patienttreatmentAge) {
		this.patienttreatmentAge = patienttreatmentAge;
	}

	public String getPatienttreatmentWeight() {
		return patienttreatmentWeight;
	}

	public void setPatienttreatmentWeight(String patienttreatmentWeight) {
		this.patienttreatmentWeight = patienttreatmentWeight;
	}

	public String getPatienttreatmentHeight() {
		return patienttreatmentHeight;
	}

	public void setPatienttreatmentHeight(String patienttreatmentHeight) {
		this.patienttreatmentHeight = patienttreatmentHeight;
	}

	public String getPatienttreatmentStatus() {
		return patienttreatmentStatus;
	}

	public void setPatienttreatmentStatus(String patienttreatmentStatus) {
		this.patienttreatmentStatus = patienttreatmentStatus;
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
