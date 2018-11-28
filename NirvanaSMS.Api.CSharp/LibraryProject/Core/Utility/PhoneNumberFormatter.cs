using NirvanaSMS.Api.Core.Base;
using NirvanaSMS.Api.Core.Entity;
using System.Text.RegularExpressions;

namespace NirvanaSMS.Api.Core.Utility
{
    public class PhoneNumberFormatter : FormatterBase<PhoneNumber, PhoneNumber>
    {
        ValidNumber providerValidNumberType = ValidNumber.Type4;

        public override PhoneNumber Format(PhoneNumber phoneNumber)
        {
            phoneNumber.Number.Trim();
            ValidNumber numberType = IsPhoneNumber(phoneNumber.Number);
            bool isValid = numberType != ValidNumber.NonValid;
            bool isProviderPhoneNumber = IsProviderPhoneNumber(numberType);
            if (isValid && isProviderPhoneNumber)
                phoneNumber.IsValid = true;
            else if (isValid && !isProviderPhoneNumber)
            {
                //changing number to valid format
                switch (numberType)
                {
                    case ValidNumber.Type1:
                        phoneNumber.Number = changeToValidFormat(phoneNumber.Number);
                        break;
                    case ValidNumber.Type2:
                        phoneNumber.Number = changeToValidFormat(phoneNumber.Number);
                        break;
                    case ValidNumber.Type3:
                        phoneNumber.Number = changeToValidFormat(phoneNumber.Number);
                        break;
                }
                phoneNumber.IsValid = true;
            }
            else
                phoneNumber.IsValid = false;
            return phoneNumber;
        }

        private ValidNumber IsPhoneNumber(string input)
        {
            string[] patterns = new string[] {
                @" ([\+]90?[ ])(\(5+[0-9]{2}\)[ ])([0-9]{3})([\-])([0-9]{2})([\-])([0-9]{2})", //Type 1
                @"([\+]90?)([ ]?)(\([0-9]{3}\))([ ]?)([0-9]{3})(\s*[\-]?)([0-9]{2})(\s*[\-]?)([0-9]{2})", //Type 2
                @"(([\+]90?)|([0]?))([ ]?)(\([0-9]{3}\))([ ]?)([0-9]{3})(\s*[\-]?)([0-9]{2})(\s*[\-]?)([0-9]{2})", //Type 3
                @"(([\+]90?)|([0]?))([ ]?)((\([0-9]{3}\))|([0-9]{3}))([ ]?)([0-9]{3})(\s*[\-]?)([0-9]{2})(\s*[\-]?)([0-9]{2})" //Type 4 - Provider
            };

          for(int i = 0; i < patterns.Length; i++)
            {
                string item = patterns[i];
                if (Regex.Match(input, item, RegexOptions.IgnoreCase).Success)
                    return (ValidNumber)i;
            }

            return ValidNumber.NonValid;
        }
        //905 076982056
        private bool IsProviderPhoneNumber(ValidNumber number)
        {
            return number == providerValidNumberType;
        }

        string changeToValidFormat(string type3Number)
        {
            string type4Result = "";
            type4Result = type3Number.Replace("(", "").Replace(")", "");
            return type4Result;
        }

        enum ValidNumber
        {
            NonValid = -1,
            Type1 = 0,
            Type2 = 1,
            Type3 = 2,
            Type4 = 3,
        }
    }
}
