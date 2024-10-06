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
		
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
	        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
		String object_type = DataInputStream.readUTF();
		
		switch (object_type) {
			case "Unlimited":
				Unlimited(br);
			case "Alacarte":
				Alacarte(br);
			defualt:
				throw new IOException("Unknown object type: " + object_type);
		}
	}

	public void save(BufferedWriter bw) throws IOException {
		// write the account object type to the output stream
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        	DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
		dataOutputStream.writeUTF(account.getClass().getName());

		account.save(bw);
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
