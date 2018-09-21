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
    public class HeaderOperations : HeaderBase
    {
        public override ProcessResult<string[]> Query(ApiUser apiUser)
        {
            Dictionary<string, string> queryStrings = new Dictionary<string, string>();
            queryStrings.Add("username", apiUser.UserName);
            queryStrings.Add("password", apiUser.ApiPassword);
            HttpRequest request = new HttpRequest(Constants.HeaderQueryUrl, queryStrings, Enums.RequestMethod.Get);
            string response = request.GetResponse();
            ProcessResult<string[]> result = new ProcessResult<string[]>(response);
            if (result.IsSuccess)
            {
                string[] headers = response.Substring(2).Split('|');
                result.Data = headers;
            }
            return result;
        }
    }
}
