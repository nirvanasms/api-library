package org.nirvanasms.api.core.utility;

import org.nirvanasms.api.core.entity.StatusCode;

public class ProcessResult<T> {
	private boolean isSuccess;
	private String response;
	private String description;
	private T data;
	
	public ProcessResult()
    {

    }
	
	public ProcessResult(String response)
    {
        this.response = response;
        setDescriptionAndSuccess(response);
    }
	
	public ProcessResult(String response, T data)
    {
        this.response = response;
        setDescriptionAndSuccess(response);
        this.data = data;
    }

    void setDescriptionAndSuccess(String response)
    {
        String code = response.substring(0, 2);
        StatusCode status = StatusCodes.getByCode(code);
        this.description = String.format("İşlem Kodu: %s\nİşlem Açıklaması:%s", status.getCode(), status.getDescription());
        this.isSuccess = status.getIsSuccess();
    }

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
