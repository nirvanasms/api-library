package org.nirvanasms.api.operations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nirvanasms.api.core.base.ReportBase;
import org.nirvanasms.api.core.base.UserBase;
import org.nirvanasms.api.core.entity.NumberReport;
import org.nirvanasms.api.core.entity.PhoneNumber;
import org.nirvanasms.api.core.utility.Constants;
import org.nirvanasms.api.core.utility.Enums;
import org.nirvanasms.api.core.utility.HttpRequest;
import org.nirvanasms.api.core.utility.ProcessResult;
import org.nirvanasms.api.core.utility.StatusCodes;

public class ReportOperations extends ReportBase {
	@Override
	public ProcessResult<List<NumberReport>> getReport(UserBase apiUser, String messageId) {
		Map<String, String> queryStrings = new HashMap<String, String>();
		queryStrings.put("username", apiUser.getUserName());
		queryStrings.put("password", apiUser.getApiPassword());
		queryStrings.put("id", messageId);
		HttpRequest request = new HttpRequest(Constants.ReportUrl, queryStrings, Enums.RequestMethod.Get);
		String response = request.getResponse();
		ProcessResult<List<NumberReport>> result = new ProcessResult<List<NumberReport>>(response);
		if (result.isSuccess()) {
			String[] numberReports = response.substring(3).split("\\|");
			List<NumberReport> numberReportsList = new ArrayList<NumberReport>();
			for (String item : numberReports) {
				String[] numberAndStatus = item.split(" ");
				numberReportsList.add(new NumberReport(new PhoneNumber(numberAndStatus[0]),
						StatusCodes.getByCode(numberAndStatus[1])));
			}
			result.setData(numberReportsList);
		}
		return result;
	}
}
