/**
 * <h2>Car.java - Represents a car with a color and model.</h2>
 * <p>This class provides methods to initialize a car object and simulate driving the car.</p>
 *
 * <p><b>Problem statement:</b> Create a class to represent a car with a color and model, allowing for the initialization of these attributes and simulating the action of driving the car.</p>
 *
 * <div style="text-align: center;"><code><b>public class Car</b></code></div>
 *
 * @version 1.0
 * @auth Hunter S O'Brien
 */
public class Car {
    // Fields (or instance variables)
    private String color;
    private String model;

    /**
     * Constructor to initialize a Car object with a color and model.
     * @param color the color of the car
     * @param model the model of the car
     */
    public Car(String color, String model) {
        this.color = color;
        this.model = model;
    }

    /**
     * Simulates driving the car by printing a message to the console.
     */
    public void drive() {
        System.out.println("Driving the " + color + " " + model);
    }
}
