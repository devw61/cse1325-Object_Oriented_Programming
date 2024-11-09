package customer;

import product.Media;

abstract public class Account {
	private int accountNumber;
	private static int nextAccountNumber;

	public Account(){ 
		Account.nextAccountNumber++;
		this.accountNumber = nextAccountNumber; 
	}

	public int getAccountNumber(){
		return this.accountNumber;
	}

	abstract public String Play(Media media);
}
