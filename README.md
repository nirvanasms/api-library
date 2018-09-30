# Nirvana SMS API Kütüphanesi
Bu kütüphane ile Nirvana SMS'in API özelliklerini çok daha kolay bir şekilde kullanabileceksiniz.

## Kütüphane'nin Kurulumu

**Visual Studio**

Visual Studio kullanıcıları Package Manager Console'a aşağıdaki komutu yazarak kütüphaneyi kurabilirler:
```
Install-Package NirvanaSms.Api
```
ya da çalıştıkları projeye Solution Explorer üzerindeyken sağ tıklayıp **Manage Nuget Packages** sekmesine tıkladıklarında karşılarına çıkan pencere **NirvanaSms.Api** kelimesini arattırarak kurabilirler.

**Java Kullanıcıları**

Java kullanıcıları şu anlık Java projesini indirip projelerine dahil edebilirler. Kütüphaneyi kolay bir şekilde eklemek için yakın zamanda Maven Central desteği de gelecektir.

**Diğer Diller**

C# ve Java dışındaki dilleri kullanan geliştiriciler HTTP isteği gönderme yöntemiyle api özelliklerimizi kullanabilirler. Bununla ilgili ayrıntılı dökümana ulaşmak için tıklayınız.

## Kütüphane'nin Kullanımı

### 1) Test Hesabı Bilgileri

Çalışmalarınızı yaparken test için oluşturduğumuz hesabı kullanabilirsiniz. Tüm dönüş değerleri görülebilir fakat test amaçlı hesap olduğu için sms cep numarasına gerçekte ulaşmaz.

#### Test hesabı

**Kullanıcı Adı:** test
**Parola:** test

 ### 2) Mesaj Gönderme
İki tip mesaj gönderme şekli vardır:
#### a) 1-N Mesaj Gönderme

   Bir metin bir veya birden fazla alıcıya ulaştırılır.
   
   ##### C# Kodu:
   
   ```
ApiUser apiUser = new ApiUser("test", "test");
MessageSender sender = new MessageSender();

string[] _numbers = new string[] { "905555555555","0555 555 5555","555 555 5555" };

OneToManyMessage message = new OneToManyMessage().Builder
                                           .SetHeader("Başlık")
                                           .SetNumbers(_numbers) // 
                                           .SetValidity(2880) //mesajın gerçelilik süresi (belirtilen dakika içerisinde mesajı alıcıya ulaştırmaya çalışır.)
                                           .SetMessage(messageText) //mesaj metni
                                           .SetSendDateTime("2018-09-25 11:46:00") //ileri zamanlı mesaj gönderme
                                           .Build();

ProcessResult<string> result = sender.SendMessage(apiUser, message);
   ```
   ##### Java Kodu:
   
   ```
   ApiUser apiUser = new ApiUser("test", "test");
MessageSender sender = new MessageSender();

String[] _numbers = new String[] { "905555555555","0555 555 5555","555 555 5555" };

OneToManyMessage message = new OneToManyMessage().builder()
                                           .header("Başlık")
                                           .numbers(_numbers) // 
                                           .validity(2880) //mesajın gerçelilik süresi (belirtilen dakika içerisinde mesajı alıcıya ulaştırmaya çalışır.)
                                           .message(messageText) //mesaj metni
                                           .sendDateTime("25/09/2018 11:46:00","dd/MM/yyyy HH:mm:ss") //ileri zamanlı mesaj gönderme
                                           .build();

ProcessResult<String> result = sender.sendMessage(apiUser, message);
   ```
   
#### b) N-N Mesaj Gönderme

  Her alıcıya farklı bir mesaj ulaştırılır.
  
  ##### C# Kodu:
  ```
ApiUser apiUser = new ApiUser("test", "test");
MessageSender sender = new MessageSender();

List<PhoneAndMessagePair> phonesAndMessages = new List<PhoneAndMessagePair>()
            {
                new PhoneAndMessagePair("0555 555 5555","TEST 1"),
                new PhoneAndMessagePair("0555 555 5555","TEST 2"),
                new PhoneAndMessagePair("0555 555 5555","TEST 3")
            };

ManyToManyMessage message = new ManyToManyMessage().Builder
                                                   .SetHeader("Başlık")
                                                   .SetPhonesAndMessages(phonesAndMessages)
                                                   .SetValidity(2880)
                                                   .SetSendDateTime("2018-09-25 11:46:00")
                                                   .Build();

ProcessResult<string> result = sender.SendMessage(apiUser, message);
```
  ##### Java Kodu:
  
  ```
  ApiUser apiUser = new ApiUser("test","test");
  MessageSender sender = new MessageSender();
		List<PhoneAndMessagePair> phonesAndMessages = new ArrayList<PhoneAndMessagePair>();
		phonesAndMessages.add(new PhoneAndMessagePair("0555 555 5555", "TEST 1"));
		phonesAndMessages.add(new PhoneAndMessagePair("0555 555 5555", "TEST 2"));
		phonesAndMessages.add(new PhoneAndMessagePair("0555 555 5555", "TEST 3"));
  
  ManyToManyMessage message = new ManyToManyMessage().builder()
                                                     .setHeader("Başlık")
                                                     .setPhonesAndMessages(phonesAndMessages)
						     .sendDateTime("25/09/2018 11:46:00","dd/MM/yyyy HH:mm:ss") //ileri zamanlı mesaj gönderme
                                                     .setValidityTime(2880);
                                                     
 ProcessResult<String> result = sender.sendMessage(apiUser, message);
  ```
    
 ### 3) Kara Listeye Ekleme
 
   ##### C# Kodu:
   
   ```
ApiUser apiUser = new ApiUser("test", "test");
BlackListOperations blackListOperations = new BlackListOperations();

PhoneNumber number = new PhoneNumber("555 555 5555");
ProcessResult result = blackListOperations.Add(apiUser, number);
   ```
   
   ##### Java Kodu:
   
   ```
  ApiUser apiUser = new ApiUser("test", "test");
  BlackListOperations blackListOperations = new BlackListOperations();
  ProcessResult<?> result = null;
  try {
	result = blackListOperations.add(apiUser, new PhoneNumber("555 555 5555"));
 } catch (NonValidPhoneNumberException e) {
	System.out.println(e.getMessage());
	}
   ```
   
 ### 4) Başlıkları Sorgulama
 
  ##### C# Kodu:
  
   ```
ApiUser apiUser = new ApiUser("test", "test");
HeaderOperations headerOps = new HeaderOperations();
ProcessResult<string[]> result = headerOps.Query(apiUser);
   ```
   
   ##### Java Kodu:
   
   ```
  ApiUser apiUser = new ApiUser("test", "test");
  HeaderOperations headerOperations = new HeaderOperations();
  ProcessResult<String[]> result = headerOperations.query(apiUser);
   ```
   
 ### 5) Kredi Miktarını Sorgulama
 
   ##### C# Kodu:
   
   ```
ApiUser apiUser = new ApiUser("test", "test");
CreditOperations creditOps = new CreditOperations();
ProcessResult<Credit> result = creditOps.Query(apiUser);
   ```
   
   ##### Java Kodu:
   
   ```
  ApiUser apiUser = new ApiUser("test", "test");
  CreditOperations creditOperations = new CreditOperations();
  ProcessResult<Credit> result = creditOperations.query(apiUser);
   ```
### 6) İletim Raporu Sorgulama
Raporunu sorgulamak istediğiniz mesajın id'sini kullanmanız gerekir. Bu id'ye sms panelimizden ya da sms gönderme api'sinin döndürdüğü değerden ulaşabilirsiniz.

##### C# Kodu:

   ```
ApiUser apiUser = new ApiUser("test", "test");
ReportOperations reportOps = new ReportOperations();
string messageId = "";
ProcessResult<List<NumberReport>> result = reportOps.GetReport(apiUser, messageId);
   ```
##### Java Kodu:

   ```
  ApiUser apiUser = new ApiUser("test", "test");
  ReportOperations reportOperations = new ReportOperations();
  ProcessResult<List<NumberReport>> result = reportOperations.getReport(apiUser, "message id");
   ```
## İşlem Geri Dönüşlerini Ele Almak

Kütüphanedeki tüm işlemler ProcessResult<T> tipinde döndürülür. ProcessResult<T> sınıfı, işlemin başarı durumunu, açıklamasınu, sunucunun cevap değerini ve varsa işlemden dönecek değeri saklar.
 
 **Örnek:**
```
ProcessResult<string> result = sender.SendMessage(apiUser, message);
```

 Yukarıda mesaj gönderme fonksiyonunun **string** tipinde bir değer döndürdüğü belirtilir.

Bu örnekten yola çıkarsak:
 
 ### a) İşlemin başarı durumunu öğrenme
 
 ##### C# Kodu:
 
 ```
 if(result.IsSuccess)
 {
   //yapılacak işlemler
 }
 ```
 
 ##### Java Kodu:
 
 ```
 if(result.isSuccess()){
 //yapılacak işlemler
 }
 ```
 ### b) İşlemin açıklamasını öğrenme
 
 ##### C# Kodu:
 
 ```
 string desc = result.Description
 ```
 
 ##### Java Kodu:
 
 ```
 String desc = result.getDescription();
 ```
 ### c) Sunucunun cevap değerini öğrenme
 
  ##### C# Kodu:
  
 ```
 string response = result.Response;
 ```
 
 ##### Java Kodu:
 
 ```
 String response = result.getResponse();
 ```
 ### d) İşlemden dönen değeri öğrenme
 
 Mesaj gönderme işlemi **string** değer göndürdüğü için data değişkeninin tipi **string** olacaktır.
 
 ##### C# Kodu:
 
 ```
 string messageId = result.Data;
 ```
 
 ##### Java Kodu:
 
 ```
 String data = result.getData();
 ```
   
 



