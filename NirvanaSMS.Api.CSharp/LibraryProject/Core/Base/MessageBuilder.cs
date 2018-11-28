using NirvanaSMS.Api.Core.Interface;
using System;

namespace NirvanaSMS.Api.Core.Base
{
    public abstract class MessageBuilder<T, T2> : MessageBase, IBuilder<T>
    {
        public abstract T2 SetValidity(int validity);

        public abstract T2 SetHeader(string header);

        public abstract T2 SetSendDateTime(string dateTime);

        public abstract T2 SetSendDateTime(DateTime dateTime);

        public abstract T Build();
    }
}
