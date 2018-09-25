namespace NirvanaSMS.Api.Core.Interface
{
    public interface IFormatter<T,T2>
    {
        T Format(T2 obj);
    }
}
