using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NirvanaSMS.Api.Core.Entity
{
    public class NumberReport
    {
        public PhoneNumber Number { get; set; }
        public StatusCode StatusCode { get; set; }

        public NumberReport(PhoneNumber number, StatusCode statusCode)
        {
            Number = number;
            StatusCode = statusCode;
        }
    }
}
