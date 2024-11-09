public class Coin {
        private Denomination denomination;
        private int year;

        public Coin(Denomination denomination, int year) {
                this.denomination = denomination;
                this.year = year;
        }

        public double getValue() {
                switch(denomination) {
                        case PENNY:
                                return .01;
                        case NICKEL:
                                return .05;
                        case DIME:
                                return .10;
                        case QUARTER:
                                return .25;
                        default:
                                System.out.print("invalid coin");
				return 0.0;
                }
        }

        public int getYear() {
                return year;
        }
}

