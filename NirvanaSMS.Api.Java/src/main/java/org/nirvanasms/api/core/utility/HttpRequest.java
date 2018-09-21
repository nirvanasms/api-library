package org.nirvanasms.api.core.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.nirvanasms.api.core.utility.Enums.RequestMethod;
import org.nirvanasms.api.core.utility.Enums.RequestParameterType;

public class HttpRequest {
	private Map<String, String> postItems;
	private String xmlItem;
	private RequestParameterType parameterType;
	private RequestMethod requestMethod;
	private String responseString;
	private String url;

	// constructors

	public HttpRequest(String url, Map<String, String> postItems, RequestMethod requestMethod) {
		this.postItems = postItems;
		this.requestMethod = requestMethod;
		this.parameterType = RequestParameterType.Text;
		this.url = url;
	}

	public HttpRequest(String url, String xmlItem, RequestMethod requestMethod) {
		this.xmlItem = xmlItem;
		this.requestMethod = requestMethod;
		this.url = url;
		this.parameterType = RequestParameterType.Xml;
	}

	public String send() {
		String result = "";
		if (requestMethod == RequestMethod.Post && parameterType == RequestParameterType.Xml)
			result = postXml();
		else if (requestMethod == RequestMethod.Post && parameterType == RequestParameterType.Text)
			result = postText();
		else if (requestMethod == RequestMethod.Get && parameterType == RequestParameterType.Xml)
			result = getXml();
		else if (requestMethod == RequestMethod.Get && parameterType == RequestParameterType.Text)
			result = getText();

		return result;
	}

	private String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	private String getXml() {
		// TODO Auto-generated method stub
		return null;
	}

	private String postText() {
		// TODO Auto-generated method stub
		return null;
	}

	private String postXml() {
		HttpURLConnection uc = null;
		try {
			URL url = new URL(getUrl());
			uc = (HttpURLConnection) url.openConnection();
			uc.setRequestMethod("POST");
			uc.setDoInput(true);
			uc.setDoOutput(true);
			uc.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			uc.setRequestProperty("Content-Encoding", "UTF-8");
			uc.setReadTimeout(5 * 1000);
			uc.setConnectTimeout(5 * 1000);
			uc.connect();
			OutputStreamWriter out = new OutputStreamWriter(uc.getOutputStream(), "UTF-8");
			out.write(getXmlItem());
			out.flush();
			out.close();
			int readed;
			char[] buffer = new char[4 * 1024];
			StringBuffer sb = new StringBuffer();
			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(), "UTF-8"));
			while ((readed = in.read(buffer)) > 0) {
				sb.append(buffer, 0, readed);
			}
			in.close();
			responseString = sb.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			uc.disconnect();
			uc = null;
		}
		return responseString;
	}

	public String getResponse() {
		HttpURLConnection uc = null;

		try {
			String requestUrl = getRequestUrl(postItems);
			URL url = new URL(requestUrl);
			uc = (HttpURLConnection) url.openConnection();
			uc.setRequestMethod("GET");
			uc.setReadTimeout(5 * 1000);
			uc.setConnectTimeout(5 * 1000);
			uc.connect();
			int readed;
			char[] buffer = new char[4 * 1024];
			StringBuffer sb = new StringBuffer();
			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(), "UTF-8"));
			while ((readed = in.read(buffer)) > 0) {
				sb.append(buffer, 0, readed);
			}
			in.close();
			responseString = sb.toString();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			uc.disconnect();
			uc = null;
		}
		return responseString;
	}

	public String getRequestUrl(Map<String, String> queryStrings) throws UnsupportedEncodingException {
		List<String> postArray = new ArrayList<String>();
		for (Map.Entry<String, String> entry : postItems.entrySet())
			postArray.add(entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), "utf-8"));

		String postData = "";

		for (String postItem : postArray) {
			postData += postItem + "&";
		}

		String requestUrl = String.format("%s?%s", getUrl(), postData.substring(0, postData.length() - 1));
		return requestUrl;
	}

	// Getters and setters

	public Map<String, String> getPostItems() {
		return postItems;
	}

	public void setPostItems(Map<String, String> postItems) {
		this.postItems = postItems;
	}

	public String getXmlItem() {
		return xmlItem;
	}

	public void setXmlItem(String xmlItem) {
		this.xmlItem = xmlItem;
	}

	public RequestParameterType getParameterType() {
		return parameterType;
	}

	public void setParameterType(RequestParameterType paramaterType) {
		this.parameterType = paramaterType;
	}

	public RequestMethod getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(RequestMethod requestMethod) {
		this.requestMethod = requestMethod;
	}

	public String getResponseString() {
		return responseString;
	}

	public void setResponseString(String responseString) {
		this.responseString = responseString;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
