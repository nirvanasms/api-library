package org.nirvanasms.api.core.interfaces;

import org.nirvanasms.api.core.entity.ApiUser;
import org.nirvanasms.api.core.utility.ProcessResult;

public interface IHeader {
	ProcessResult<String[]> query(ApiUser apiUser);
}
