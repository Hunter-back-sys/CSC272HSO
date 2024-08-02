import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

/**
 * <h2>AppointmentTracker.java - A class to represent an appointment tracker with a date, description, and location.</h2>
 * <p>This program will allow users to <>add, view, search for, delete, and edit</> appointments on a persistent
 * memory application.</p>
 *
 * <p><b>Problem statement:</b> The goal of this project is to follow the object-oriented design process described
 * in the course to design and implement an appointment calendar program that allows users to add appointments,
 * remove canceled appointments, and print out a list of appointments for a particular day.</p>
 *
 * @version 1.0
 * @auth Hunter S O'Brien
 */
public class AppointmentTracker {
    // DateTimeFormatter to parse and format date-time strings
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    // Scanner to read user input from the console
    private static final Scanner scanner = new Scanner(System.in);
    // AppointmentManager to manage appointment operations
    private AppointmentManager manager = new AppointmentManager();

    /**
     * Main method to run the AppointmentTracker application.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        AppointmentTracker tracker = new AppointmentTracker();
        tracker.run();
    }

    /**
     * Main loop of the application, displaying the menu and processing user choices.
     */
    public void run() {
        // Add a shutdown hook to save appointments when the program exits
        Runtime.getRuntime().addShutdownHook(new Thread(manager::saveAppointments));
        while (true) {
            showMenu(); // Display the menu to the user
            int choice = Integer.parseInt(scanner.nextLine()); // Read user choice
            switch (choice) {
                case 1:
                    addAppointment(); // Option to add an appointment
                    break;
                case 2:
                    viewAppointments(); // Option to view all appointments
                    break;
                case 3:
                    editAppointment(); // Option to edit an existing appointment
                    break;
                case 4:
                    deleteAppointment(); // Option to delete an appointment
                    break;
                case 5:
                    searchAppointments(); // Option to search for appointments by keyword
                    break;
                case 6:
                    runTests(); // Option to run unit tests
                    break;
                case 7:
                    manager.saveAppointments(); // Save appointments and exit the application
                    System.out.println("Appointments saved. Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again."); // Handle invalid choices
            }
        }
    }

    /**
     * Displays the main menu options to the user.
     */
    private void showMenu() {
        System.out.println("1. Add Appointment");
        System.out.println("2. View Appointments");
        System.out.println("3. Edit Appointment");
        System.out.println("4. Delete Appointment");
        System.out.println("5. Search Appointments");
        System.out.println("6. Run Tests");
        System.out.println("7. Exit");
        System.out.print("Choose an option: ");
    }

    /**
     * Prompts the user to input details for a new appointment and adds it to the manager.
     */
    private void addAppointment() {
        System.out.print("Enter date and time (yyyy-MM-dd HH:mm): ");
        LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine(), formatter); // Parse date-time input
        System.out.print("Enter description: ");
        String description = scanner.nextLine(); // Read appointment description
        System.out.print("Enter location: ");
        String location = scanner.nextLine(); // Read appointment location
        manager.addAppointment(new Appointment(dateTime, description, location)); // Add the appointment
        System.out.println("Appointment added."); // Confirmation message
    }

    /**
     * Displays all current appointments.
     */
    private void viewAppointments() {
        List<Appointment> appointments = manager.viewAppointments(); // Get list of appointments
        if (appointments.isEmpty()) {
            System.out.println("No appointments found."); // No appointments to display
        } else {
            System.out.println("----------Start of Calendar ----------");
            for (int i = 0; i < appointments.size(); i++) {
                System.out.println((i + 1) + ". " + appointments.get(i)); // Display each appointment
            }
            System.out.println("-----------End of Calendar -----------");
        }
    }

    /**
     * Edits an existing appointment based on user input.
     */
    private void editAppointment() {
        viewAppointments(); // Display current appointments
        System.out.print("Enter the number of the appointment to edit: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1; // Get index of the appointment to edit
        if (index >= 0 && index < manager.viewAppointments().size()) {
            // Proceed only if the index is valid
            System.out.print("Enter new date and time (yyyy-MM-dd HH:mm): ");
            LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine(), formatter); // Parse new date-time
            System.out.print("Enter new description: ");
            String description = scanner.nextLine(); // Read new description
            System.out.print("Enter new location: ");
            String location = scanner.nextLine(); // Read new location
            manager.editAppointment(index, new Appointment(dateTime, description, location)); // Edit the appointment
            System.out.println("Appointment edited."); // Confirmation message
        } else {
            System.out.println("Invalid appointment number."); // Handle invalid index
        }
    }

    /**
     * Deletes an existing appointment based on user input.
     */
    private void deleteAppointment() {
        viewAppointments(); // Display current appointments
        System.out.print("Enter the number of the appointment to delete: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1; // Get index of the appointment to delete
        if (index >= 0 && index < manager.viewAppointments().size()) {
            manager.deleteAppointment(index); // Delete the appointment
            System.out.println("Appointment deleted."); // Confirmation message
        } else {
            System.out.println("Invalid appointment number."); // Handle invalid index
        }
    }

    /**
     * Searches for appointments by a keyword provided by the user.
     */
    private void searchAppointments() {
        System.out.print("Enter a keyword to search for: ");
        String keyword = scanner.nextLine(); // Read the search keyword
        List<Appointment> results = manager.searchAppointments(keyword); // Search for matching appointments
        if (results.isEmpty()) {
            System.out.println("No appointments found."); // No matches found
        } else {
            // Display each matching appointment
            for (Appointment appointment : results) {
                System.out.println(appointment);
            }
        }
    }

    /**
     * Runs the unit tests for the AppointmentManager.
     */
    private void runTests() {
        TestAppointmentTracker.runTests(manager); // Invoke the test runner
    }
}
