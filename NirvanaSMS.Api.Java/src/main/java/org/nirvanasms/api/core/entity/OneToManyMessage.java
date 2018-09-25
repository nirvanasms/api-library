package org.nirvanasms.api.core.entity;

import java.util.List;

import org.nirvanasms.api.core.base.MessageBase;
import org.nirvanasms.api.core.utility.OneToManyMessageBuilder;

public class OneToManyMessage extends MessageBase {
	private String message;
	private List<PhoneNumber> gsmNumbers;
	
	public OneToManyMessage(){}
	
	public OneToManyMessage(OneToManyMessageBuilder builder){
		super.setHeader(builder.getHeader());
		this.message = builder.getMessage();
		this.gsmNumbers = builder.getGsmNumbers();
		super.setValidityTime(builder.getValidityTime());
		super.setSendDateTime(builder.getSendDateTime());
	}
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
	
	public OneToManyMessageBuilder builder(){
		return new OneToManyMessageBuilder();
	}
}
