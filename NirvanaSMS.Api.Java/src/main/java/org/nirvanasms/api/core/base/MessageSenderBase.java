package org.nirvanasms.api.core.base;

import org.nirvanasms.api.core.entity.ApiUser;
import org.nirvanasms.api.core.interfaces.IMessageSender;
import org.nirvanasms.api.core.utility.Constants;
import org.nirvanasms.api.core.utility.Enums.RequestMethod;
import org.nirvanasms.api.core.utility.HttpRequest;
import org.nirvanasms.api.core.utility.ProcessResult;
import org.nirvanasms.api.core.utility.XmlHelper;

public class MessageSenderBase implements IMessageSender {

	@Override
	public ProcessResult<String> sendMessage(ApiUser apiUser, MessageBase message) {
		String messageXml = XmlHelper.getMessageXml(apiUser, message);
        HttpRequest request = new HttpRequest(Constants.SendSMSPostUrl, messageXml, RequestMethod.Post);
        String response = request.send();
        ProcessResult<String> result = new ProcessResult<String>(response);
        if (result.isSuccess())
        {
            String messageId = response.substring(3);
            result.setData(messageId);
        }
        return result;
	}

}
