package test;

import customer.Alacarte;
import customer.Unlimited;
import product.Media;

public class TestAccount {
	public static void main(String[] args){
		Alacarte acc1 = new Alacarte();
		Unlimited acc2 = new Unlimited();

		if (acc1.getAccountNumber() != 1) {
			System.err.println("Error: acc1's account number is not 1, value: " + acc1.getAccountNumber());
		}
		if (acc2.getAccountNumber() != 2) {
			System.err.println("Error: acc2's account number is not 2, value: " + acc2.getAccountNumber());
		}

	}
}
