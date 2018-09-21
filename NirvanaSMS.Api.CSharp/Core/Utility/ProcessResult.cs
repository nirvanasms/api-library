using NirvanaSMS.Api.Core.Entity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NirvanaSMS.Api.Core.Utility
{
    public class ProcessResult<T>
    {
        public bool IsSuccess { get; set; }
        public string Response { get; set; }
        public string Description { get; set; }
        public T Data { get; set; }

        public ProcessResult()
        {

        }

        public ProcessResult(string response)
        {
            Response = response;
            setDescriptionAndSuccess(response);
        }

        public ProcessResult(string response, T data)
        {
            Response = response;
            setDescriptionAndSuccess(response);
            Data = data;
        }

        void setDescriptionAndSuccess(string response)
        {
            string code = response.Substring(0, 2);
            StatusCode status = StatusCodes.GetByCode(code);
            Description = string.Format("İşlem Kodu: {0}\nİşlem Açıklaması:{1}", status.Code, status.Description);
            IsSuccess = status.IsSuccess;
        }
    }

    public class ProcessResult
    {
        public bool IsSuccess { get; set; }
        public string Response { get; set; }
        public string Description { get; set; }

        public ProcessResult()
        {

        }

        public ProcessResult(string response)
        {
            Response = response;
            setDescriptionAndSuccess(response);
        }

        void setDescriptionAndSuccess(string response)
        {
            if (response.Length >= 2)
            {
                string code = response.Substring(0, 2);
                StatusCode status = StatusCodes.GetByCode(code);
                Description = string.Format("İşlem Kodu: {0}\nİşlem Açıklaması:{1}", status.Code, status.Description);
                IsSuccess = status.IsSuccess;
            }
            else
                IsSuccess = false;
        }
    }
}
