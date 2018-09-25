package org.nirvanasms.api.core.entity;

import java.util.List;

import org.nirvanasms.api.core.base.MessageBase;
import org.nirvanasms.api.core.utility.ManyToManyMessageBuilder;
import org.nirvanasms.api.core.utility.OneToManyMessageBuilder;

public class ManyToManyMessage extends MessageBase {
	private List<PhoneAndMessagePair> phonesAndMessages;

	public ManyToManyMessage() {

	}

	public ManyToManyMessage(ManyToManyMessageBuilder builder) {
		super.setHeader(builder.getHeader());
		this.phonesAndMessages = builder.getPhonesAndMessages();
		super.setValidityTime(builder.getValidityTime());
		super.setSendDateTime(builder.getSendDateTime());
	}

	public List<PhoneAndMessagePair> getPhonesAndMessages() {
		return phonesAndMessages;
	}

	public void setPhonesAndMessages(List<PhoneAndMessagePair> phonesAndMessages) {
		this.phonesAndMessages = phonesAndMessages;
	}

	public ManyToManyMessageBuilder builder(){
		return new ManyToManyMessageBuilder();
	}
}
