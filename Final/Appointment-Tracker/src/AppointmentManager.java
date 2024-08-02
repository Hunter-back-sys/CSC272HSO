import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <h2>AppointmentManager.java - A class to manage appointments with functionalities to add, view, edit, delete, search, save, and load appointments.</h2>
 * <p>This class manages a list of appointments and provides methods to manipulate them, as well as to persist the appointments to a file.</p>
 *
 * <p><b>Problem statement:</b> Create a class to manage appointments, including functionalities to add, view, edit, delete, search, save, and load appointments from a file.</p>
 *
 * <div style="text-align: center;"><code><b>public class AppointmentManager</b></code></div>
 *
 * @version 1.0
 * @auth Hunter S O'Brien
 */
public class AppointmentManager {
    // List to store appointments
    private List<Appointment> appointments;
    // File name to save and load appointments
    private static final String FILE_NAME = "appointments.dat";

    /**
     * Constructor to initialize the appointment manager and load existing appointments from the file.
     */
    public AppointmentManager() {
        appointments = new ArrayList<>();
        loadAppointments();
    }

    /**
     * Adds a new appointment to the list.
     * @param appointment the appointment to add
     */
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    /**
     * Returns a list of all appointments.
     * @return a list of all appointments
     */
    public List<Appointment> viewAppointments() {
        return new ArrayList<>(appointments);
    }

    /**
     * Edits an existing appointment at the specified index.
     * @param index the index of the appointment to edit
     * @param appointment the new appointment data
     */
    public void editAppointment(int index, Appointment appointment) {
        if (index >= 0 && index < appointments.size()) {
            appointments.set(index, appointment);
        }
    }

    /**
     * Deletes an appointment at the specified index.
     * @param index the index of the appointment to delete
     */
    public void deleteAppointment(int index) {
        if (index >= 0 && index < appointments.size()) {
            appointments.remove(index);
        } else {
            System.out.println("Invalid appointment number.");
        }
    }

    /**
     * Searches for appointments that contain the specified keyword in their description or location.
     * @param keyword the keyword to search for
     * @return a list of appointments that match the search criteria
     */
    public List<Appointment> searchAppointments(String keyword) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (appointment.getDescription().contains(keyword) || appointment.getLocation().contains(keyword)) {
                result.add(appointment);
            }
        }
        return result;
    }

    /**
     * Saves the list of appointments to a file.
     */
    public void saveAppointments() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(appointments);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error saving appointments: " + e.getMessage());
        }
    }

    /**
     * Loads the list of appointments from a file.
     */
    public void loadAppointments() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            appointments = (List<Appointment>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No previous appointments found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Clears the list of appointments.
     * @return true if the list of appointments is empty after clearing, false otherwise
     */
    public boolean clearAppointments() {
        appointments = new ArrayList<>();
        return appointments.isEmpty();
    }
}
