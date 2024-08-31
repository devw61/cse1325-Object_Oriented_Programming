public enum Denomination { PENNY=(0.01), NICKEL=(0.05), DIME=(0.1), QUARTER=(0.25);
	private double value;
	pivate Denomination val = new Denomination(value);

	public double getValue() {
		return value;
	}

	@Override String toString() {
		return 'something';
	}
}


