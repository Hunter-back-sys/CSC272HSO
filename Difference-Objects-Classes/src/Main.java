/**
 * <h2>Main.java - Demonstrates the usage of the Car class.</h2>
 * <p>This class creates instances of Car, sets their attributes, and simulates driving the cars.</p>
 *
 * <p><b>Problem statement:</b> Create a main class to demonstrate the functionality of the Car class by creating instances and simulating driving them.</p>
 *
 * <div style="text-align: center;"><code><b>public class Main</b></code></div>
 *
 * @version 1.0
 * @auth Hunter S O'Brien
 */
public class Main {

    /**
     * The main method to demonstrate the functionality of the Car class.
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Creating objects (instances) of the Car class
        Car myCar = new Car("Red", "Toyota");
        Car friendCar = new Car("Blue", "Honda");

        // Using objects
        myCar.drive();
        friendCar.drive();
    }
}
