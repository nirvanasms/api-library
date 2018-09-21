using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NirvanaSMS.Api.Core.Utility
{
    public class Constants
    {
        static string ApiDomain = "http://panel.1sms.com.tr";
        static string ApiPort = "8080";
        static string ApiDirectory = "api";

        public static string BlackListAddUrl = string.Format("{0}:{1}/{2}/blacklistadd/V1", ApiDomain, ApiPort, ApiDirectory);
        public static string HeaderQueryUrl = string.Format("{0}:{1}/{2}/originator/v1", ApiDomain, ApiPort, ApiDirectory);
        public static string CreditQueryUrl = string.Format("{0}:{1}/{2}/credit/v1", ApiDomain, ApiPort, ApiDirectory);
        public static string SendSMSGetUrl = string.Format("{0}:{1}/{2}/smsget/v1", ApiDomain, ApiPort, ApiDirectory);
        public static string SendSMSPostUrl = string.Format("{0}:{1}/{2}/smspost/v1", ApiDomain, ApiPort, ApiDirectory);
        public static string ReportUrl = string.Format("{0}:{1}/{2}/dlr/v1", ApiDomain, ApiPort, ApiDirectory);
    }
}
