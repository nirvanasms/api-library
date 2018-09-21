package org.nirvanasms.api.core.exceptions;

@SuppressWarnings("serial")
public class NonValidPhoneNumberException extends Exception {
	public NonValidPhoneNumberException(String message){
		super(message);
	}
}
