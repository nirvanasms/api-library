using NirvanaSMS.Api.Core.Entity;
using NirvanaSMS.Api.Core.Utility;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NirvanaSMS.Api.Core.Interface
{
    interface ICredit
    {
        ProcessResult<Credit> Query(ApiUser apiUser);
    }
}
