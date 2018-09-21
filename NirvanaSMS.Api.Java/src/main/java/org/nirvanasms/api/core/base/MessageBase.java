package org.nirvanasms.api.core.base;

import java.util.Date;

public abstract class MessageBase {
	private String header;
	private Date sendDateTime;
	private int validityTime;
	
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public Date getSendDateTime() {
		return sendDateTime;
	}
	public void setSendDateTime(Date sendDateTime) {
		this.sendDateTime = sendDateTime;
	}
	public int getValidityTime() {
		return validityTime;
	}
	public void setValidityTime(int validityTime) {
		this.validityTime = validityTime;
	}
}
