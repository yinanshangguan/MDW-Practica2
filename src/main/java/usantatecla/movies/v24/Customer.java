package usantatecla.movies.v24;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Customer {

	private final String name;
	private final List<Rental> rentals = new ArrayList<>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public String statement() {
		return new CustomerView(this).printStatement();
	}

	public String getRentalRecord() {
		String record = rentals.stream()
				.map(rental -> "\t" + rental.getMovie().getTitle() + "\t" + rental.getCharge())
				.collect(Collectors.joining("\n"));
		return record.isEmpty() ? record : record + "\n";
	}

	public double getTotalCharge() {
		return rentals.stream().mapToDouble(Rental::getCharge).sum();
	}

	public int getTotalFrequentRenterPoints() {
		return rentals.stream().mapToInt(Rental::getFrequentRenterPoints).sum();
	}
}
