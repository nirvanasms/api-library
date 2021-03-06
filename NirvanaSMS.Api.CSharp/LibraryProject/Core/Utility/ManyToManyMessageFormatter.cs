﻿using NirvanaSMS.Api.Core.Base;
using NirvanaSMS.Api.Core.Entity;

namespace NirvanaSMS.Api.Core.Utility
{
    public class ManyToManyMessageFormatter : FormatterBase<ManyToManyMessage, MessageBase>
    {
        public override ManyToManyMessage Format(MessageBase messages)
        {
            PhoneNumberFormatter phoneNumberFormatter = new PhoneNumberFormatter();
            ManyToManyMessage _messages = messages as ManyToManyMessage;
            foreach (var item in _messages.PhonesAndMessages)
            {
                phoneNumberFormatter.Format(item.Number);
                //item.Message.Trim();
            }
            return _messages;
        }
    }
}
