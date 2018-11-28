using NirvanaSMS.Api.Core.Base;
using NirvanaSMS.Api.Core.Entity;
using System;
using System.Collections.Generic;
using System.Linq;

namespace NirvanaSMS.Api.Core.Utility
{
    public class OneToManyMessageBuilder : MessageBuilder<OneToManyMessage,OneToManyMessageBuilder>
    {
        public string Message { get; set; }
        public List<PhoneNumber> GsmNumbers { get; set; }
        
     
        public OneToManyMessageBuilder SetMessage(string message)
        {
            Message = message;
            return this;
        }

        public OneToManyMessageBuilder SetNumbers(string[] numbers)
        {
            GsmNumbers = numbers.Select(x => new PhoneNumber(x)).ToList();
            return this;
        }

        public OneToManyMessageBuilder SetNumbers(List<PhoneNumber> numbers)
        {
            GsmNumbers = numbers;
            return this;
        }

        public override OneToManyMessageBuilder SetHeader(string header)
        {
            Header = header;
            return this;
        }

        public override OneToManyMessageBuilder SetSendDateTime(DateTime dateTime)
        {
            SendDateTime = dateTime;
            return this;
        }

        public override OneToManyMessageBuilder SetSendDateTime(string dateTime)
        {
            SendDateTime = DateTime.Parse(dateTime);
            return this;
        }

        public override OneToManyMessageBuilder SetValidity(int validity)
        {
            ValidityTime = validity;
            return this;
        }

        public override OneToManyMessage Build()
        {
            return new OneToManyMessage(this);
        }
    }
}
