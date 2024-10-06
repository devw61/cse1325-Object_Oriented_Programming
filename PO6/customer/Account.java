package customer;

import product.Media;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;


abstract public class Account {
	private int accountNumber;
	private static int nextAccountNumber = 1;

	public Account(){ 
		this.accountNumber = nextAccountNumber++; 
	}

	public void Account(BufferedReader br) throws IOException{
		this.accountNumber = Integer.parseInt(br.readLine());
		this.nextAccountNumber = Integer.parseInt(br.readLine());
	}


	public int getAccountNumber(){
		return this.accountNumber;
	}

	public void save(BufferedWriter bw) throws IOException{
		bw.write("" + this.accountNumber + '\n');
		bw.write("" + this.nextAccountNumber + '\n');
	} 

	abstract public String Play(Media media);
}
