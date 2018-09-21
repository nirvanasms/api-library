package org.nirvanasms.api.core.entity;

import org.nirvanasms.api.core.base.UserBase;

public class ApiUser extends UserBase {
	 public ApiUser()
     {
       
     }

     public ApiUser(String userName, String apiPassword)
     {
         super.setUserName(userName);
         super.setApiPassword(apiPassword);
     }
}
