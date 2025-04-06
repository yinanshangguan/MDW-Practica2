package usantatecla.movies.v24;

import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class CustomerTest {

	@Test
	public void testBillingFunctionality() {

		String movieName = "movieName";
		usantatecla.movies.v24.Movie regularMovie = new MovieBuilder().title(movieName).regular().build();

		String newReleaseMovieName = "newReleaseMovieName";
		usantatecla.movies.v24.Movie newReleaseMovie = new MovieBuilder().title(newReleaseMovieName).newRelease().build();

		String childrensMovieName = "childrensMovieName";
		usantatecla.movies.v24.Movie childrensMovie = new MovieBuilder().title(childrensMovieName).childrens().build();

		// Test case 1: Test billing for regular movie rentals
		Double rental1Day = regularMovie.getCharge(1);
		Double rental2Days = regularMovie.getCharge(2);
		Double rental3Days = regularMovie.getCharge(3);
		assertEquals(Double.valueOf(2.0), rental1Day);
		assertEquals(Double.valueOf(2.0), rental2Days);
		assertEquals(Double.valueOf(3.5), rental3Days);

		// Test case 2: Test billing for new release movie rentals
		Double newReleaseRental1Day = newReleaseMovie.getCharge(1);
		Double newReleaseRental2Days = newReleaseMovie.getCharge(2);
		Double newReleaseRental3Days = newReleaseMovie.getCharge(3);
		assertEquals(Double.valueOf(3.0), newReleaseRental1Day);
		assertEquals(Double.valueOf(3.0), newReleaseRental2Days);
		assertEquals(Double.valueOf(3.0), newReleaseRental3Days);

		// Test case 3: Test billing for children's movie rentals
		Double childrensRental1Day = childrensMovie.getCharge(1);
		Double childrensRental3Days = childrensMovie.getCharge(3);
		Double childrensRental4Days = childrensMovie.getCharge(4);
		assertEquals(Double.valueOf(1.5), childrensRental1Day);
		assertEquals(Double.valueOf(1.5), childrensRental3Days);
		assertEquals(Double.valueOf(6), childrensRental4Days);
	}

	@Test
	public void testFrequentRenterPoints() {

		String newReleaseMovieName = "newReleaseMovieName";
		usantatecla.movies.v24.Movie newReleaseMovie = new MovieBuilder().title(newReleaseMovieName).newRelease().build();

		int pointsFor1Day = newReleaseMovie.getFrequentRenterPoints(1);
		int pointsFor2Days = newReleaseMovie.getFrequentRenterPoints(2);
		int pointsFor3Days = newReleaseMovie.getFrequentRenterPoints(3);

		assertEquals(1, pointsFor1Day);
		assertEquals(2, pointsFor2Days);
		assertEquals(2, pointsFor3Days);
	}

	@Test
	public void testStatementFormat() {

		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).build();

		// Test case 1: Statement when customer has no rentals
		String statementWithoutRentals = customer.statement();
		String expectedWithoutRentals = "Rental Record for " + customerName + "\n"
				+ "Amount owed is 0.0\n"
				+ "You earned 0 frequent renter points";
		assertEquals(expectedWithoutRentals, statementWithoutRentals);

		// Test case 2: Statement when customer has rentals
		usantatecla.movies.v24.Movie regularMovie = new MovieBuilder().title("regularMovie").regular().build();
		Movie newReleaseMovie = new MovieBuilder().title("newReleaseMovie").newRelease().build();
		usantatecla.movies.v24.Rental regularRental = new RentalBuilder().movie(regularMovie).daysRented(2).build();
		Rental newReleaseRental = new RentalBuilder().movie(newReleaseMovie).daysRented(3).build();
		customer.addRental(regularRental);
		customer.addRental(newReleaseRental);

		String statementWithRentals = customer.statement();
		String expectedWithRentals = "Rental Record for " + customerName + "\n"
				+ "\tregularMovie\t2.0\n"
				+ "\tnewReleaseMovie\t3.0\n"
				+ "Amount owed is 5.0\n"
				+ "You earned 3 frequent renter points";
		assertEquals(expectedWithRentals, statementWithRentals);
	}
}
