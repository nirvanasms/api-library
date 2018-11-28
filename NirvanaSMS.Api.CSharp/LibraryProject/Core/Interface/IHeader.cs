using NirvanaSMS.Api.Core.Entity;
using NirvanaSMS.Api.Core.Utility;

namespace NirvanaSMS.Api.Core.Interface
{
    public interface IHeader
    {
        ProcessResult<string[]> Query(ApiUser apiUser);
    }
}
