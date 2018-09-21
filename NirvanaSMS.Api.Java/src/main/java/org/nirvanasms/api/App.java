package org.nirvanasms.api;

import java.awt.SecondaryLoop;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.CredentialNotFoundException;

import org.nirvanasms.api.core.entity.ApiUser;
import org.nirvanasms.api.core.entity.Credit;
import org.nirvanasms.api.core.entity.ManyToManyMessage;
import org.nirvanasms.api.core.entity.NumberReport;
import org.nirvanasms.api.core.entity.OneToManyMessage;
import org.nirvanasms.api.core.entity.PhoneAndMessagePair;
import org.nirvanasms.api.core.entity.PhoneNumber;
import org.nirvanasms.api.core.exceptions.NonValidPhoneNumberException;
import org.nirvanasms.api.core.utility.ProcessResult;
import org.nirvanasms.api.operations.BlackListOperations;
import org.nirvanasms.api.operations.CreditOperations;
import org.nirvanasms.api.operations.HeaderOperations;
import org.nirvanasms.api.operations.MessageSender;
import org.nirvanasms.api.operations.ReportOperations;

/**
 * Hello world!
 *
 */
public class App {

	static ApiUser apiUser = new ApiUser("test", "test");

	public static void main(String[] args) {
		sendOneToManyMessage();
		//sendManyToManyMessage();
		//addToBlackList();
		//queryCreditAmount();
		//queryHeaders();
		//getReport();
	}

	static void sendOneToManyMessage() {
		MessageSender sender = new MessageSender();

		List<PhoneNumber> numbers = new ArrayList<PhoneNumber>();
		numbers.add(new PhoneNumber("5555555555"));

		OneToManyMessage message = new OneToManyMessage();
		message.setHeader("NirvanaSMS");
		message.setValidityTime(2880);
		message.setGsmNumbers(numbers);
		message.setMessage("İletişim talebiniz alınmıştır. En kısa zamanda size döneceğiz2.");

		ProcessResult<String> result = sender.sendMessage(apiUser, message);

		printResult(result);
	}

	static void sendManyToManyMessage() {
		MessageSender sender = new MessageSender();
		List<PhoneAndMessagePair> phonesAndMessages = new ArrayList<PhoneAndMessagePair>();
		phonesAndMessages.add(new PhoneAndMessagePair("0555 555 5555", "TEST 1"));
		phonesAndMessages.add(new PhoneAndMessagePair("0555 555 5555", "TEST 2"));
		phonesAndMessages.add(new PhoneAndMessagePair("0555 555 5555", "TEST 3"));

		ManyToManyMessage message = new ManyToManyMessage();
		message.setHeader("NirvanaSMS");
		message.setPhonesAndMessages(phonesAndMessages);
		message.setValidityTime(2880);

		ProcessResult<String> result = sender.sendMessage(apiUser, message);

		printResult(result);
	}

	static void addToBlackList() {
		BlackListOperations blackListOperations = new BlackListOperations();
		ProcessResult<?> result = null;
		try {
			result = blackListOperations.add(apiUser, new PhoneNumber("555 555 5555"));
		} catch (NonValidPhoneNumberException e) {
			System.out.println(e.getMessage());
		}

		printResult(result);
	}

	static void queryCreditAmount() {
		CreditOperations creditOperations = new CreditOperations();
		ProcessResult<Credit> result = creditOperations.query(apiUser);
		printResult(result);
		System.out.println(result.getData().getAmount());
	}

	static void queryHeaders() {
		HeaderOperations headerOperations = new HeaderOperations();
		ProcessResult<String[]> result = headerOperations.query(apiUser);
		printResult(result);
		for(String header : result.getData())
			System.out.println(header);
	}
	
	static void getReport(){
		ReportOperations reportOperations = new ReportOperations();
		ProcessResult<List<NumberReport>> result = reportOperations.getReport(apiUser, "message id");
		printResult(result);
		for(NumberReport report : result.getData()){
			System.out.println(report.getNumber().getNumber() + " " + report.getStatusCode().getCode() + " " + report.getStatusCode().getDescription());
		}
	}

	static void printResult(ProcessResult<?> result) {
		System.out.println(result.isSuccess());
		System.out.println(result.getResponse());
		System.out.println(result.getDescription());
		System.out.println(result.getData());
	}
}
