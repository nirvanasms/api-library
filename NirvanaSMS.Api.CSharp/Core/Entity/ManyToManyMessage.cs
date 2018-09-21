using NirvanaSMS.Api.Core.Base;
using NirvanaSMS.Api.Core.Utility;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NirvanaSMS.Api.Core.Entity
{
    public class ManyToManyMessage : MessageBase
    {
        public List<PhoneAndMessagePair> PhonesAndMessages { get; set; }

        public ManyToManyMessage()
        {

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
