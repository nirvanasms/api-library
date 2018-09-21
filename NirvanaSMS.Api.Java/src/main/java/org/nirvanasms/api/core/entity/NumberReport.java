package org.nirvanasms.api.core.entity;

public class NumberReport {
	private PhoneNumber number;
	private StatusCode statusCode;
	
	public NumberReport(PhoneNumber number, StatusCode statusCode)
    {
        this.number = number;
        this.statusCode = statusCode;
    }

	public PhoneNumber getNumber() {
		return number;
	}

	public void setNumber(PhoneNumber number) {
		this.number = number;
	}

	public StatusCode getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(StatusCode statusCode) {
		this.statusCode = statusCode;
	}
}
