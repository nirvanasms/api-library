using NirvanaSMS.Api.Core.Base;
using NirvanaSMS.Api.Core.Entity;

namespace NirvanaSMS.Api.Core.Utility
{
    public class OneToManyMessageFormatter : FormatterBase<OneToManyMessage,MessageBase>
    {
        public override OneToManyMessage Format(MessageBase message)
        {
            PhoneNumberFormatter phoneNumberFormatter = new PhoneNumberFormatter();
            OneToManyMessage _message = message as OneToManyMessage;
            _message.GsmNumbers.ForEach(x => x = phoneNumberFormatter.Format(x));
            //message.Message.Trim();
            return _message;
        }
    }
}
