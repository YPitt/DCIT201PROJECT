// Customer class

import java.util.List;
import java.util.ArrayList;

class Customer {
    // Encapsulated fields
    private String name;
    private final String address;
    private List<RentalTransaction> rentalHistory;

    // Constructor with validation
    public Customer(String name, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be empty.");
        }
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Customer address cannot be empty.");
        }
        this.name = name;
        this.address = address;
        this.rentalHistory = new ArrayList<RentalTransaction>();
    }

    // Getters and setters with validation
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    // Method to add a rental transaction to the customer's history
    public void addRentalTransaction(RentalTransaction transaction) {
        rentalHistory.add(transaction);
    }

    // Method to get the customer's rental history
    public List<RentalTransaction> getRentalHistory() {
        return rentalHistory;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", rentalHistory=" + rentalHistory +
                '}';
    }
}
