using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NirvanaSMS.Api.Core.Interface
{
    public interface IFormatter<T,T2>
    {
        T Format(T2 obj);
    }
}
