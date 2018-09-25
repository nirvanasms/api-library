using NirvanaSMS.Api.Core.Base;
using NirvanaSMS.Api.Core.Entity;
using NirvanaSMS.Api.Core.Utility;

namespace NirvanaSMS.Api.Operations
{
    public class BlackListOperations : BlackListBase
    {
        public override ProcessResult Add(ApiUser apiUser, PhoneNumber phoneNumber)
        {
            PhoneNumberFormatter formatter = new PhoneNumberFormatter();
            PhoneNumber formattedNumber = formatter.Format(phoneNumber);
            return base.Add(apiUser,formattedNumber);
        }
    }
}
