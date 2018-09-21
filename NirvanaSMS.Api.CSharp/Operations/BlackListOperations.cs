using NirvanaSMS.Api.Core.Base;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NirvanaSMS.Api.Core.Entity;
using NirvanaSMS.Api.Core.Utility;
using NirvanaSMS.Api.Core.Interface;

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
