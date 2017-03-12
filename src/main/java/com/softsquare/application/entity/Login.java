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
@Table(name = "LOGIN")
public class Login extends BaseEntity implements Serializable{

	private static final long serialVersionUID = -117259679410559094L;

	@Id
	@GeneratedValue
	@Column(name = "LGID")
    private Integer id;
	
	@Column(name = "LGUSERNAME", unique=true, nullable = false)
    private String username;
	
	@Column(name = "LGPASSWORD", nullable = false)
    private String password;
    
	@Column(name = "LGROLEID", nullable = false)
    private Integer roleId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LGROLEID", referencedColumnName = "ROLEID", insertable=false, updatable=false)
    private Role role;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}