using System;

namespace NirvanaSMS.Api.Core.Exceptions
{
    public class NonValidPhoneNumberException : Exception
    {
        public NonValidPhoneNumberException(string message) : base(message)
        {

        }
    }
}
