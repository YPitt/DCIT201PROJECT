// Car class extending Vehicle
class Car extends Vehicle implements Rentable {
    // Additional car-specific features
    private int passengerCapacity;

    public Car(String vehicleId, String model, double baseRentalRate, boolean isAvailable, int passengerCapacity) {
        super(vehicleId, baseRentalRate, isAvailable);
        this.passengerCapacity = passengerCapacity;
    }

    public Car(String toyotaCorolla, int i, boolean b) {
        super(toyotaCorolla, i, b);
    }

    // Getter for passenger capacity
    public int getPassengerCapacity() {
        return passengerCapacity;
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
            System.out.println("Car rented successfully!");
        } else {
            System.out.println("Car is not available for rental.");
        }
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
        System.out.println("Car returned successfully.");
    }

    @Override
    public String toString() {
        return "Car{" +
                "passengerCapacity=" + passengerCapacity +
                ", vehicleId='" + vehicleId + '\'' +
                ", model='" + model + '\'' +
                ", baseRentalRate=" + baseRentalRate +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
