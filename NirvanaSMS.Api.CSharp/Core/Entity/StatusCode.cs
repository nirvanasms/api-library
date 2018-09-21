using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NirvanaSMS.Api.Core.Entity
{
    public class StatusCode
    {
        public string Code { get; set; }
        public string Name { get; set; }
        public string Description { get; set; }
        public bool IsSuccess { get; set; }

        public StatusCode()
        {

        }

        public StatusCode(string code, string name, string description)
        {
            Code = code;
            Name = name;
            Description = description;
        }

        public StatusCode(string code, string name, string description, bool isSuccess)
        {
            Code = code;
            Name = name;
            Description = description;
            IsSuccess = isSuccess;
        }
    }
}
