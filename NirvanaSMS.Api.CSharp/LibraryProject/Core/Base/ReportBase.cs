using NirvanaSMS.Api.Core.Interface;
using System.Collections.Generic;
using NirvanaSMS.Api.Core.Entity;
using NirvanaSMS.Api.Core.Utility;

namespace NirvanaSMS.Api.Core.Base
{
    public abstract class ReportBase : IReport
    {
        public virtual ProcessResult<List<NumberReport>> GetReport(UserBase apiUser, string messageId)
        {
            return null;
        }
    }
}
