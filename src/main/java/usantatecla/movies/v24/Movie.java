package usantatecla.movies.v24;

public class Movie {

	private final String title;

	private static final int FREQUENT_RENTER_POINTS = 1;

	public Movie(String title) {
		this.title = title;

	}

	public double getCharge(int daysRented){ return 0; }

	public int getFrequentRenterPoints(int daysRented) {
		return FREQUENT_RENTER_POINTS;
	}

	public String getTitle() {
		return title;
	}

}
