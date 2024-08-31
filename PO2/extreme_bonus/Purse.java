public class Purse {
	public static void main(String[] args) {
		// initialize  fields
		Coin coins[] = new Coin[5];
		double total_amount = 0.0 ;
		double total_weight = 0.0 ;
		int earliest_date = Integer.MAX_VALUE;
		int latest_date = Integer.MIN_VALUE;
				
		// add elements to coins
		coins[0] = new Coin(Denomination.PENNY, 2024);
                coins[1] = new Coin(Denomination.DIME, 1980);
                coins[2] = new Coin(Denomination.NICKEL, 1905);
                coins[3] = new Coin(Denomination.NICKEL, 1956);
                coins[4] = new Coin(Denomination.QUARTER, 2011);
			
		for (Coin coin : coins) {
			System.out.printf("%s\n", coin.toString());
			total_amount = total_amount+ coin.getValue();
			total_weight = total_weight+ coin.getWeight();
			if (earliest_date > coin.getYear()) {
				earliest_date = coin.getYear();
			}
			if (latest_date < coin.getYear()) {
				latest_date = coin.getYear();
			}
		}

		System.out.printf("You have $%.2f in coins between %d and %d weighing %.3f grams\n", total_amount, earliest_date, latest_date, total_weight);
	}
}
