import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <h2>Manages appointments with start and end times, descriptions, and locations</h2>
 * <p><b>Description:</b> This class has four private instance variables:</p>
 * <ul>
 *   <li><code><b>LocalDateTime</b></code> startDateTime - The start date and time of the appointment</li>
 *   <li><code><b>LocalDateTime</b></code> endDateTime - The end date and time of the appointment</li>
 *   <li><code><b>String</b></code> description - The description of the appointment</li>
 *   <li><code><b>String</b></code> location - The location of the appointment</li>
 * </ul>
 * <p><b>Discussion Items:</b></p>
 * <ul>
 *   <li>All instance variables are <code>Private</code></li>
 *   <li>Provides getter and setter methods for all instance variables</li>
 *   <li>Includes a <code><b>toString</b></code> method for a formatted string representation of the appointment</li>
 * </ul>
 * @author Hunter O'Brien
 * @version 1.0
 * @author Hunter O'Brien
 */
public class Appointment implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private LocalDateTime startDateTime; // Start date and time of the appointment
    private LocalDateTime endDateTime;   // End date and time of the appointment
    private String description;          // Description of the appointment
    private String location;             // Location of the appointment

    /**
     * Constructs a new Appointment with the specified details.
     * @param startDateTime the start date and time of the appointment
     * @param endDateTime the end date and time of the appointment
     * @param description the description of the appointment
     * @param location the location of the appointment
     */
    public Appointment(LocalDateTime startDateTime, LocalDateTime endDateTime, String description, String location) {
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.description = description;
        this.location = location;
    }

    /**
     * Gets the start date and time of the appointment.
     * @return the start date and time
     */
    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    /**
     * Sets the start date and time of the appointment.
     * @param startDateTime the new start date and time
     */
    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    /**
     * Gets the end date and time of the appointment.
     * @return the end date and time
     */
    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    /**
     * Sets the end date and time of the appointment.
     * @param endDateTime the new end date and time
     */
    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    /**
     * Gets the description of the appointment.
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the appointment.
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the location of the appointment.
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location of the appointment.
     * @param location the new location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Returns a string representation of the appointment.
     * @return a string representation of the appointment
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "Appointment{" +
                "startDateTime=" + startDateTime.format(formatter) +
                ", endDateTime=" + endDateTime.format(formatter) +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
