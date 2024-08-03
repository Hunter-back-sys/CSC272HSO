import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

/**
 * <h2>Appointment Tracker Application</h2>
 * <p><b>Description:</b> This class provides a command-line interface for managing appointments.
 * Users can add, view, edit, delete, and search for appointments, as well as run tests to validate the functionality.</p>
 * <ul>
 *   <li><code><b>final DateTimeFormatter</b></code> formatter - A formatter for parsing and formatting date-time strings.</li>
 *   <li><code><b>final Scanner</b></code> scanner - A scanner for reading user input from the command line.</li>
 *   <li><code><b>AppointmentManager</b></code> manager - An instance of AppointmentManager to handle appointment operations.</li>
 * </ul>
 * <p><b>Discussion Items:</b></p>
 * <ul>
 *   <li>Provides a menu-driven interface for managing appointments.</li>
 *   <li>Includes options to add, view, edit, delete, and search appointments by keyword and date.</li>
 *   <li>Incorporates test functionality to validate core operations.</li>
 *   <li>Saves appointments to a file and loads them upon startup.</li>
 * </ul>
 * @version 1.1
 * @author Hunter O'Brien
 */
public class AppointmentTracker {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static final Scanner scanner = new Scanner(System.in);
    private AppointmentManager manager = new AppointmentManager();

    public static void main(String[] args) {
        AppointmentTracker tracker = new AppointmentTracker();
        tracker.run(); // Start the application
    }

    public void run() {
        // Add a shutdown hook to save appointments when the application is closed
        Runtime.getRuntime().addShutdownHook(new Thread(manager::saveAppointments));

        while (true) { // Continuous loop for user interaction
            showMenu(); // Display the main menu
            try{
            int choice = Integer.parseInt(scanner.nextLine()); // Get user input

            // Switch statement to handle user choices
            switch (choice) {
                case 1:
                    addAppointment(); // Add a new appointment
                    break;
                case 2:
                    viewAppointments(); // View existing appointments
                    break;
                case 3:
                    editAppointment(); // Edit an existing appointment
                    break;
                case 4:
                    deleteAppointment(); // Delete an existing appointment
                    break;
                case 5:
                    searchAppointments(); // Search appointments by keyword
                    break;
                case 6:
                    runTests(); // Run tests for the appointment management functionality
                    break;
                case 7:
                    searchAppointmentsByDate(); // Search appointments by date
                    break;
                case 8:
                    manager.saveAppointments(); // Save appointments and exit the application
                    System.out.println("Appointments saved. Exiting...");
                    System.exit(0); // Exit the application
                    break;
                default:
                    System.out.println("Invalid choice. Please try again."); // Handle invalid input
            }
            }catch (Exception e) {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void showMenu() {
        // Display the main menu options
        System.out.println("Main Menu:");
        System.out.println("1. Add Appointment");
        System.out.println("2. View Appointments");
        System.out.println("3. Edit Appointment");
        System.out.println("4. Delete Appointment");
        System.out.println("5. Search Appointments by Keyword");
        System.out.println("6. Run Tests");
        System.out.println("7. Search Appointments by Date");
        System.out.println("8. Exit");
        System.out.print("Choose an option (1-8): ");
    }

    private void addAppointment() {
        // Prompt user for appointment details
        System.out.print("Enter start date and time (yyyy-MM-dd HH:mm): ");
        LocalDateTime startDateTime = LocalDateTime.parse(scanner.nextLine(), formatter);

        System.out.print("Enter end date and time (yyyy-MM-dd HH:mm): ");
        LocalDateTime endDateTime = LocalDateTime.parse(scanner.nextLine(), formatter);

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        System.out.print("Enter location: ");
        String location = scanner.nextLine();

        // Create a new appointment and add it to the manager
        manager.addAppointment(new Appointment(startDateTime, endDateTime, description, location));
        System.out.println("Appointment added."); // Confirmation message
    }

    private void viewAppointments() {
        // Retrieve the list of appointments
        List<Appointment> appointments = manager.viewAppointments();

        // Check if the appointment list is empty
        if (appointments.isEmpty()) {
            System.out.println("No appointments found."); // Inform the user
        } else {
            // Display the appointments
            System.out.println("----------Start of Calendar----------");
            for (int i = 0; i < appointments.size(); i++) {
                System.out.println((i + 1) + ". " + appointments.get(i)); // Print each appointment
            }
            System.out.println("-----------End of Calendar-----------");
        }
    }

    private void editAppointment() {
        viewAppointments(); // Show current appointments to the user
        System.out.print("Enter the number of the appointment to edit: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1; // Get the selected appointment index

        // Validate the index
        if (index >= 0 && index < manager.viewAppointments().size()) {
            // Prompt user for updated appointment details
            System.out.print("Enter new start date and time (yyyy-MM-dd HH:mm): ");
            LocalDateTime startDateTime = LocalDateTime.parse(scanner.nextLine(), formatter);

            System.out.print("Enter new end date and time (yyyy-MM-dd HH:mm): ");
            LocalDateTime endDateTime = LocalDateTime.parse(scanner.nextLine(), formatter);

            System.out.print("Enter new description: ");
            String description = scanner.nextLine();

            System.out.print("Enter new location: ");
            String location = scanner.nextLine();

            // Update the appointment in the manager
            manager.editAppointment(index, new Appointment(startDateTime, endDateTime, description, location));
            System.out.println("Appointment edited."); // Confirmation message
        } else {
            System.out.println("Invalid appointment number."); // Error message for invalid input
        }
    }

    private void deleteAppointment() {
        viewAppointments(); // Show current appointments to the user
        System.out.print("Enter the number of the appointment to delete: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1; // Get the selected appointment index

        // Validate the index
        if (index >= 0 && index < manager.viewAppointments().size()) {
            manager.deleteAppointment(index); // Delete the appointment from the manager
            System.out.println("Appointment deleted."); // Confirmation message
        } else {
            System.out.println("Invalid appointment number."); // Error message for invalid input
        }
    }

    private void searchAppointments() {
        // Prompt user for a keyword to search
        System.out.print("Enter a keyword to search for: ");
        String keyword = scanner.nextLine();

        // Search appointments using the keyword
        List<Appointment> results = manager.searchAppointments(keyword);

        // Check if any appointments match the search criteria
        if (results.isEmpty()) {
            System.out.println("No appointments found."); // Inform the user
        } else {
            // Display matching appointments
            System.out.println("----------Start of Calendar----------");
            for (Appointment appointment : results) {
                System.out.println(appointment); // Print each matching appointment
            }
            System.out.println("-----------End of Calendar-----------");
        }
    }

    private void searchAppointmentsByDate() {
        // Prompt user for a date to search
        System.out.print("Enter a date to search for (yyyy-MM-dd): ");
        LocalDate date = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // Search appointments using the specified date
        List<Appointment> results = manager.searchAppointmentsByDate(date);

        // Check if any appointments match the date
        if (results.isEmpty()) {
            System.out.println("No appointments found."); // Inform the user
        } else {
            // Display matching appointments
            System.out.println("----------Start of Calendar----------");
            for (Appointment appointment : results) {
                System.out.println(appointment); // Print each matching appointment
            }
            System.out.println("-----------End of Calendar-----------");
        }
    }

    private void runTests() {
        TestAppointmentTracker.runTests(manager); // Run predefined tests to validate functionality
    }
}
