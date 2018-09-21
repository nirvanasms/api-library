package org.nirvanasms.api.core.utility;

import org.nirvanasms.api.core.base.FormatterBase;
import org.nirvanasms.api.core.entity.PhoneNumber;

public class PhoneNumberFormatter extends FormatterBase<PhoneNumber, PhoneNumber> {
	ValidNumber providerValidNumberType = ValidNumber.Type4;

	@Override
	public PhoneNumber format(PhoneNumber phoneNumber) {
		phoneNumber.setNumber(phoneNumber.getNumber().trim());
		ValidNumber numberType = IsPhoneNumber(phoneNumber.getNumber());
		boolean isValid = numberType != ValidNumber.NonValid;
		boolean isProviderPhoneNumber = isProviderPhoneNumber(numberType);
		if (isValid && isProviderPhoneNumber)
			phoneNumber.setValid(true);
		else if (isValid && !isProviderPhoneNumber) {
			// changing number to valid format
			switch (numberType) {
			case Type1:
				phoneNumber.setNumber(changeToValidFormat(phoneNumber.getNumber()));
				break;
			case Type2:
				phoneNumber.setNumber(changeToValidFormat(phoneNumber.getNumber()));
				break;
			case Type3:
				phoneNumber.setNumber(changeToValidFormat(phoneNumber.getNumber()));
				break;
			default:
				break;
			}
			phoneNumber.setValid(true);
		} else
			phoneNumber.setValid(false);
		return phoneNumber;
	}

	private ValidNumber IsPhoneNumber(String input) {
		String[] patterns = { "([\\+]90?[ ])(\\(5+[0-9]{2}\\)[ ])([0-9]{3})([\\-])([0-9]{2})([\\-])([0-9]{2})", // Type
																												// 1
				"([\\+]90?)([ ]?)(\\([0-9]{3}\\))([ ]?)([0-9]{3})(\\s*[\\-]?)([0-9]{2})(\\s*[\\-]?)([0-9]{2})", // Type
																												// 2
				"(([\\+]90?)|([0]?))([ ]?)(\\([0-9]{3}\\))([ ]?)([0-9]{3})(\\s*[\\-]?)([0-9]{2})(\\s*[\\-]?)([0-9]{2})", // Type
																															// 3
				"(([\\+]90?)|([0]?))([ ]?)((\\([0-9]{3}\\))|([0-9]{3}))([ ]?)([0-9]{3})(\\s*[\\-]?)([0-9]{2})(\\s*[\\-]?)([0-9]{2})" // Type
																																		// 4
																																		// //
																																		// -
																																		// //
																																		// Provider
		};

		for (int i = 0; i < patterns.length; i++) {
			String item = patterns[i];
			if (input.matches(item))
				return ValidNumber.values()[i];
		}

		return ValidNumber.NonValid;
	}

	private boolean isProviderPhoneNumber(ValidNumber number) {
		return number == providerValidNumberType;
	}

	private String changeToValidFormat(String type3Number) {
		String type4Result = "";
		type4Result = type3Number.replace("(", "").replace(")", "");
		return type4Result;
	}

	enum ValidNumber {
		NonValid, Type1, Type2, Type3, Type4
	}

}
