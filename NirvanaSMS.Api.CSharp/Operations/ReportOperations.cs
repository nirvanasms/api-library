using NirvanaSMS.Api.Core.Base;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NirvanaSMS.Api.Core.Entity;
using NirvanaSMS.Api.Core.Interface;
using NirvanaSMS.Api.Core.Utility;

namespace NirvanaSMS.Api.Operations
{
    public class ReportOperations : ReportBase
    {
        public override ProcessResult<List<NumberReport>> GetReport(UserBase apiUser, string messageId)
        {
            Dictionary<string, string> queryStrings = new Dictionary<string, string>();
            queryStrings.Add("username", apiUser.UserName);
            queryStrings.Add("password", apiUser.ApiPassword);
            queryStrings.Add("id", messageId);
            HttpRequest request = new HttpRequest(Constants.ReportUrl, queryStrings, Enums.RequestMethod.Get);
            string response = request.GetResponse();
            ProcessResult<List<NumberReport>> result = new ProcessResult<List<NumberReport>>(response);
            if (result.IsSuccess)
            {
                string[] numberReports = response.Substring(3).Split('|');
                List<NumberReport> numberReportsList = new List<NumberReport>();
                foreach (var item in numberReports)
                {
                    string[] numberAndStatus = item.Split(' ');
                    numberReportsList.Add(new NumberReport(new PhoneNumber(numberAndStatus[0]),StatusCodes.GetByCode(numberAndStatus[1])));
                }
                result.Data = numberReportsList;
            }
            return result;
        }
    }
}
