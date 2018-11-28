using System;

namespace NirvanaSMS.Api.Core.Base
{
    public abstract class MessageBase
    {
        public string Header { get; set; }
        public DateTime? SendDateTime { get; set; } = null;
        public int ValidityTime { get; set; }
    }
}
