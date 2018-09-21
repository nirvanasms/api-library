package org.nirvanasms.api.core.entity;

public class PhoneAndMessagePair {
	private PhoneNumber number;
    private String message;

    public PhoneAndMessagePair()
    {

    }

    public PhoneAndMessagePair(PhoneNumber number, String message)
    {
        this.number = number;
        this.message = message;
    }

    public PhoneAndMessagePair(String number, String message)
    {
        this.number = new PhoneNumber(number);
        this.message = message;
    }

	public PhoneNumber getNumber() {
		return number;
	}

	public void setNumber(PhoneNumber number) {
		this.number = number;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
