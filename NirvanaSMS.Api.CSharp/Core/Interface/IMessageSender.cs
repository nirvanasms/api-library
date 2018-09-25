using NirvanaSMS.Api.Core.Base;
using NirvanaSMS.Api.Core.Entity;
using NirvanaSMS.Api.Core.Utility;

namespace NirvanaSMS.Api.Core.Interface
{
    interface IMessageSender
    {
        ProcessResult<string> SendMessage(ApiUser apiUser, MessageBase message);
    }
}
