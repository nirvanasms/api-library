package org.nirvanasms.api.operations;

import java.util.HashMap;
import java.util.Map;

import org.nirvanasms.api.core.base.HeaderBase;
import org.nirvanasms.api.core.entity.ApiUser;
import org.nirvanasms.api.core.utility.Constants;
import org.nirvanasms.api.core.utility.Enums.RequestMethod;
import org.nirvanasms.api.core.utility.HttpRequest;
import org.nirvanasms.api.core.utility.ProcessResult;

public class HeaderOperations extends HeaderBase {
	@Override
	public ProcessResult<String[]> query(ApiUser apiUser)
    {
        Map<String, String> queryStrings = new HashMap<String, String>();
        queryStrings.put("username", apiUser.getUserName());
        queryStrings.put("password", apiUser.getApiPassword());
        HttpRequest request = new HttpRequest(Constants.HeaderQueryUrl, queryStrings, RequestMethod.Get);
        String response = request.getResponse();
        ProcessResult<String[]> result = new ProcessResult<String[]>(response);
        if (result.isSuccess()) {
            String[] headers = response.substring(2).split("\\|");
            result.setData(headers);
        }
        return result;
    }
}
