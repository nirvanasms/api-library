using NirvanaSMS.Api.Business.Interface;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NirvanaSMS.Api.Core.Entity;
using NirvanaSMS.Api.Core.Utility;
using NirvanaSMS.Api.Core.Interface;
using NirvanaSMS.Api.Core.Exceptions;

namespace NirvanaSMS.Api.Core.Base
{
    public abstract class BlackListBase : IBlackList
    {
        public virtual ProcessResult Add(ApiUser apiUser, PhoneNumber phoneNumber)
        {
            Dictionary<string, string> getItems = new Dictionary<string, string>();
            if (phoneNumber.IsValid)
            {
                getItems.Add("username", apiUser.UserName);
                getItems.Add("password", apiUser.ApiPassword);
                getItems.Add("gsm", phoneNumber.Number);
                HttpRequest request = new HttpRequest(Constants.BlackListAddUrl,getItems,Enums.RequestMethod.Get);
                string requestResult = request.GetResponse();
                return new ProcessResult(requestResult);
            }
            throw new NonValidPhoneNumberException("Numara geçerli bir formata sahip değil.");
        }
    }
}
