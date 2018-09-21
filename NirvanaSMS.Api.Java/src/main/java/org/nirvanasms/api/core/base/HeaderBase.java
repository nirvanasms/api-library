package org.nirvanasms.api.core.base;

import org.nirvanasms.api.core.entity.ApiUser;
import org.nirvanasms.api.core.interfaces.IHeader;
import org.nirvanasms.api.core.utility.ProcessResult;

public abstract  class HeaderBase implements IHeader {

	@Override
	public abstract ProcessResult<String[]> query(ApiUser apiUser);
}
