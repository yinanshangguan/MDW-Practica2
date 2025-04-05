package usantatecla.movies.v22;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private final String name;
	private final List<Rental> rentals;

	public Customer(String name) {
		this.name = name;
		this.rentals = new ArrayList<>();
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		StringBuilder result = new StringBuilder();
		result.append("Rental Record for ").append(getName()).append("\n");
		result.append(getRentalRecord());
		result.append("Amount owed is ").append(getTotalCharge()).append("\n");
		result.append("You earned ").append(getTotalFrequentRenterPoints())
				.append(" frequent renter points");
		return result.toString();
	}

	private String getRentalRecord() {
		StringBuilder rentalRecord = new StringBuilder();
		for (Rental rental : rentals) {
			rentalRecord.append("\t")
					.append(rental.getMovie().getTitle())
					.append("\t")
					.append((rental.getCharge()))
					.append("\n");
		}
		return rentalRecord.toString();
	}

	private double getTotalCharge() {
		double result = 0;
		for (Rental rental : this.rentals) {
			result += rental.getCharge();
		}
		return result;
	}

	private int getTotalFrequentRenterPoints() {
		int result = 0;
		for (Rental rental : this.rentals) {
			result += rental.getFrequentRenterPoints();
		}
		return result;
	}

}
