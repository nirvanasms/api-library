using NirvanaSMS.Api.Core.Entity;
using NirvanaSMS.Api.Core.Utility;

namespace NirvanaSMS.Api.Business.Interface
{
    interface IBlackList
    {
        ProcessResult Add(ApiUser user, PhoneNumber phoneNumber);
    }
}
