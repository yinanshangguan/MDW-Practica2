package usantatecla.movies.v24;

public class CustomerView {
    private Customer customer;

    CustomerView(Customer customer){this.customer = customer; }

    public String printStatement() {
        String result = "Rental Record for " + customer.getName() + "\n";
        result += customer.getRentalRecord();
        result += "Amount owed is " + (customer.getTotalCharge()) + "\n";
        result += "You earned " + (customer.getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

}
