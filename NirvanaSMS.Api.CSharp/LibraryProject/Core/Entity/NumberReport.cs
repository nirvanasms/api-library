namespace NirvanaSMS.Api.Core.Entity
{
    public class NumberReport
    {
        public PhoneNumber Number { get; set; }
        public StatusCode StatusCode { get; set; }

        public NumberReport(PhoneNumber number, StatusCode statusCode)
        {
            Number = number;
            StatusCode = statusCode;
        }
    }
}
