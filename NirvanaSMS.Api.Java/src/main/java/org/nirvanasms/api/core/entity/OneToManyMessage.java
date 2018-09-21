package org.nirvanasms.api.core.entity;

import java.util.List;

import org.nirvanasms.api.core.base.MessageBase;

public class OneToManyMessage extends MessageBase {
	private String message;
	private List<PhoneNumber> gsmNumbers;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<PhoneNumber> getGsmNumbers() {
		return gsmNumbers;
	}
	public void setGsmNumbers(List<PhoneNumber> gsmNumbers) {
		this.gsmNumbers = gsmNumbers;
	}	
}
