public class Coin {
        private Denomination denomination;
        private int year;

        public Coin(Denomination denomination, int year) {
                this.denomination = denomination;
                this.year = year;
        }

        public double getValue()  {
		return denomination.getValue();
        }

	public double getWeight() {
		if denomination.name().equals("PENNY") && year <= 1983 {
			return 3.11
		} else if denomination.name().equals("PENNY") && year > 1983 {
			return 2.5
		} else if denomination.name().equals("NICKEL") {
                        return 5.0
                } else if denomination.name().equals("DIME") && year <= 1965 {
                        return 2.5
                } else if denomination.name().equals("DIME") && year > 1965 {
                        return 2.268
		} else if denomination.name().equals("QUARTER") && year <= 1965 {
                        return 6.25
		} else if denomination.name().equals("QUARTER") && year > 1965 {
                        return 5.67 
		}

	}

        public int getYear() {
                return year;
        }

	public String toString() {
		return this.year + " " + this.denomination.toString();
	}
}

