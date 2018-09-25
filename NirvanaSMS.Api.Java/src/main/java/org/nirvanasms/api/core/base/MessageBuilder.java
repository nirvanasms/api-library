package org.nirvanasms.api.core.base;

import java.util.Date;

import org.nirvanasms.api.core.interfaces.IBuilder;

public abstract class MessageBuilder<T,T2> extends MessageBase implements IBuilder<T> {
	
	 public abstract T2 validity(int validity);

     public abstract T2 header(String header);

     public abstract T2 sendDateTime(String dateTime, String datePattern);

     public abstract T2 sendDateTime(Date dateTime);
     
	@Override
	public abstract T build();
}
