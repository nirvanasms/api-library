using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

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
