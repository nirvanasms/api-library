namespace NirvanaSMS.Api.Core.Entity
{
    public class Credit
    {
        public int Amount { get; set; }

        public Credit()
        {

        }

        public Credit(int amount)
        {
            Amount = amount;
        }
    }
}
