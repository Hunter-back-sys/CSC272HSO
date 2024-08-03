import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * <h2>Test Suite for Appointment Management System</h2>
 * <p><b>Description:</b> This class provides a set of tests for the AppointmentManager class,
 * which handles operations such as adding, viewing, editing, deleting, and searching appointments.</p>
 * <ul>
 *   <li><code><b>final DateTimeFormatter</b></code> formatter - A formatter for parsing and formatting date-time strings</li>
 * </ul>
 * <p><b>Discussion Items:</b></p>
 * <ul>
 *   <li>Tests the core functionalities of adding, viewing, editing, and deleting appointments</li>
 *   <li>Includes tests for searching appointments by keyword and by date</li>
 *   <li>Ensures appointments are correctly persisted and loaded from a file</li>
 *   <li>Verifies the clearing of appointments and the deletion of the appointments file</li>
 * </ul>
 * @version 1.1
 * @author Hunter O'Brien
 */
public class TestAppointmentTracker {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static void runTests(AppointmentManager manager) {
        System.out.println("Running tests...");

        // Clear any existing appointments
        manager.viewAppointments().clear();
        manager.saveAppointments();

        // Test adding an appointment
        LocalDateTime startDateTime1 = LocalDateTime.parse("2024-08-01 10:00", formatter);
        LocalDateTime endDateTime1 = LocalDateTime.parse("2024-08-01 11:00", formatter);
        Appointment appointment1 = new Appointment(startDateTime1, endDateTime1, "Doctor's Appointment", "Clinic");
        manager.addAppointment(appointment1);
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
        LocalDateTime startDateTime2 = LocalDateTime.parse("2024-08-02 11:00", formatter);
        LocalDateTime endDateTime2 = LocalDateTime.parse("2024-08-02 12:00", formatter);
        Appointment appointment2 = new Appointment(startDateTime2, endDateTime2, "Dentist Appointment", "Dental Clinic");
        manager.editAppointment(0, appointment2);
        if (manager.viewAppointments().size() == 1 && manager.viewAppointments().get(0).equals(appointment2)) {
            System.out.println("Test Edit Appointment: PASSED");
        } else {
            System.out.println("Test Edit Appointment: FAILED");
        }

        // Test deleting an appointment
        manager.deleteAppointment(0);
        if (manager.viewAppointments().isEmpty()) {
            System.out.println("Test Delete Appointment: PASSED");
        } else {
            System.out.println("Test Delete Appointment: FAILED");
        }

        // Test searching appointments by keyword
        manager.addAppointment(appointment1);
        manager.addAppointment(appointment2);
        if (manager.searchAppointments("Doctor").contains(appointment1) && manager.searchAppointments("Dentist").contains(appointment2)) {
            System.out.println("Test Search Appointments: PASSED");
        } else {
            System.out.println("Test Search Appointments: FAILED");
        }

        // Test searching appointments by date
        List<Appointment> dateSearchResults = manager.searchAppointmentsByDate(startDateTime1.toLocalDate());
        if (dateSearchResults.contains(appointment1) && !dateSearchResults.contains(appointment2)) {
            System.out.println("Test Search Appointments by Date: PASSED");
        } else {
            System.out.println("Test Search Appointments by Date: FAILED");
        }

        // Reset the manager to a blank state
        manager.viewAppointments().clear();
        manager.clearAppointments();
        manager.saveAppointments();

        // Delete the file here!
        File file = new File("appointments.dat");
        if (file.delete()) {
            System.out.println("Memory file deleted successfully.");
        } else {
            System.out.println("Failed to delete the memory file.");
        }

        System.out.println("All tests completed. Memory reset to blank slate.");
    }
}
