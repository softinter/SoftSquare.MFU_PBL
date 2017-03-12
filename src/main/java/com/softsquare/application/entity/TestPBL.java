package com.softsquare.application.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TEST_TBL")
public class TestPBL  implements Serializable{

	private static final long serialVersionUID = -2768779089820435003L;

	@Id
	@Column(name = "HID")
    private Integer hid;
	
	@NotNull
	@Column(name = "DID", nullable = false)
    private Integer did;
	
	@Lob
	@Column(name = "IMAGE")
	public byte[] image;

	public Integer getHid() {
		return hid;
	}

	public void setHid(Integer hid) {
		this.hid = hid;
	}

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}
