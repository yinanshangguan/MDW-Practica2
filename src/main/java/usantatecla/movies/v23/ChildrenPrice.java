package usantatecla.movies.v23;

public class ChildrenPrice extends Movie {

	private static final double CHARGE = 1.5;
	private static final double EXTRA_CHARGE = 1.5;
	private static final int DAYS_RENTED_THRESHOLD = 3;

	public ChildrenPrice(String title) {
		super(title);
	}

	@Override
	public double getCharge(int daysRented) {
		double result = ChildrenPrice.CHARGE;
		if (daysRented > ChildrenPrice.DAYS_RENTED_THRESHOLD) {
			result += (daysRented - 1) * ChildrenPrice.EXTRA_CHARGE;
		}
		return result;
	}

}
