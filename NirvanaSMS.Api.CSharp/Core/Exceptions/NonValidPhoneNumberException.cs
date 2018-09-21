using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NirvanaSMS.Api.Core.Exceptions
{
    public class NonValidPhoneNumberException : Exception
    {
        public NonValidPhoneNumberException(string message) : base(message)
        {

        }
    }
}
