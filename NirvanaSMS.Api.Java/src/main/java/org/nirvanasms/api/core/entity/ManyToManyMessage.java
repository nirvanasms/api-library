package org.nirvanasms.api.core.entity;

import java.util.List;

import org.nirvanasms.api.core.base.MessageBase;

public class ManyToManyMessage extends MessageBase {
	private List<PhoneAndMessagePair> phonesAndMessages;

	public List<PhoneAndMessagePair> getPhonesAndMessages() {
		return phonesAndMessages;
	}

	public void setPhonesAndMessages(List<PhoneAndMessagePair> phonesAndMessages) {
		this.phonesAndMessages = phonesAndMessages;
	}
	
}
