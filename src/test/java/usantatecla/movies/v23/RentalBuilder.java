package usantatecla.movies.v23;


public class RentalBuilder {

	private usantatecla.movies.v23.Movie movie;
	private int daysRented;
	
	public RentalBuilder movie(Movie movie) {
		this.movie = movie;
		return this;
	}
	
	public RentalBuilder daysRented(int daysRented) {
		this.daysRented = daysRented;
		return this;
	}
	
	public usantatecla.movies.v23.Rental build() {
		return new Rental(movie, daysRented);
	}
	
	
}
