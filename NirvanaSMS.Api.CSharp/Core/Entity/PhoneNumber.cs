namespace NirvanaSMS.Api.Core.Entity
{
    public class PhoneNumber
    {
        public string Number { get; set; }
        public bool IsValid { get; set; }

        public PhoneNumber()
        {

        }

        public PhoneNumber(string phoneNumber)
        {
            Number = phoneNumber; 
        }
    }
}
