package org.nirvanasms.api.core.interfaces;

import org.nirvanasms.api.core.entity.ApiUser;
import org.nirvanasms.api.core.entity.PhoneNumber;
import org.nirvanasms.api.core.exceptions.NonValidPhoneNumberException;
import org.nirvanasms.api.core.utility.ProcessResult;

public interface IBlackList {
	ProcessResult<?> add(ApiUser user, PhoneNumber phoneNumber) throws NonValidPhoneNumberException;
}
