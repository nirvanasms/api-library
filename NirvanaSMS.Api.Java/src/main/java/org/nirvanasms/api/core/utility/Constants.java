package org.nirvanasms.api.core.utility;

public class Constants {
	static String ApiDomain = "http://panel.1sms.com.tr";
	static String ApiPort = "8080";
	static String ApiDirectory = "api";
	
	public static String providerXmlDateFormat = "yyyy.M.dd.HH.m.s";

	public static String BlackListAddUrl = String.format("%s:%s/%s/blacklistadd/V1", ApiDomain, ApiPort, ApiDirectory);
	public static String HeaderQueryUrl = String.format("%s:%s/%s/originator/v1", ApiDomain, ApiPort, ApiDirectory);
	public static String CreditQueryUrl = String.format("%s:%s/%s/credit/v1", ApiDomain, ApiPort, ApiDirectory);
	public static String SendSMSGetUrl = String.format("%s:%s/%s/smsget/v1", ApiDomain, ApiPort, ApiDirectory);
	public static String SendSMSPostUrl = String.format("%s:%s/%s/smspost/v1", ApiDomain, ApiPort, ApiDirectory);
	public static String ReportUrl = String.format("%s:%s/%s/dlr/v1", ApiDomain, ApiPort, ApiDirectory);

}
