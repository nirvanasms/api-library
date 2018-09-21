package org.nirvanasms.api.core.utility;

import org.nirvanasms.api.core.base.FormatterBase;
import org.nirvanasms.api.core.base.MessageBase;
import org.nirvanasms.api.core.entity.ManyToManyMessage;
import org.nirvanasms.api.core.entity.PhoneAndMessagePair;

public class ManyToManyMessageFormatter extends FormatterBase<ManyToManyMessage, MessageBase> {
	@Override
	public ManyToManyMessage format(MessageBase messages) {
		PhoneNumberFormatter phoneNumberFormatter = new PhoneNumberFormatter();
		ManyToManyMessage _messages = (ManyToManyMessage) messages;
		for (PhoneAndMessagePair item : _messages.getPhonesAndMessages()) {
			phoneNumberFormatter.format(item.getNumber());
		}
		return _messages;
	}
}
