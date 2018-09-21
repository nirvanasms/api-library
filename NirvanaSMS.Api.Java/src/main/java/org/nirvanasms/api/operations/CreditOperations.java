package org.nirvanasms.api.operations;

import java.util.HashMap;
import java.util.Map;

import org.nirvanasms.api.core.base.CreditBase;
import org.nirvanasms.api.core.entity.ApiUser;
import org.nirvanasms.api.core.entity.Credit;
import org.nirvanasms.api.core.utility.Constants;
import org.nirvanasms.api.core.utility.Enums.RequestMethod;
import org.nirvanasms.api.core.utility.HttpRequest;
import org.nirvanasms.api.core.utility.ProcessResult;

public class CreditOperations extends CreditBase {

	@Override
	public ProcessResult<Credit> query(ApiUser apiUser) {
		 Map<String, String> queryStrings = new HashMap<String, String>();
         queryStrings.put("username", apiUser.getUserName());
         queryStrings.put("password", apiUser.getApiPassword());
         HttpRequest request = new HttpRequest(Constants.CreditQueryUrl, queryStrings, RequestMethod.Get);
         String response = request.getResponse();
         ProcessResult<Credit> result = new ProcessResult<Credit>(response);
         if (result.isSuccess())
         {
             int amount = Integer.parseInt(response.substring(3));
             result.setData(new Credit(amount));
         }
         return result;
	}

}
