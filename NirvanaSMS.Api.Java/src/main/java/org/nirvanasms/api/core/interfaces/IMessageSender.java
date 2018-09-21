package org.nirvanasms.api.core.interfaces;

import org.nirvanasms.api.core.base.MessageBase;
import org.nirvanasms.api.core.entity.ApiUser;
import org.nirvanasms.api.core.utility.ProcessResult;

public interface IMessageSender {
	ProcessResult<String> sendMessage(ApiUser apiUser, MessageBase message);
}
