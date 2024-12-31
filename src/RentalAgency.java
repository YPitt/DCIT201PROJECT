// RentalAgency class

import java.util.List;
import java.util.ArrayList;

class RentalAgency {
    // Singleton pattern
    private static RentalAgency instance;
    private final List<Vehicle> vehicleFleet;
    private final List<RentalTransaction> rentalTransactions;

    // Private constructor
    private RentalAgency() {
        vehicleFleet = new ArrayList<>();
        rentalTransactions = new ArrayList<>();
    }

    // Get instance of RentalAgency
    public static RentalAgency getInstance() {
        if (instance == null) {
            instance = new RentalAgency();
        }
        return instance;
    }

    // Method to add a vehicle to the fleet
    public void addVehicle(Vehicle vehicle) {
        vehicleFleet.add(vehicle);
    }

    // Method to rent a vehicle
    public void rentVehicle(Vehicle vehicle, Customer customer, int days) {
        if (vehicle instanceof Rentable) {
            ((Rentable) vehicle).rent(customer, days);
        } else {
            System.out.println("This vehicle cannot be rented.");
        }
    }

    // Method to generate a report of all rentals
    public void generateRentalReport() {
        System.out.println("Rental Report:");
        for (RentalTransaction transaction : rentalTransactions) {
            System.out.println(transaction);
        }
    }

    // Method to add a rental transaction
    public void addRentalTransaction(RentalTransaction transaction) {
        rentalTransactions.add(transaction);
    }

    // Method to get the vehicle fleet
    public List<Vehicle> getVehicleFleet() {
        return vehicleFleet;
    }

    // Method to get all rental transactions
    public List<RentalTransaction> getRentalTransactions() {
        return rentalTransactions;
    }

    @Override
    public String toString() {
        return "RentalAgency{" +
                "vehicleFleet=" + vehicleFleet +
                ", rentalTransactions=" + rentalTransactions +
                '}';
    }

    public Vehicle findVehicle(String vehicleId) {
        return null;
    }

    public Customer findCustomer(String customerName, String customerAddress) {
        return null;
    }

    public void returnVehicle(Vehicle returnVehicle) {

    }
}