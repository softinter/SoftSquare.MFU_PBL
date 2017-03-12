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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "MEDICINE")
public class Medicine extends BaseEntity implements Serializable{

	private static final long serialVersionUID = -117259679410559094L;

	@Id
	@GeneratedValue
	@Column(name = "MEDICINEID")
    private Integer medicineID;
	
	@Column(name = "MEDICINENAME", unique=true, nullable = false)
    private String medicineName;
	
	@Column(name = "MEDICINECOST", nullable = false)
    private Integer medicineCost;
	
	@Column(name = "TYPEID", nullable = false)
    private Integer typeID;
	
	

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TYPEID", referencedColumnName = "TYPEID", insertable=false, updatable=false)
    private Type type;
	

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

	public Integer getTypeID() {
		return typeID;
	}

	public void setTypeID(Integer typeID) {
		this.typeID = typeID;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
}