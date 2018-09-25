package org.nirvanasms.api.core.utility;

import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.nirvanasms.api.core.base.MessageBase;
import org.nirvanasms.api.core.entity.ApiUser;
import org.nirvanasms.api.core.entity.ManyToManyMessage;
import org.nirvanasms.api.core.entity.OneToManyMessage;
import org.nirvanasms.api.core.entity.PhoneAndMessagePair;
import org.nirvanasms.api.core.entity.PhoneNumber;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlHelper {
	public static String getMessageXml(ApiUser apiUser, MessageBase message) {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// sms
			Document doc = docBuilder.newDocument();

			Element sms = doc.createElement("sms");
			doc.appendChild(sms);

			Element username = doc.createElement("username");
			username.setTextContent(apiUser.getUserName());
			sms.appendChild(username);

			Element apiPassword = doc.createElement("password");
			apiPassword.setTextContent(apiUser.getApiPassword());
			sms.appendChild(apiPassword);

			Element header = doc.createElement("header");
			header.setTextContent(message.getHeader());
			sms.appendChild(header);

			Element validity = doc.createElement("validity");
			validity.setTextContent(String.valueOf(message.getValidityTime()));
			sms.appendChild(validity);

			if (message.getSendDateTime() != null) {
				Element sendDateTime = doc.createElement("sendDateTime");
				String dateFormat = "yyyy.M.dd.HH.m.s";
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
				sendDateTime.setTextContent(DateFormatter.format(message.getSendDateTime()));
				sms.appendChild(sendDateTime);
			}

			if (message instanceof OneToManyMessage) {
				OneToManyMessage oneToMany = (OneToManyMessage) message;
				Element messageElement = doc.createElement("message");
				Element gsm = doc.createElement("gsm");
				for (PhoneNumber number : oneToMany.getGsmNumbers()) {
					if (number.isValid()) {
						Element no = doc.createElement("no");
						no.setTextContent(number.getNumber());
						gsm.appendChild(no);
					}
				}
				messageElement.appendChild(gsm);

				Element msg = doc.createElement("msg");
				msg.setTextContent(oneToMany.getMessage());
				messageElement.appendChild(msg);
				sms.appendChild(messageElement);
			} else if (message instanceof ManyToManyMessage) {
				ManyToManyMessage manyToMany = (ManyToManyMessage) message;
				Element messages = doc.createElement("messages");
				for (PhoneAndMessagePair phoneAndMessage : manyToMany.getPhonesAndMessages()) {
					if (phoneAndMessage.getNumber().isValid()) {
						Element mb = doc.createElement("mb");
						Element no = doc.createElement("no");
						no.setTextContent(phoneAndMessage.getNumber().getNumber());
						Element msg = doc.createElement("msg");
						msg.setTextContent(phoneAndMessage.getMessage());
						mb.appendChild(no);
						mb.appendChild(msg);
						messages.appendChild(mb);
					}
				}
				sms.appendChild(messages);
			}
			
			return xmlToString(doc);

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (DOMException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String xmlToString(Document doc){
		try {
	        StringWriter sw = new StringWriter();
	        TransformerFactory tf = TransformerFactory.newInstance();
	        Transformer transformer = tf.newTransformer();
	        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
	        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

	        transformer.transform(new DOMSource(doc), new StreamResult(sw));
	        return sw.toString();
	    } catch (Exception ex) {
	        throw new RuntimeException("Error converting to String", ex);
	    }
	}
}
