package org.nirvanasms.api.core.interfaces;

import org.nirvanasms.api.core.entity.ApiUser;
import org.nirvanasms.api.core.entity.Credit;
import org.nirvanasms.api.core.utility.ProcessResult;

public interface ICredit {
	ProcessResult<Credit> query(ApiUser apiUser);
}
