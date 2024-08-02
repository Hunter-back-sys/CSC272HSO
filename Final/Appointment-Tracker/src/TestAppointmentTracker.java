import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A class to test the functionalities of the AppointmentManager.
 */
public class TestAppointmentTracker {
    // DateTimeFormatter to parse and format date-time strings
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    /**
     * Method to run tests on the AppointmentManager.
     * @param manager The AppointmentManager instance to be tested.
     */
    public static void runTests(AppointmentManager manager) {
        System.out.println("Running tests...");

        // Clear any existing appointments and save the cleared state
        manager.viewAppointments().clear();
        manager.saveAppointments();

        // Test adding an appointment
        LocalDateTime dateTime1 = LocalDateTime.parse("2024-08-01 10:00", formatter);
        Appointment appointment1 = new Appointment(dateTime1, "Doctor's Appointment", "Clinic");
        manager.addAppointment(appointment1);

        // Check if the appointment was added correctly
        if (manager.viewAppointments().size() == 1 && manager.viewAppointments().get(0).equals(appointment1)) {
            System.out.println("Test Add Appointment: PASSED");
        } else {
            System.out.println("Test Add Appointment: FAILED");
        }

        // Test viewing appointments
        if (manager.viewAppointments().contains(appointment1)) {
            System.out.println("Test View Appointments: PASSED");
        } else {
            System.out.println("Test View Appointments: FAILED");
        }

        // Test editing an appointment
        LocalDateTime dateTime2 = LocalDateTime.parse("2024-08-02 11:00", formatter);
        Appointment appointment2 = new Appointment(dateTime2, "Dentist Appointment", "Dental Clinic");
        manager.editAppointment(0, appointment2);

        // Check if the appointment was edited correctly
        if (manager.viewAppointments().size() == 1 && manager.viewAppointments().get(0).equals(appointment2)) {
            System.out.println("Test Edit Appointment: PASSED");
        } else {
            System.out.println("Test Edit Appointment: FAILED");
        }

        // Test deleting an appointment
        manager.deleteAppointment(0);

        // Check if the appointment was deleted correctly
        if (manager.viewAppointments().isEmpty()) {
            System.out.println("Test Delete Appointment: PASSED");
        } else {
            System.out.println("Test Delete Appointment: FAILED");
        }

        // Test searching appointments
        manager.addAppointment(appointment1);
        manager.addAppointment(appointment2);

        // Check if the search functionality works correctly
        if (manager.searchAppointments("Doctor").contains(appointment1) && manager.searchAppointments("Dentist").contains(appointment2)) {
            System.out.println("Test Search Appointments: PASSED");
        } else {
            System.out.println("Test Search Appointments: FAILED");
        }

        // Reset the manager to a blank state and check if it's cleared
        if(manager.clearAppointments()) {
            System.out.println("Test Reset Appointments: PASSED");
        } else {
            System.out.println("Test Reset Appointments: FAILED");
        }

        // Delete the file storing appointments
        File file = new File("appointments.dat");
        if (file.delete()) {
            System.out.println("Memory file deleted successfully.");
        } else {
            System.out.println("Failed to delete the memory file.");
        }

        System.out.println("All tests completed. Memory reset to blank slate.");
    }
}
