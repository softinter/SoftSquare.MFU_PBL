package com.softsquare.application.domain;

public class ManageAllergicMapping {
	
	private Integer allergicId;
	private String allergicCode;
	private String allergicName;
	private String allergicDetail;
	private String patient;
	private Integer patientId;
	
	public Integer getAllergicId() {
		return allergicId;
	}
	public void setAllergicId(Integer allergicId) {
		this.allergicId = allergicId;
	}
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
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
	public String getPatient() {
		return patient;
	}
	public void setPatient(String patient) {
		this.patient = patient;
	}
	
	
	

}
