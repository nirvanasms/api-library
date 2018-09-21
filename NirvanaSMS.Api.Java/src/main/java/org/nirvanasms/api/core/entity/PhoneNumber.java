package org.nirvanasms.api.core.entity;

public class PhoneNumber {
	private String number;
	private boolean isValid;
	
	public PhoneNumber(){}
	
	public PhoneNumber(String phoneNumber){
		this.number = phoneNumber;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
}
