package org.nirvanasms.api.core.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.nirvanasms.api.core.interfaces.IFormatter;

public class DateFormatter {

	public static String format(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(Constants.providerXmlDateFormat);
		return formatter.format(date);
	}

}
