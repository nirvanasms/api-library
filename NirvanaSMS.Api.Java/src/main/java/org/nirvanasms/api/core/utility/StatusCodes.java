package org.nirvanasms.api.core.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.nirvanasms.api.core.entity.*;

public class StatusCodes {
	public static ArrayList<StatusCode> Codes = new ArrayList<StatusCode>(
		Arrays.asList(
	        new StatusCode("95","USE_GET_METHOD","İsteği HTTP GET ile yollayınız",false),
	        new StatusCode("93","MISSING_GET_PARAMS","GET parametrelerinde eksik var",false),
	        new StatusCode("87","WRONG_USER_OR_PASSWORD","Kullanıcı adı veya şifre hatalı",false),
	        new StatusCode("78","ALREADY_BLACKLISTED","Numara zaten kara listeye ekli",false),
	        new StatusCode("00","SUCCESS","İşlem başarı ile sonlandı.",true),
	        new StatusCode("97","USE_POST_METHOD","İsteği HTTP POST ile yollayınız",false),
	        new StatusCode("91","MISSING_POST_DATA","POST verisi okunamadı veya yok",false),
	        new StatusCode("89","WRONG_XML_FORMAT ","POST verisi XML olarak parse edilemedi",false),
	        new StatusCode("85","WRONG_SMS_HEADER","Belirttiğiniz mesaj başlığı bulunamadı veya onaylanmamış",false),
	        new StatusCode("84","WRONG_SEND_DATE_TIME","İleri tarihli gönderim zamanı hatalı bir formata sahip veya 1 yıldan daha ileri bir zamanı gösteriyor",false),
	        new StatusCode("83","EMPTY_SMS","Mesaj metni ve numaralar incelendikten sonra sistem yollanacak bir SMS oluşturmaya yetecek en az 1 numara ve en az 1 karakterden oluşan mesaj metnine sahip olamadı. Gönderim yapılacak verilerin yeterli olmadığına karar verdi.",false),
	        new StatusCode("81","NOT_ENOUGH_CREDITS","Gönderilecek olan mesaj için yeterli krediye sahip değilsiniz.",false),
	        new StatusCode("77","DUPLICATED_MESSAGE","Son 2 dakika içinde aynı SMS'in gönderilmesi durumu (Sistem bunu engeller)",false),
	        new StatusCode("99","UNKNOWN_ERROR","Henüz dokümante edilmemiş bir hatayı belirtir.",false),
	        new StatusCode("79","DLR_ID_NOT_FOUND","Böyle bir dlrId değeri bulunamadı, yok",false),
	        new StatusCode("29","MESSAGE_WAITING_TO_SEND","Mesaj henüz yollanmamış, yollanmak üzere",false),
	        new StatusCode("27","MESSAGE_SEND_ERROR","Mesaj yollanırken beklenmeyen bir hata oluşmuş",false),
	        new StatusCode("25","DLR_OPERATION_STARTED","DLR raporu güncellenmeye başlamış",true),
	        new StatusCode("23","DLR_OPERATION_COMPLETED","DLR raporu artık güncellenmeyecek, tüm bilgiler toplanmış, rapor son halini almış",true),
	        new StatusCode("0","WAITING","SMS gönderim için bekliyor"),
	        new StatusCode("5","PENDING","SMS gönderilmiş, bilgi bekleniyor"),
	        new StatusCode("6","FAIL","SMS Ulaşmadı"),
	        new StatusCode("9","SUCCESS","SMS İletildi")
		));
	
	public static StatusCode getByCode(String code)
    {
		for(StatusCode status : Codes){
			if(status.getCode().equals(code))
				return status;
		}
		return null;
    }
}
