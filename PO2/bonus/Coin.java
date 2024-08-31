public class Coin {
        private Denomination denomination;
        private int year;

        public Coin(Denomination denomination, int year) {
                this.denomination = denomination;
                this.year = year;
        }

        public double getValue() {
		return Denomination.getValue();
        }

        public int getYear() {
                return year;
        }

	@Override String toString() {
		return coin.getYear() + " " + coin.getValue();
	}
}

