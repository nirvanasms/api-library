package org.nirvanasms.api.core.utility;

import org.nirvanasms.api.core.base.FormatterBase;
import org.nirvanasms.api.core.base.MessageBase;
import org.nirvanasms.api.core.entity.OneToManyMessage;
import org.nirvanasms.api.core.entity.PhoneNumber;

public class OneToManyMessageFormatter extends FormatterBase<OneToManyMessage,MessageBase> {
	@Override
	public OneToManyMessage format(MessageBase message){
		PhoneNumberFormatter phoneNumberFormatter = new PhoneNumberFormatter();
        OneToManyMessage _message = (OneToManyMessage)message ;
        for(PhoneNumber number : _message.getGsmNumbers()){
        	phoneNumberFormatter.format(number);
        }
		return _message;
	}
}
