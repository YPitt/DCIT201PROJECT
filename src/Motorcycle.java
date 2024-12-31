// Motorcycle class extending Vehicle
class Motorcycle extends Vehicle implements Rentable {
    // Additional motorcycle-specific features
    private boolean hasSidecar;

    public Motorcycle(String vehicleId, double baseRentalRate, boolean isAvailable) {
        super(vehicleId, baseRentalRate, isAvailable);
        this.hasSidecar = hasSidecar;
    }

    // Getter for hasSidecar
    public boolean isHasSidecar() {
        return hasSidecar;
    }

    @Override
    public double calculateRentalCost(int days) {
        double cost = baseRentalRate * days;
        // Add a surcharge for sidecar
        if (hasSidecar) {
            cost += 10.0 * days;
        }
        return cost;
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
            System.out.println("Motorcycle rented successfully!");
        } else {
            System.out.println("Motorcycle is not available for rental.");
        }
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
        System.out.println("Motorcycle returned successfully.");
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "hasSidecar=" + hasSidecar +
                ", vehicleId='" + vehicleId + '\'' +
                ", model='" + model + '\'' +
                ", baseRentalRate=" + baseRentalRate +
                ", isAvailable=" + isAvailable +
                '}';
    }
}