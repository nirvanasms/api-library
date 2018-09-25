using NirvanaSMS.Api.Core.Base;

namespace NirvanaSMS.Api.Core.Entity
{
    public class ApiUser : UserBase
    {
        public ApiUser()
        {
          
        }

        public ApiUser(string userName, string apiPassword)
        {
            UserName = userName;
            ApiPassword = apiPassword;
        }
    }
}
