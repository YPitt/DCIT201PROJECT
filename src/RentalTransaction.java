// RentalTransaction class
class RentalTransaction {
    // Encapsulated fields
    private Vehicle vehicle;
    private Customer customer;
    private int rentalDays;

    // Constructor with validation
    public RentalTransaction(Vehicle vehicle, Customer customer, int rentalDays) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null.");
        }
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null.");
        }
        if (rentalDays <= 0) {
            throw new IllegalArgumentException("Rental days must be positive.");
        }
        this.vehicle = vehicle;
        this.customer = customer;
        this.rentalDays = rentalDays;
    }

    // Getters for vehicle, customer, and rental days
    public Vehicle getVehicle() {
        return vehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    @Override
    public String toString() {
        return "RentalTransaction{" +
                "vehicle=" + vehicle +
                ", customer=" + customer +
                ", rentalDays=" + rentalDays +
                '}';
    }

    public String getReturnDate() {
        return null;
    }

    public String getRentalCost() {
        return null;
    }
}