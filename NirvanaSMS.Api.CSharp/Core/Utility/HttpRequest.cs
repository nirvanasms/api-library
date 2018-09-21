using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;
using System.Web;
using static NirvanaSMS.Api.Core.Utility.Enums;

namespace NirvanaSMS.Api.Core.Utility
{
    public class HttpRequest
    {
        public static IDictionary<string, string> PostItem = new Dictionary<string, string>();
        public string XmlItem { get; set; }
        public RequestParameterType ParameterType { get; set; }
        public RequestMethod RequestMethod { get; set; }
        public static string ResponseString;
        public string Url { get; set; }

        public HttpRequest(string url, IDictionary<string, string> postItems, RequestMethod requestMethod)
        {
            Url = url;
            PostItem = postItems;
            ParameterType = RequestParameterType.Text;
            RequestMethod = requestMethod;
        }

        public HttpRequest(string url, string xmlItem, RequestMethod requestMethod)
        {
            Url = url;
            XmlItem = xmlItem;
            ParameterType = RequestParameterType.Xml;
            RequestMethod = requestMethod;
        }

        public string Send()
        {
            string result = "";
            if (RequestMethod == RequestMethod.Post && ParameterType == RequestParameterType.Xml)
                result = PostXml();
            else if (RequestMethod == RequestMethod.Post && ParameterType == RequestParameterType.Text)
                result = PostText();
            else if (RequestMethod == RequestMethod.Get && ParameterType == RequestParameterType.Xml)
                result = GetXml();
            else if (RequestMethod == RequestMethod.Get && ParameterType == RequestParameterType.Text)
                result = GetText();

            return result;
        }

        private string PostText()
        {
            List<string> PostArray = new List<string>();
            foreach (KeyValuePair<string, string> Item in PostItem)
            {
                PostArray.Add(Item.Key + "=" + Item.Value);
            }
            HttpWebRequest Request = (HttpWebRequest)WebRequest.Create(@Url);
            var PostData = Encoding.ASCII.GetBytes(string.Join("&", PostArray.ToArray()));
            Request.Method = "POST";
            Request.ContentType = "application/x-www-form-urlencoded";
            Request.ContentLength = PostData.Length;
            using (var Stream = Request.GetRequestStream())
            {
                Stream.Write(PostData, 0, PostData.Length);
            }
            HttpWebResponse Response = (HttpWebResponse)Request.GetResponse();
            ResponseString = new StreamReader(Response.GetResponseStream()).ReadToEnd();
            return ResponseString;
        }

        private string PostXml()
        {
            HttpWebRequest request = (HttpWebRequest)WebRequest.Create(new Uri(Url));
            request.Method = "POST";
            request.Timeout = 7000;
            request.ContentType = "text/xml; charset=UTF-8";

            byte[] xmlData = Encoding.UTF8.GetBytes(XmlItem);

            request.ContentLength = xmlData.Length;
            using (var stream = request.GetRequestStream())
            {
                stream.Write(xmlData, 0, xmlData.Length);
            }
            using (HttpWebResponse response = request.GetResponse() as HttpWebResponse)
            {
                StreamReader reader = new StreamReader(response.GetResponseStream());
                return reader.ReadToEnd();
            }
        }

        private string GetText()
        {
            //TODO
            return "";
        }

        private string GetXml()
        {
            //TODO
            return "";
        }

        public string GetResponse()
        {
            List<string> PostArray = new List<string>();
            foreach (KeyValuePair<string, string> Item in PostItem)
                PostArray.Add(Item.Key + "=" + Item.Value);
            
            var PostData = string.Join("&", PostArray.ToArray());
            string requestUrl = string.Format("{0}?{1}", Url, PostData);

            HttpWebRequest request = (HttpWebRequest)WebRequest.Create(requestUrl);
            request.MaximumAutomaticRedirections = 4;
            request.Credentials = CredentialCache.DefaultCredentials;

            HttpWebResponse response = (HttpWebResponse)request.GetResponse();
            Stream receiveStream = response.GetResponseStream();
            StreamReader readStream = new StreamReader(receiveStream, Encoding.UTF8);

            ResponseString = readStream.ReadToEnd();
            response.Close();
            readStream.Close();
            return ResponseString;
        }
    }
}
