using NirvanaSMS.Api.Core.Base;
using NirvanaSMS.Api.Core.Entity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NirvanaSMS.Api.Core.Utility
{
    public class ManyToManyMessageBuilder : MessageBuilder<ManyToManyMessage, ManyToManyMessageBuilder>
    {
        public List<PhoneAndMessagePair> PhonesAndMessages { get; set; }
        
        public override ManyToManyMessage Build()
        {
            return new ManyToManyMessage(this);
        }

        public ManyToManyMessageBuilder SetPhonesAndMessages(List<PhoneAndMessagePair> phonesAndMessages)
        {
            PhonesAndMessages = phonesAndMessages;
            return this;
        }

        public override ManyToManyMessageBuilder SetHeader(string header)
        {
            Header = header;
            return this;
        }

        public override ManyToManyMessageBuilder SetSendDateTime(DateTime dateTime)
        {
            SendDateTime = dateTime;
            return this;
        }

        public override ManyToManyMessageBuilder SetSendDateTime(string dateTime)
        {
            SendDateTime = DateTime.Parse(dateTime);
            return this;
        }

        public override ManyToManyMessageBuilder SetValidity(int validity)
        {
            ValidityTime = validity;
            return this;
        }
    }
}
