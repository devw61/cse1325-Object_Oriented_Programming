package customer;

import product.Media;
import customer.Account;

public class Student {
	private String name;
	private int id;
	private String email;
	private Account account;

	public Student(String name, int id, String email, boolean unlimited){
		this.email = email;
		if (this.email.endsWith("@uta.edu") || this.email.endsWith("@mavs.uta.edu")) {
			this.id = id;
        	        this.name = name;
			if (unlimited) {
				this.account = new Unlimited();
			} else {
	                	this.account = new Alacarte();
			}
		} else {
                	throw new IllegalArgumentException("Non-UTA email address: " + this.email);
        	}
	}

	
	public String requestMedia(Media media){
		return account.Play(media);
	}

	public Account getAccount() {
		return this.account;
	}

	@Override
	public String toString() {
		return this.name + '(' + this.id  + ", " + this.email + ", Account: #" + this.account.getAccountNumber() + ')'; 
	}
}
