using NirvanaSMS.Api.Operations;
using NirvanaSMS.Api.Core.Entity;
using NirvanaSMS.Api.Core.Exceptions;
using NirvanaSMS.Api.Core.Utility;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;

namespace NirvanaSms.Api.ConsoleUI
{
    public class Test
    {
        MessageSender sender = new MessageSender();

        public ProcessResult<string> SendOneToManyMessageTest()
        {
            ApiUser apiUser = new ApiUser("test", "test");

            List<PhoneNumber> numbers = new List<PhoneNumber>
            {
                new PhoneNumber("0555 555 5555"),
            };

            string messageText = "TEST";

            string[] _numbers = new string[] { "0555 555 5555" };

            OneToManyMessage message = new OneToManyMessage().Builder
                                                       .SetHeader("BASLIK")
                                                       .SetNumbers(_numbers) // 
                                                       .SetValidity(2880) //mesajın gerçelilik süresi (belirtilen dakika içerisinde mesajı alıcıya ulaştırmaya çalışır.)
                                                       .SetMessage(messageText) //mesaj metni
                                                       .SetSendDateTime("2018-09-25 11:44:00") //ileri zamanlı mesaj gönderme
                                                       .Build();

            return sender.SendMessage(apiUser, message);
        }

        public ProcessResult<string> SendManyToManyMessageTest()
        {
            ApiUser apiUser = new ApiUser("test", "test");
            MessageSender smsSender = new MessageSender();
            List<PhoneAndMessagePair> phonesAndMessages = new List<PhoneAndMessagePair>()
            {
                new PhoneAndMessagePair("0555 555 5555","TEST 1"),
                new PhoneAndMessagePair("0555 555 5555","TEST 2"),
                new PhoneAndMessagePair("0555 555 5555","TEST 3")
            };

            ManyToManyMessage message = new ManyToManyMessage().Builder
                                                                .SetHeader("BASLIK")
                                                                .SetPhonesAndMessages(phonesAndMessages)
                                                                .SetValidity(2880)
                                                                //.SetSendDateTime("22.9.2018 13:00")
                                                                .Build();
           

            ProcessResult<string> response = smsSender.SendMessage(apiUser, message);
            return response;
        }

        public ProcessResult AddToBlackListTest()
        {
            ApiUser apiUser = new ApiUser("test", "test");
            PhoneNumber number = new PhoneNumber("0555 555 5555");
            BlackListOperations blackListOperations = new BlackListOperations();
            ProcessResult result;

            try
            {
                result = blackListOperations.Add(apiUser, number);
            }
            catch (NonValidPhoneNumberException ex)
            {
                result = new ProcessResult(ex.Message);
            }

            return result;
        }

        public ProcessResult<Credit> QueryCredit()
        {
            ApiUser apiUser = new ApiUser("test", "test");
            CreditOperations creditOps = new CreditOperations();
            return creditOps.Query(apiUser);
        }

        public ProcessResult<string[]> QueryHeaders()
        {
            ApiUser apiUser = new ApiUser("test", "test");
            HeaderOperations headerOps = new HeaderOperations();
            return headerOps.Query(apiUser);
        }

        public ProcessResult<List<NumberReport>> GetReport()
        {
            ApiUser apiUser = new ApiUser("test", "test");
            string messageId = "6228056";
            ReportOperations reportOps = new ReportOperations();
            return reportOps.GetReport(apiUser, messageId);
        }
    }
}
