using NirvanaSMS.Api.Core.Base;
using NirvanaSMS.Api.Core.Interface;
using NirvanaSMS.Api.Core.Utility;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NirvanaSMS.Api.Core.Entity
{
    public class OneToManyMessage : MessageBase
    {
        public string Message { get; set; }
        public List<PhoneNumber> GsmNumbers { get; set; }
        public OneToManyMessageBuilder Builder { get; set; }

        public OneToManyMessage()
        {
            Builder = new OneToManyMessageBuilder();
        }

        public OneToManyMessage(string header, string message, string[] phoneNumbers, int validityTime)
        {
            Header = header;
            Message = message;
            GsmNumbers = phoneNumbers.Select(x => new PhoneNumber(x)).ToList();
            ValidityTime = validityTime;
        }

        public OneToManyMessage(OneToManyMessageBuilder builder)
        {
            Header = builder.Header;
            Message = builder.Message;
            GsmNumbers = builder.GsmNumbers;
            ValidityTime = builder.ValidityTime;
            SendDateTime = builder.SendDateTime;
        }
    }
}
