// Truck class extending Vehicle
class Truck extends Vehicle implements Rentable {
    // Additional truck-specific features
    private double cargoCapacity;

    public Truck(String vehicleId, double baseRentalRate, boolean isAvailable) {
        super(vehicleId, baseRentalRate, isAvailable);
        this.cargoCapacity = cargoCapacity;
    }

    // Getter for cargo capacity
    public double getCargoCapacity() {
        return cargoCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        return baseRentalRate * days;
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable;
    }

    @Override
    public void rent(Customer customer, int days) {
        if (isAvailableForRental()) {
            // Update availability status
            setAvailable(false);
            // Record rental transaction
            RentalTransaction transaction = new RentalTransaction(this, customer, days);
            // Add transaction to customer's rental history
            customer.addRentalTransaction(transaction);
            // Update rental agency's records
            RentalAgency.getInstance().addRentalTransaction(transaction);
            System.out.println("Truck rented successfully!");
        } else {
            System.out.println("Truck is not available for rental.");
        }
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
        System.out.println("Truck returned successfully.");
    }

    @Override
    public String toString() {
        return "Truck{" +
                "cargoCapacity=" + cargoCapacity +
                ", vehicleId='" + vehicleId + '\'' +
                ", model='" + model + '\'' +
                ", baseRentalRate=" + baseRentalRate +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
