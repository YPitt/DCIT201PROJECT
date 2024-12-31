import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * The Main class provides a console-based interface for a vehicle rental agency system.
 * It allows users to interact with the system for renting vehicles, returning vehicles,
 * and generating rental reports. The application maintains a vehicle fleet and manages
 * rental transactions through the RentalAgency class.
 *
 * This class handles the user interaction, including displaying options, reading input,
 * and delegating operations like vehicle rentals, returns, and generating reports to
 * the RentalAgency instance.
 *
 * The following features are implemented:
 * - Viewing available vehicles for rent based on type
 * - Renting a vehicle to a customer
 * - Returning a rented vehicle
 * - Generating and displaying a rental report
 * - Handling invalid input for better user experience
 *
 * The class utilizes various vehicle types (Car, Motorcycle, Truck) that implement the
 * Vehicle interface, and employs a singleton pattern for the RentalAgency to ensure
 * centralized data management.
 */
public class Main {
    private static RentalAgency agency;
    private static Vehicle motorcycle;
    private static Vehicle truck;
    private static Vehicle car;
    private static Customer customer1;
    private static Customer customer2;
    private static String vehicleType;
    private static int choice;

    public static <RentalRecord> void main(String[] args) {

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Create a RentalAgency instance
        RentalAgency agency = RentalAgency.getInstance();

        // Main loop for user interaction
        // Initialization of vehicles and customers
        do {
            // Display menu options
            System.out.println("\nRental Agency Menu:");
            System.out.println("1. Rent a vehicle");
            System.out.println("2. Return a vehicle");
            System.out.println("3. Generate rental report");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            // Read user choice
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            // Process user choice
            String vehicleId = null;
            if (choice == 1) {// Rent a vehicle
                System.out.print("Enter vehicle type (car, motorcycle, truck): ");
                String vehicleType = scanner.nextLine(); // Read user input

                List<? extends Vehicle> vehicles;

                switch (vehicleType.toLowerCase()) {
                    case "car" -> vehicles = List.of(
                            new Car("Toyota Corolla", 5, true),
                            new Car("Honda Civic", 5, true),
                            new Car("Ford F-150", 6, false),
                            new Car("BMW 3 Series", 5, true),
                            new Car("Chevrolet Spark", 4, false),
                            new Car("Tesla Model 3", 5, true)
                    );
                    case "motorcycle" -> vehicles = List.of(
                            new Motorcycle("Harley Davidson", 2, true),
                            new Motorcycle("Honda CBR", 2, true),
                            new Motorcycle("Yamaha R1", 2, true)
                    );
                    case "truck" -> vehicles = List.of(
                            new Truck("Ford F-250", 4, true),
                            new Truck("Chevrolet Silverado", 4, true),
                            new Truck("Ram 1500", 4, true)
                    );
                    default -> {
                        System.out.println("Invalid vehicle type. Please enter car, motorcycle, or truck.");
                        return;
                    }
                }

                System.out.println("Available " + vehicleType + "s:");
                int index = 1;
                for (Vehicle vehicle : vehicles) {
                    System.out.println(index++ + ". " + vehicle); // Numbered list
                }

                System.out.printf("Select a %s to rent (1-%d): ", vehicleType, vehicles.size());
                System.out.printf("Select a %s to rent (1-%d): ", vehicleType, vehicles.size());
                int selectedIndex = Integer.parseInt(scanner.nextLine());
                if (selectedIndex < 1 || selectedIndex > vehicles.size()) {
                    System.out.println("Invalid selection. Please choose a valid number.");
                    return;
                }

                Vehicle selectedVehicle = vehicles.get(selectedIndex - 1);
                vehicleId = selectedVehicle.getVehicleId(); // Use selected vehicle's ID
            }
            System.out.print("Enter customer name: ");
            String customerName = scanner.nextLine();
            System.out.print("Enter customer address: ");
            String customerAddress = scanner.nextLine();
            System.out.print("Enter rental duration (days): ");
            int rentalDays;
            try {
                System.out.print("Enter rental duration (days): ");
                rentalDays = Integer.parseInt(scanner.nextLine());
                if (rentalDays <= 0) {
                    throw new IllegalArgumentException("Rental duration must be positive.");
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("Invalid input for rental duration. Please enter a positive integer.");
                return;
            }
            // Find the vehicle and customer
            Vehicle vehicle = agency.findVehicle(vehicleId);
            Customer customer = agency.findCustomer(customerName, customerAddress);

            // Rent the vehicle
            if (vehicle != null && customer != null) {
                agency.rentVehicle(vehicle, customer, rentalDays);
                System.out.println("Vehicle rented successfully!");
            } else {
                System.out.println("Vehicle or customer not found.");
            }
            break;
             } else if (choice == 2) {
            // Return a vehicle
            System.out.print("Enter vehicle ID: ");
            String returnVehicleId = scanner.nextLine();
            if (returnVehicleId.isEmpty()) {
                System.out.println("Vehicle ID cannot be empty. Please try again.");
                return;
            }

            // Find the vehicle
            Vehicle returnVehicle = agency.findVehicle(returnVehicleId);

            // Return the vehicle
            if (returnVehicle != null) {
                returnVehicle.returnVehicle();
                System.out.println("Vehicle returned successfully!");
            } else {
                System.out.println("Vehicle not found.");
            }
        } else if (choice == 3) {
            // Generate rental report
            agency.generateRentalReport();
            System.out.println("Rental Report:");
            for (RentalTransaction record : agency.getRentalTransactions()) {
                System.out.println("Customer: " + record.getCustomer().getName());
                System.out.println("Vehicle Model: " + record.getVehicle().getModel());
                System.out.println("Return Date: " + record.getReturnDate());
                System.out.println("Rental Cost: $" + record.getRentalCost());
                System.out.println("-----------------------");
            }
        } else if (choice == 4) {
            // Exit the program
            System.out.println("Exiting program...");
            scanner.close();
            return;
        } else {
            System.out.println("Invalid choice. Please try again.");
        }

    }  // Initialize the agency with sample data before starting the main loop

 }



