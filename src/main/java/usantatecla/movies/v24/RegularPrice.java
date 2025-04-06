package usantatecla.movies.v24;

public class RegularPrice extends Movie {

	private static final double CHARGE = 2.0;
	private static final double EXTRA_CHARGE = 1.5;
	private static final int DAYS_RENTED_THRESHOLD = 2;

	public RegularPrice(String title) {
		super(title);
	}

	@Override
	public double getCharge(int daysRented) {
		double result = RegularPrice.CHARGE;
		if (daysRented > RegularPrice.DAYS_RENTED_THRESHOLD) {
			result += (daysRented - RegularPrice.DAYS_RENTED_THRESHOLD) * RegularPrice.EXTRA_CHARGE;
		}
		return result;
	}

}
