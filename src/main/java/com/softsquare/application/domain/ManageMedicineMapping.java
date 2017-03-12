package com.softsquare.application.domain;

public class ManageMedicineMapping {
	private Integer medicineID;
	private String medicineName;
	private Integer medicineCost;
	private String type;
	private Integer typeID;
	
	
	public Integer getMedicineID() {
		return medicineID;
	}
	public void setMedicineID(Integer medicineID) {
		this.medicineID = medicineID;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public Integer getMedicineCost() {
		return medicineCost;
	}
	public void setMedicineCost(Integer medicineCost) {
		this.medicineCost = medicineCost;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getTypeID() {
		return typeID;
	}
	public void setTypeID(Integer typeID) {
		this.typeID = typeID;
	}
	
	
	
}