package org.nirvanasms.api.operations;

import org.nirvanasms.api.core.base.BlackListBase;
import org.nirvanasms.api.core.entity.ApiUser;
import org.nirvanasms.api.core.entity.PhoneNumber;
import org.nirvanasms.api.core.exceptions.NonValidPhoneNumberException;
import org.nirvanasms.api.core.utility.PhoneNumberFormatter;
import org.nirvanasms.api.core.utility.ProcessResult;

public class BlackListOperations extends BlackListBase {
	@Override
	public ProcessResult<?> add(ApiUser apiUser, PhoneNumber phoneNumber) throws NonValidPhoneNumberException{
		 PhoneNumberFormatter formatter = new PhoneNumberFormatter();
         PhoneNumber formattedNumber = formatter.format(phoneNumber);
         return super.add(apiUser,formattedNumber);
	}
}
