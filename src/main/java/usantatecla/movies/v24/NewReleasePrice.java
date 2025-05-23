package usantatecla.movies.v24;

public class NewReleasePrice extends Movie {

	private static final double CHARGE = 3;
	private static final int DAYS_RENTED_THRESHOLD = 1;
	private static final int FREQUENT_RENTER_POINTS = 2;

	public NewReleasePrice(String title) {
		super(title);
	}

	@Override
	public double getCharge(int daysRented) {
		return NewReleasePrice.CHARGE;
	}

	@Override
	public int getFrequentRenterPoints(int daysRented) {
		if (daysRented > NewReleasePrice.DAYS_RENTED_THRESHOLD) {
			return NewReleasePrice.FREQUENT_RENTER_POINTS;
		} else {
			return super.getFrequentRenterPoints(daysRented);
		}
	}

}
