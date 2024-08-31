public class Coin {
        private Denomination denomination;
        private int year;

        public Coin(Denomination denomination, int year) {
                this.denomination = denomination;
                this.year = year;
        }

        public static double getValue() {
		return Denomination.getValue();
        }

        public int getYear() {
                return year;
        }

	public String toString() {
		return this.year + " " + this.denomination.toString();
	}
}

