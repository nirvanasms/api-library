package org.nirvanasms.api.core.interfaces;

import java.util.List;

import org.nirvanasms.api.core.base.UserBase;
import org.nirvanasms.api.core.entity.NumberReport;
import org.nirvanasms.api.core.utility.ProcessResult;

public interface IReport {
	public ProcessResult<List<NumberReport>> getReport(UserBase apiUser, String messageId);
}
