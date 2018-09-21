using NirvanaSMS.Api.Core.Base;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NirvanaSMS.Api.Core.Entity;
using NirvanaSMS.Api.Core.Utility;
using NirvanaSMS.Api.Core.Interface;

namespace NirvanaSMS.Api.Operations
{
    public class MessageSender : MessageSenderBase 
    {
        public override ProcessResult<string> SendMessage(ApiUser apiUser, MessageBase message)
        {
            OneToManyMessageFormatter oneToManyFormatter = new OneToManyMessageFormatter();
            ManyToManyMessageFormatter manyToManyFormatter = new ManyToManyMessageFormatter();

            MessageBase formattedMessage = null;
            if (message is OneToManyMessage)
                formattedMessage = oneToManyFormatter.Format(message);
            else if (message is ManyToManyMessage)
                formattedMessage = manyToManyFormatter.Format(message);

            return base.SendMessage(apiUser, formattedMessage);
        }
    }
}
