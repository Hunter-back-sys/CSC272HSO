import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * <h2>Appointment.java - A class to represent an appointment with a date, description, and location.</h2>
 * <p>This class implements Serializable and provides methods to get and set the appointment details, as well as to compare appointments and convert them to a string.</p>
 *
 * <p><b>Problem statement:</b> Create a class to represent an appointment, including date, description, and location, with methods to manipulate and display these details.</p>
 *
 * <div style="text-align: center;"><code><b>public class Appointment implements Serializable</b></code></div>
 *
 * @version 1.0
 * @auth Hunter S O'Brien
 */
public class Appointment implements Serializable {
    private static final long serialVersionUID = 1L;

    // Instance variables to store the appointment's date, description, and location
    private LocalDateTime dateTime;
    private String description;
    private String location;

    /**
     * Constructor to create an appointment with the specified date, description, and location.
     * @param dateTime the date and time of the appointment
     * @param description the description of the appointment
     * @param location the location of the appointment
     */
    public Appointment(LocalDateTime dateTime, String description, String location) {
        this.dateTime = dateTime;
        this.description = description;
        this.location = location;
    }

    /**
     * Gets the date and time of the appointment.
     * @return the date and time of the appointment
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * Sets the date and time of the appointment.
     * @param dateTime the new date and time of the appointment
     */
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * Gets the description of the appointment.
     * @return the description of the appointment
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the appointment.
     * @param description the new description of the appointment
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the location of the appointment.
     * @return the location of the appointment
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location of the appointment.
     * @param location the new location of the appointment
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Compares this appointment to another object for equality.
     * @param o the object to compare to
     * @return true if the other object is an Appointment with the same date, description, and location, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Appointment) {
            Appointment that = (Appointment) o;
            return this.dateTime.equals(that.dateTime) && Objects.equals(this.description, that.description) && Objects.equals(this.location, that.location);
        }
        return false;
    }

    /**
     * Returns a string representation of the appointment.
     * @return a string representation of the appointment
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "Appointment{" +
                "dateTime=" + dateTime.format(formatter) +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
