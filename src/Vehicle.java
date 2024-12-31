// Abstract Vehicle class
abstract class Vehicle {
    // Encapsulated fields
    public String vehicleId;
    public String model;
    protected double baseRentalRate;
    public boolean isAvailable;


    // Constructor with validation
    public Vehicle(String vehicleId, double baseRentalRate, boolean isAvailable) {
        if (vehicleId == null || vehicleId.isEmpty()) {
            throw new IllegalArgumentException("Vehicle ID cannot be empty.");
        }
        if (model == null || model.isEmpty()) {
            throw new IllegalArgumentException("Vehicle model cannot be empty.");
        }
        if (baseRentalRate <= 0) {
            throw new IllegalArgumentException("Base rental rate must be positive.");
        }
        this.vehicleId = vehicleId;
        this.model = model;
        this.baseRentalRate = baseRentalRate;
        this.isAvailable = isAvailable;
    }

    // Getters and setters with validation
    public String getVehicleId() {
        return vehicleId;
    }

    public String getModel() {
        return model;
    }

    public double getBaseRentalRate() {
        return baseRentalRate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    // Abstract methods for rental calculation
    public abstract double calculateRentalCost(int days);

    public abstract boolean isAvailableForRental();


    // Add returnVehicle method to Vehicle class
    public void returnVehicle() {
        setAvailable(true);
        System.out.println("Vehicle returned successfully.");
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId='" + vehicleId + '\'' +
                ", model='" + model + '\'' +
                ", baseRentalRate=" + baseRentalRate +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
