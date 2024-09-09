public class Account {
	int accountNumber;
	static int nextAccountNumber;

	public Account(){ 
		this.accountNumber = nextAccountNumber; 
		this.nextAccountNumber = nextAccountNumber++;
	}

	public int getAccountNumber(){
		return this.accountNumber;
	}

	public String Play(Media media){
		private StringBuilder media_playing = new StringBuilder;
		for (char i : media.toString().indexOf('(') ) { media_playing.append(media[i]); }
		return "Playing " + media_playing;
	}
}
