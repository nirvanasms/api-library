using NirvanaSMS.Api.Core.Interface;

namespace NirvanaSMS.Api.Core.Base
{
    public class UserBase : IUser
    {
        public string UserName { get; set; }
        public string ApiPassword { get; set; }
    }
}
