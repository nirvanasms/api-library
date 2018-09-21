using NirvanaSMS.Api.Core.Interface;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NirvanaSMS.Api.Core.Base
{
    public class UserBase : IUser
    {
        public string UserName { get; set; }
        public string ApiPassword { get; set; }
    }
}
