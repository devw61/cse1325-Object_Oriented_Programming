package customer;

import product.Media;
import customer.Account;
import java.io.*;

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
	
	public Student(BufferedReader br) throws IOException {
		try {
			String object_type = br.readLine();

			switch (object_type) {
				case "customer.Unlimited":
					account = new Unlimited(br);
					break;
				case "customer.Alacarte":
					account = new Alacarte(br);
					break;
				default:
					throw new IOException("Unknown object type: " + object_type);
			}

			this.name = br.readLine();
			this.id = Integer.parseInt(br.readLine());
			this.email = br.readLine();
		} catch (Exception e) {
			System.err.println("Could not read account: " + e);
		}
    }

    public void save(BufferedWriter bw) throws IOException {
        bw.write("" + account.getClass().getName() + '\n');
		
        account.save(bw);
		bw.write("" + this.name + '\n');
		bw.write("" + this.id + '\n');
		bw.write("" + this.email + '\n');
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
