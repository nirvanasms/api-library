using NirvanaSMS.Api.Core.Base;
using NirvanaSMS.Api.Core.Utility;
using System.Collections.Generic;

namespace NirvanaSMS.Api.Core.Entity
{
    public class ManyToManyMessage : MessageBase
    {
        public List<PhoneAndMessagePair> PhonesAndMessages { get; set; }
        public ManyToManyMessageBuilder Builder { get; set; }

        public ManyToManyMessage()
        {
            Builder = new ManyToManyMessageBuilder();
        }

        public ManyToManyMessage(ManyToManyMessageBuilder builder)
        {
            Header = builder.Header;
            PhonesAndMessages = builder.PhonesAndMessages;
            ValidityTime = builder.ValidityTime;
            SendDateTime = builder.SendDateTime;
        }
    }
}
