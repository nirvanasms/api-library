using NirvanaSMS.Api.Core.Base;
using NirvanaSMS.Api.Core.Entity;
using NirvanaSMS.Api.Core.Utility;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NirvanaSMS.Api.Core.Interface
{
    public interface IReport
    {
        ProcessResult<List<NumberReport>> GetReport(UserBase apiUser, string messageId);
    }
}
