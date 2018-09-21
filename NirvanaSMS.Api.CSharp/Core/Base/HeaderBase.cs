using NirvanaSMS.Api.Core.Interface;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NirvanaSMS.Api.Core.Entity;
using NirvanaSMS.Api.Core.Utility;

namespace NirvanaSMS.Api.Core.Base
{
    public abstract class HeaderBase : IHeader
    {
        public abstract ProcessResult<string[]> Query(ApiUser apiUser);
    }
}
