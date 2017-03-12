package com.softsquare.application.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "TYPE")
public class Type extends BaseEntity  implements Serializable {
	
	private static final long serialVersionUID = 6019490232774665003L;

	@Id
    @GeneratedValue
    @Column(name = "TYPEID")
	private Integer typeID;
	
	@NotEmpty
	@Column(name = "TYPECODE", unique=true, nullable = false)
	private String typeCode;
	
	@Column(name = "TYPENAME", unique=true, nullable = false)
	private String typeName;

	public Integer getTypeID() {
		return typeID;
	}

	public void setTypeID(Integer typeID) {
		this.typeID = typeID;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	

	

}
	

	