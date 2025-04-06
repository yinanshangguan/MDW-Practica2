package usantatecla.movies.v24;


public class RentalBuilder {

	private usantatecla.movies.v24.Movie movie;
	private int daysRented;
	
	public RentalBuilder movie(Movie movie) {
		this.movie = movie;
		return this;
	}
	
	public RentalBuilder daysRented(int daysRented) {
		this.daysRented = daysRented;
		return this;
	}
	
	public usantatecla.movies.v24.Rental build() {
		return new Rental(movie, daysRented);
	}
	
	
}
