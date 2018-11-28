using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NirvanaSms.Api;
using NirvanaSMS.Api.Core.Utility;
using NirvanaSMS.Api.Core.Entity;

namespace NirvanaSms.Api.ConsoleUI
{
    class Program
    {
        static Test test = new Test();

        static void Main(string[] args)
        {
            string choice;
            do { choice = CreateMenu(); Navigate(choice); } while (choice.Trim().ToLower() != "ç");


            ProcessResult<string> response = test.SendOneToManyMessageTest();
            Console.WriteLine("IsSuccess = {0}\nResponse = {1}\nData = {2}\nDescription={3}", response.IsSuccess, response.Response, response.Data, response.Description);
            //string xml = "<sms><username>nirvanasms</username><password>4b37aae82b5b0b8b57446c616cd524b2</password><header>NirvanaSMS</header><validity>2880</validity><message><gsm><no>0507 698 2056</no></gsm><msg><![CDATA[İletişim talebiniz alınmıştır.2 En kısa zamanda size döneceğiz.]]></msg></message></sms>";

            //string result = messageTest.postXMLData("http://panel.1sms.com.tr:8080/api/smspost/v1",xml);
            //Console.WriteLine("Sonuç: {0}", result);
            Console.WriteLine("Gönderildi.");
            Console.ReadKey();
        }

        static void SendOneToManyMessage()
        {
            ProcessResult<string> response = test.SendOneToManyMessageTest();
            Console.WriteLine("IsSuccess = {0}\nResponse = {1}\nData = {2}\nDescription={3}", response.IsSuccess, response.Response, response.Data, response.Description);
            Console.ReadKey();
        }

        static void SendManyToManyMessage()
        {
            ProcessResult<string> response = test.SendManyToManyMessageTest();
            Console.WriteLine("IsSuccess = {0}\nResponse = {1}\nData = {2}\nDescription={3}", response.IsSuccess, response.Response, response.Data, response.Description);
            Console.ReadKey();
        }

        static void AddToBlackList()
        {
            ProcessResult response = test.AddToBlackListTest();
            Console.WriteLine("IsSuccess = {0}\nResponse = {1}\nDescription={2}", response.IsSuccess, response.Response, response.Description);
            Console.ReadKey();
        }

        static void QueryCredit()
        {
            ProcessResult<Credit> response = test.QueryCredit();
            Console.WriteLine("IsSuccess = {0}\nResponse = {1}\nDescription={2}\nData={3}", response.IsSuccess, response.Response, response.Description, response.Data.Amount);
            Console.ReadKey();
        }

        static void QueryHeaders()
        {
            ProcessResult<string[]> response = test.QueryHeaders();
            Console.WriteLine("IsSuccess = {0}\nResponse = {1}\nDescription={2}\nData={3}", response.IsSuccess, response.Response, response.Description, string.Join(",", response.Data));
            Console.ReadKey();
        }

        static void GetReport()
        {
            ProcessResult<List<NumberReport>> response = test.GetReport();
            Console.WriteLine("IsSuccess = {0}\nResponse = {1}\nDescription={2}", response.IsSuccess, response.Response, response.Description);
            if(response.Data.Any())
            {
                Console.WriteLine("\nRapor :");
                Console.WriteLine("\n-------------------------------------------------------------------\n");
                
                response.Data.ForEach(x => Console.WriteLine("Gsm: {0} Durum: {1}", x.Number.Number, x.StatusCode.Description));
            }

            Console.ReadKey();
        }

        static string CreateMenu()
        {
            Console.Clear();
            Console.WriteLine("MENÜ");
            Console.WriteLine("1) 1-N Mesaj Gönder");
            Console.WriteLine("2) N-N Mesaj Gönder");
            Console.WriteLine("3) Kara Listeye Ekle");
            Console.WriteLine("4) Kredi Miktarını Sorgula");
            Console.WriteLine("5) Başlıkları Sorgula");
            Console.WriteLine("6) Mesaj Raporu");
            Console.WriteLine("Ç) Çıkış");
            Console.Write("Seçim : ");
            return Console.ReadLine();
        }

        public static void Navigate(string choice)
        {
            switch (choice)
            {
                case "1":
                    SendOneToManyMessage();
                    break;
                case "2":
                    SendManyToManyMessage();
                    break;
                case "3":
                    AddToBlackList();
                    break;
                case "4":
                    QueryCredit();
                    break;
                case "5":
                    QueryHeaders();
                    break;
                case "6":
                    GetReport();
                    break;
                case "ç":
                    Environment.Exit(0);
                    break;
                default:
                    CreateMenu();
                    break;
            }
        }
    }
}
