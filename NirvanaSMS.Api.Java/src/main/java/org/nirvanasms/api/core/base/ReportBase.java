package org.nirvanasms.api.core.base;

import java.util.List;

import org.nirvanasms.api.core.entity.NumberReport;
import org.nirvanasms.api.core.interfaces.IReport;
import org.nirvanasms.api.core.utility.ProcessResult;

public abstract class ReportBase implements IReport {
	@Override
	public ProcessResult<List<NumberReport>> getReport(UserBase apiUser, String messageId){
		return null;
	}
}
