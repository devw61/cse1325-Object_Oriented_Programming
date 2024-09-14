package customer;

import product.Media;

public class Account {
	private int accountNumber;
	private static int nextAccountNumber;

	public Account(){ 
		Account.nextAccountNumber++;
		this.accountNumber = nextAccountNumber; 
	}

	public int getAccountNumber(){
		return this.accountNumber;
	}

	public String Play(Media media){
		StringBuilder media_playing = new StringBuilder();
		for (int i = 0; i<media.toString().length(); i++) { 
			if (i < media.toString().indexOf('(')){
				media_playing.append(media.toString().charAt(i) ); 
			} else {
				break;
			}
		}
		return "Playing " + media_playing;
	}
}
