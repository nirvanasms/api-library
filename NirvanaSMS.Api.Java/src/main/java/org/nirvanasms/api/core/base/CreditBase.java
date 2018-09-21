package org.nirvanasms.api.core.base;

import org.nirvanasms.api.core.entity.ApiUser;
import org.nirvanasms.api.core.entity.Credit;
import org.nirvanasms.api.core.interfaces.ICredit;
import org.nirvanasms.api.core.utility.ProcessResult;

public abstract class CreditBase implements ICredit {

	@Override
	public abstract ProcessResult<Credit> query(ApiUser apiUser);
}
