public class Student {
	private String name;
	private int id;
	private String email;
	private Account account;

	public Student(String name, int id, String email){
		this.email = email;
		if (!this.email.endsWith("@mavs.edu") && !this.email.endsWith("@mavs.uta.edu")) {
                	throw new IllegalArgumentException("Non-UTA email address: " + this.email);
        	}

		this.id = id;
		this.name = name;
		this.account = new Account();
	}

	
	public String requestMedia(Media media){
		return account.Play(media);
	}

	@Override
	public String toString() {
		return this.name + '(' + this.id  + ", " + this.email + ", Account: #" + this.account.getAccountNumber() + ')'; 
	}
}
