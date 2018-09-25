package org.nirvanasms.api.core.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.nirvanasms.api.core.base.MessageBuilder;
import org.nirvanasms.api.core.entity.OneToManyMessage;
import org.nirvanasms.api.core.entity.PhoneNumber;

public class OneToManyMessageBuilder extends MessageBuilder<OneToManyMessage, OneToManyMessageBuilder> {

	private String message;
	private List<PhoneNumber> gsmNumbers;
	
	@Override
	public OneToManyMessageBuilder validity(int validity) {
		super.setValidityTime(validity);
		return this;
	}

	@Override
	public OneToManyMessageBuilder header(String header) {
		super.setHeader(header);
		return this;
	}

	@Override
	public OneToManyMessageBuilder sendDateTime(String dateString,String datePattern) {
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
	public OneToManyMessageBuilder sendDateTime(Date dateTime) {
		super.setSendDateTime(dateTime);
		return null;
	}

	@Override
	public OneToManyMessage build() {
		return new OneToManyMessage(this);
	}

	public String getMessage() {
		return message;
	}

	public OneToManyMessageBuilder message(String message) {
		this.message = message;
		return this;
	}

	public List<PhoneNumber> getGsmNumbers() {
		return gsmNumbers;
	}

	public OneToManyMessageBuilder gsmNumbers(List<PhoneNumber> gsmNumbers) {
		this.gsmNumbers = gsmNumbers;
		return this;
	}
	
}
