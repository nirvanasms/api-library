using NirvanaSMS.Api.Core.Entity;
using NirvanaSMS.Api.Core.Utility;

namespace NirvanaSMS.Api.Core.Interface
{
    interface ICredit
    {
        ProcessResult<Credit> Query(ApiUser apiUser);
    }
}
