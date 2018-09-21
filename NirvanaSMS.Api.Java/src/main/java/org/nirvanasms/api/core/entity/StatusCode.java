package org.nirvanasms.api.core.entity;

public class StatusCode {
	private String code;
	private String name;
	private String description;
	private boolean isSuccess;
	
	public StatusCode(){}
	
	public StatusCode(String code, String name, String description){
		this.code = code;
		this.name = name;
		this.description = description;
	}
	
	public StatusCode(String code, String name, String description, boolean isSuccess){
		this.code = code;
		this.name = name;
		this.description = description;
		this.isSuccess = isSuccess;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	
}
