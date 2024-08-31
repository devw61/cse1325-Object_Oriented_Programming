public class Purse {
	public static void main(String[] args) {
		private Coin coins = [1, 3, 4, 1, 2];
		private int year = [1920, 2024, 2000, 1987, 1956];
		private int toal = 0 ;
		private earliest_date = 4000;
		private latest_date = 0;

		for (coin : coins) {
			total += coin.getValue();
			if earliest_date > coin.getYear() {
				earliest_date = coin.getYear();
			} else if latest_date < coin.getYear() {
				latest_date = coin.getYear();
			}
		}

		System.out.println("You have $" + total + " in coins between " + earliest_date + " and " + latest_date);
	}
}
