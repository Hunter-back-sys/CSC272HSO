import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <h2>Manages a collection of appointments, allowing addition, editing, deletion, and search functionality</h2>
 * <p><b>Description:</b> This class maintains a list of appointments with functionalities to add, view, edit, delete, and search appointments. Appointments can also be saved to and loaded from a file.</p>
 * <ul>
 *   <li><code><b>List<Appointment></b></code> appointments - A list to store appointment objects</li>
 *   <li><code><b>final String</b></code> FILE_NAME - The name of the file used for saving and loading appointments</li>
 * </ul>
 * <p><b>Discussion Items:</b></p>
 * <ul>
 *   <li>Provides methods for adding, viewing, editing, and deleting appointments</li>
 *   <li>Includes search functionality by keyword and by date</li>
 *   <li>Implements methods for saving appointments to a file and loading appointments from a file</li>
 *   <li>Handles file-related exceptions gracefully</li>
 * </ul>
 * @version 1.1
 * @author Hunter O'Brien
 */
public class AppointmentManager {
    private List<Appointment> appointments;
    private static final String FILE_NAME = "appointments.dat";

    /**
     * Constructs an AppointmentManager and loads any existing appointments from the file.
     */
    public AppointmentManager() {
        appointments = new ArrayList<>();
        loadAppointments();
    }

    /**
     * Adds an appointment to the list.
     * @param appointment the appointment to be added
     */
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    /**
     * Returns a list of all appointments.
     * @return a list of appointments
     */
    public List<Appointment> viewAppointments() {
        return new ArrayList<>(appointments);
    }

    /**
     * Edits an existing appointment at a specified index.
     * @param index the index of the appointment to edit
     * @param appointment the new appointment details
     */
    public void editAppointment(int index, Appointment appointment) {
        if (index >= 0 && index < appointments.size()) {
            appointments.set(index, appointment);
        }
    }

    /**
     * Deletes an appointment at a specified index.
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
     * Searches for appointments containing a keyword in the description or location.
     * @param keyword the keyword to search for
     * @return a list of matching appointments
     */
    public List<Appointment> searchAppointments(String keyword) {
        keyword = keyword.toLowerCase();// normalize the keyword
        List<Appointment> result = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (appointment.getDescription().toLowerCase().contains(keyword) || appointment.getLocation().toLowerCase().contains(keyword)) {//normalize the search
                result.add(appointment);
            }
        }
        return result;
    }

    /**
     * Searches for appointments occurring on a specific date.
     * @param date the date to search for
     * @return a list of appointments on the specified date
     */
    public List<Appointment> searchAppointmentsByDate(LocalDate date) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (appointment.getStartDateTime().toLocalDate().equals(date) || appointment.getEndDateTime().toLocalDate().equals(date)) {
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
     * Clears all appointments from the list.
     * @return true if the appointments list is empty after clearing
     */
    public boolean clearAppointments() {
        appointments = new ArrayList<>();
        return appointments.isEmpty();
    }
}
