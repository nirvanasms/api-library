using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NirvanaSMS.Api.Core.Entity
{
    public class PhoneAndMessagePair
    {
        public PhoneNumber Number { get; set; }
        public string Message { get; set; }

        public PhoneAndMessagePair()
        {

        }

        public PhoneAndMessagePair(PhoneNumber number, string message)
        {
            Number = number;
            Message = message;
        }

        public PhoneAndMessagePair(string number, string message)
        {
            Number = new PhoneNumber(number);
            Message = message;
        }
    }
}
