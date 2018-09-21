using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NirvanaSMS.Api.Core.Entity
{
    public class PhoneNumber
    {
        public string Number { get; set; }
        public bool IsValid { get; set; }

        public PhoneNumber()
        {

        }

        public PhoneNumber(string phoneNumber)
        {
            Number = phoneNumber; 
        }
    }
}
