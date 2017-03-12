package com.softsquare.application.report;

import java.util.Map;

public class ReportParameter {

	private String format;
	private String name;
	private String program;
	private String roleId;
	private Map<String, String>paramsRpt;
	
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public Map<String, String> getParamsRpt() {
		return paramsRpt;
	}
	public void setParamsRpt(Map<String, String> paramsRpt) {
		this.paramsRpt = paramsRpt;
	}
}
