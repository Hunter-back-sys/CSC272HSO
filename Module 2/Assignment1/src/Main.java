import javax.swing.*;

/**
 * <h2>Main.java - Launches the InterestCalculator GUI application.</h2>
 * <p>This class contains the main method to initialize and run the InterestCalculator application.</p>
 *
 * <p><b>Problem statement:</b> Launch a graphical user interface (GUI) application that calculates the new balance
 * after applying interest over a specified number of years based on the initial deposit and annual interest rate.</p>
 *
 * <p><b>Important Note:</b> I utilize the <code>SwingUtilities.invokeLater</code> function with an arrow function because I am
 * posting this on my Github publicly and its a best practice I was taught at work. For the courses purpose technically you
 * do not need to do this for the class purpose but it is <b>best practice</b>!</p>
 * <div style="text-align: center;"><code><b>public class Main</b></code></div>
 *
 * @version Assignment 1 Module 2
 * @author Hunter S O'Brien
 */
public class Main {
    /**
     * The main method to run the InterestCalculator application.
     * @param args the command line arguments (not used)
     */
    public static void main(String[] args) {
        // Use SwingUtilities.invokeLater to ensure that the GUI creation
        // and updates are performed on the Event Dispatch Thread (EDT).
        SwingUtilities.invokeLater(() -> {
            // Create an instance of InterestCalculator and make it visible
            new InterestCalculator().setVisible(true);
        });
    }
}
