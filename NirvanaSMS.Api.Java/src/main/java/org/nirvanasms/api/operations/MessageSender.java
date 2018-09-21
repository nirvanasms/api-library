package org.nirvanasms.api.operations;

import org.nirvanasms.api.core.base.MessageBase;
import org.nirvanasms.api.core.base.MessageSenderBase;
import org.nirvanasms.api.core.entity.ApiUser;
import org.nirvanasms.api.core.entity.ManyToManyMessage;
import org.nirvanasms.api.core.entity.OneToManyMessage;
import org.nirvanasms.api.core.utility.ManyToManyMessageFormatter;
import org.nirvanasms.api.core.utility.OneToManyMessageFormatter;
import org.nirvanasms.api.core.utility.ProcessResult;

public class MessageSender extends MessageSenderBase {
	@Override
	public ProcessResult<String> sendMessage(ApiUser apiUser, MessageBase message){
		OneToManyMessageFormatter oneToManyFormatter = new OneToManyMessageFormatter();
        ManyToManyMessageFormatter manyToManyFormatter = new ManyToManyMessageFormatter();

        MessageBase formattedMessage = null;
        if (message instanceof OneToManyMessage)
            formattedMessage = oneToManyFormatter.format(message);
        else if (message instanceof ManyToManyMessage)
            formattedMessage = manyToManyFormatter.format(message);
		return super.sendMessage(apiUser, formattedMessage);
		
	}
}
