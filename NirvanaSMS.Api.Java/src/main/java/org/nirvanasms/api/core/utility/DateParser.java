package org.nirvanasms.api.core.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {

	public static Date parse(String inputDateString, String inputPattern) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(inputPattern);
		return formatter.parse(inputDateString);

	}

}
