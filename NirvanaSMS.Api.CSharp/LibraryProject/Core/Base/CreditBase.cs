using NirvanaSMS.Api.Core.Interface;
using NirvanaSMS.Api.Core.Entity;
using NirvanaSMS.Api.Core.Utility;

namespace NirvanaSMS.Api.Core.Base
{
    public abstract class CreditBase : ICredit
    {
        public abstract ProcessResult<Credit> Query(ApiUser apiUser);
    }
}
