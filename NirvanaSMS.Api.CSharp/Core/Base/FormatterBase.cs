using NirvanaSMS.Api.Core.Interface;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NirvanaSMS.Api.Core.Base
{
    public class FormatterBase<T,T2> : IFormatter<T,T2>
    {
        public virtual T Format(T2 obj)
        {
            return default(T);
        }
    }
}
