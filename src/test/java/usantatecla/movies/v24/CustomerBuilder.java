package usantatecla.movies.v24;


import java.util.ArrayList;
import java.util.List;

public class CustomerBuilder {

	private String name;
	private List<usantatecla.movies.v24.Rental> rentals;

	public CustomerBuilder() {
		rentals = new ArrayList<>();
	}

	public CustomerBuilder name(String name) {
		this.name = name;
		return this;
	}

	public CustomerBuilder rental(usantatecla.movies.v24.Rental rental) {
		rentals.add(rental);
		return this;
	}

	public usantatecla.movies.v24.Customer build() {
		usantatecla.movies.v24.Customer customer = new Customer(name);
		for(Rental rental : rentals) {
			customer.addRental(rental);
		}
		return customer;
	}
}

