package org.nirvanasms.api.core.entity;

public class Credit {
	private int amount;
	
	public Credit(){}
	
	public Credit(int amount){
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
