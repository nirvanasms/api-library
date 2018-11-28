using NirvanaSMS.Api.Core.Interface;
using NirvanaSMS.Api.Core.Entity;
using NirvanaSMS.Api.Core.Utility;

namespace NirvanaSMS.Api.Core.Base
{
    public class MessageSenderBase : IMessageSender
    {
        public virtual ProcessResult<string> SendMessage(ApiUser apiUser, MessageBase message)
        {
            string messageXml = XmlHelper.GetMessageXml(apiUser, message);
            HttpRequest request = new HttpRequest(Constants.SendSMSPostUrl, messageXml, Enums.RequestMethod.Post);
            string response = request.Send();
            ProcessResult<string> result = new ProcessResult<string>(response);
            if (result.IsSuccess)
            {
                string messageId = response.Substring(2);
                result.Data = messageId;
            }
            return result;
        }
    }
}
