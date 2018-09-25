using NirvanaSMS.Api.Core.Base;
using NirvanaSMS.Api.Core.Entity;
using System.Linq;
using System.Text;
using System.Xml;

namespace NirvanaSMS.Api.Core.Utility
{
    public class XmlHelper
    {
        public static string GetMessageXml(ApiUser apiUser, MessageBase message)
        {
            OneToManyMessage oneToManyMessage;
            ManyToManyMessage manyToManyMessage;
            StringBuilder stringBuilder = new StringBuilder();
            XmlWriterSettings settings = new XmlWriterSettings() { Encoding = Encoding.UTF8, Indent = true, IndentChars = "\t" };

            using (var stringWriter = new StringWriterWithEncoding(Encoding.UTF8))
            {
                using (XmlWriter writer = XmlWriter.Create(stringWriter, settings))
                {
                    writer.WriteStartElement("sms");
                    writer.WriteElementString("username", apiUser.UserName);
                    writer.WriteElementString("password", apiUser.ApiPassword);
                    writer.WriteElementString("header", message.Header);
                    writer.WriteElementString("validity", message.ValidityTime.ToString());
                    if (message.SendDateTime.HasValue)
                        writer.WriteElementString("sendDateTime", message.SendDateTime.Value.ToString("yyyy.M.dd.HH.m.s"));

                    if (message is OneToManyMessage)
                    {
                        oneToManyMessage = message as OneToManyMessage;
                        writer.WriteStartElement("message");
                        writer.WriteStartElement("gsm");
                        oneToManyMessage.GsmNumbers.Where(x => x.IsValid).ToList().ForEach(x => writer.WriteElementString("no", x.Number));
                        writer.WriteEndElement();//end gsm
                        writer.WriteStartElement("msg");
                        writer.WriteCData(oneToManyMessage.Message);
                        writer.WriteEndElement();//end msg
                        writer.WriteEndElement();//end message
                        writer.WriteEndElement();//end sms
                    }
                    else if (message is ManyToManyMessage)
                    {
                        manyToManyMessage = message as ManyToManyMessage;
                        writer.WriteStartElement("messages");
                        foreach (var item in manyToManyMessage.PhonesAndMessages)
                        {
                            if (item.Number.IsValid)
                            {
                                writer.WriteStartElement("mb");
                                writer.WriteElementString("no", item.Number.Number);
                                writer.WriteStartElement("msg");
                                writer.WriteCData(item.Message);
                                writer.WriteEndElement();//msg
                                writer.WriteEndElement();//end mb
                            }
                        }
                        writer.WriteEndElement();//end messages
                        writer.WriteEndElement();//end sms
                    }
                    writer.Flush();
                }

                return stringWriter.ToString();
            }
        }
    }
}
