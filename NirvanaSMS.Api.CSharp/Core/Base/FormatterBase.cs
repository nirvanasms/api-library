using NirvanaSMS.Api.Core.Interface;

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
