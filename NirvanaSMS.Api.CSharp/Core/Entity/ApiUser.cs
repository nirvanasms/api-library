using NirvanaSMS.Api.Core.Base;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

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
