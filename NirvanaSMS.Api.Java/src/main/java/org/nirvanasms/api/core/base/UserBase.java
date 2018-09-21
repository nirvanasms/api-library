package org.nirvanasms.api.core.base;

import org.nirvanasms.api.core.interfaces.IUser;

public class UserBase implements IUser {
	private String userName;
	private String apiPassword;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getApiPassword() {
		return apiPassword;
	}
	public void setApiPassword(String apiPassword) {
		this.apiPassword = apiPassword;
	}
	
}
