package test;

import customer.Account;

public class TestAccount {
        public static void main(String[] args){
		Account acc1 = new Account();
		Account acc2 = new Account();
		
		if (acc1.getAccountNumber() != 1) {
			System.err.println("Error: acc1's account number is not 1, value: " + acc1.getAccountNumber());
		}
		if (acc2.getAccountNumber() != 2) {
			System.err.println("Error: acc2's account number is not 2, value: " + acc2.getAccountNumber());
		}

		if (acc1.getAccountNumber() != 4) {
                        System.err.println("Error: acc1's account number is not 4, value: " + acc1.getAccountNumber());
                }
                if (acc2.getAccountNumber() != 10) {
                        System.err.println("Error: acc2's account number is not 10, value: " + acc2.getAccountNumber());
                }
        }
}
