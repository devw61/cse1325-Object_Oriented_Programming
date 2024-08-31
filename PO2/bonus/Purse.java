public class Purse {
	public static void main(String[] args) {
		// initialize  fields
		Coin coins[] = new Coin[5];
		double total = 0.0 ;
		int earliest_date = 4000;
		int latest_date = 0;
				
		// add elements to coins
		coins[0] = new Coin(Denomination.PENNY, 2024);
                coins[1] = new Coin(Denomination.DIME, 1980);
                coins[2] = new Coin(Denomination.NICKEL, 1905);
                coins[3] = new Coin(Denomination.NICKEL, 1956);
                coins[4] = new Coin(Denomination.QUARTER, 2011);
			
		for (Coin coin : coins) {
			System.out.printf("%s %d", coin.getYear(), coin.getValue());
			total = total + coin.getValue();
			if (earliest_date > coin.getYear()) {
				earliest_date = coin.getYear();
			}
			if (latest_date < coin.getYear()) {
				latest_date = coin.getYear();
			}
		}

		System.out.println("You have $" + total + " in coins between " + earliest_date + " and " + latest_date);
	}
}
