using NirvanaSMS.Api.Core.Base;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NirvanaSMS.Api.Core.Entity;
using NirvanaSMS.Api.Core.Utility;

namespace NirvanaSMS.Api.Operations
{
    public class CreditOperations : CreditBase
    {
        public override ProcessResult<Credit> Query(ApiUser apiUser)
        {
            Dictionary<string, string> queryStrings = new Dictionary<string, string>();
            queryStrings.Add("username", apiUser.UserName);
            queryStrings.Add("password", apiUser.ApiPassword);
            HttpRequest request = new HttpRequest(Constants.CreditQueryUrl, queryStrings, Enums.RequestMethod.Get);
            string response = request.GetResponse();
            ProcessResult<Credit> result = new ProcessResult<Credit>(response);
            if (result.IsSuccess)
            {
                int amount = int.Parse(response.Substring(2));
                result.Data = new Credit(amount);
            }
            return result;
        }
    }
}
