package org.nirvanasms.api.core.base;

import java.util.HashMap;
import java.util.Map;

import org.nirvanasms.api.core.entity.ApiUser;
import org.nirvanasms.api.core.entity.PhoneNumber;
import org.nirvanasms.api.core.exceptions.NonValidPhoneNumberException;
import org.nirvanasms.api.core.interfaces.IBlackList;
import org.nirvanasms.api.core.utility.Constants;
import org.nirvanasms.api.core.utility.Enums;
import org.nirvanasms.api.core.utility.Enums.RequestMethod;
import org.nirvanasms.api.core.utility.HttpRequest;
import org.nirvanasms.api.core.utility.ProcessResult;

public class BlackListBase implements IBlackList {

	@SuppressWarnings("rawtypes")
	@Override
	public ProcessResult<?> add(ApiUser apiUser, PhoneNumber phoneNumber) throws NonValidPhoneNumberException {

		Map<String, String> getItems = new HashMap<String, String>();
		if (phoneNumber.isValid()) {
			getItems.put("username", apiUser.getUserName());
			getItems.put("password", apiUser.getApiPassword());
			getItems.put("gsm", phoneNumber.getNumber());
			HttpRequest request = new HttpRequest(Constants.BlackListAddUrl,getItems,RequestMethod.Get);
			String requestResult = request.getResponse();
			return new ProcessResult(requestResult);
		}
		throw new NonValidPhoneNumberException("Numara geçerli bir formata sahip değil.");
	}

}
