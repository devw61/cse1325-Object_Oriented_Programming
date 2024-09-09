public class TestAccount {
        public static void main(String[] args){
		Account acc1 = new Account();
		Account acc2 = new Account();
		
		if (acc1.getAccountNumber() != 1) {
			throw new IllegalArgumentException("Error: acc1's account number is not 1");
		} else if (acc2.getAccountNumber() != 2) {
			throw new IllegalArgumentException("Error: acc2's account number is not 2");
		}
        }
}
