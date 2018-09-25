package org.nirvanasms.api.core.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.nirvanasms.api.core.base.MessageBuilder;
import org.nirvanasms.api.core.entity.ManyToManyMessage;
import org.nirvanasms.api.core.entity.OneToManyMessage;
import org.nirvanasms.api.core.entity.PhoneAndMessagePair;

public class ManyToManyMessageBuilder extends MessageBuilder<ManyToManyMessage, ManyToManyMessageBuilder> {

	private List<PhoneAndMessagePair> phonesAndMessages;

	public List<PhoneAndMessagePair> getPhonesAndMessages() {
		return phonesAndMessages;
	}

	public void setPhonesAndMessages(List<PhoneAndMessagePair> phonesAndMessages) {
		this.phonesAndMessages = phonesAndMessages;
	}

	@Override
	public ManyToManyMessageBuilder validity(int validity) {
		super.setValidityTime(validity);
		return this;
	}

	@Override
	public ManyToManyMessageBuilder header(String header) {
		super.setHeader(header);
		return this;
	}

	@Override
	public ManyToManyMessageBuilder sendDateTime(String dateString,String datePattern) {
		Date inputDate;
		try {
			inputDate = DateParser.parse(dateString, datePattern);
			String formattedDateString = DateFormatter.format(inputDate);
			Date formattedDate = DateParser.parse(formattedDateString, Constants.providerXmlDateFormat);
			super.setSendDateTime(formattedDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return this;
	}

	@Override
	public ManyToManyMessageBuilder sendDateTime(Date dateTime) {
		super.setSendDateTime(dateTime);
		return this;
	}

	@Override
	public ManyToManyMessage build() {
		return new ManyToManyMessage(this);
	}

}
