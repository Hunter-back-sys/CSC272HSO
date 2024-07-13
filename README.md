# CSC272HSO

# Introduction

This is my discussion Repo for my Java CSC272 Class at National University. My weekly discussion posts will be done on this and will be pushed to my repo which you can find at:

https://github.com/Hunter-back-sys/CSC272HSO

# Discussion 1 Objects vs Classes in Java

## Classes

### Definition

- **Definition:** A class in Java is similar to a blue print or a recipet it tells the program what properties (variables) and behaviors (methods/functions) that the object produced will be able to preform.
- **Purpose:** Classes are there for us as programmers to call upon when we need to mimic and object in the real world. These Classes are then utilized as instruction to create objects via constructors. In other words they are encapsulators for data of 'fake' real world objects and provide us with methods to manipulate that data that can then be extrapulated on to create a program!

### Example

```java
public class Car {
    // Fields (or instance variables)
    String color;
    String model;

    // Constructor
    public Car(String color, String model) {
        this.color = color;
        this.model = model;
    }

    // Method
    public void drive() {
        System.out.println("Driving the " + color + " " + model);
    }
}
```

### Key Points

- **1.** Classes define the structure and behavior of objects.
- **2.** They can have fields (variables) and methods.
- **3.** They are used as templates to create multiple instances (objects) of the their type.

## Objects

### Definition

- **Definition:** An Object in java is something that is created by a program via a class (as instructions) by its constructor methods. It represents a real-world entity that has state (fields/variables) and behavior (methods/functions).
- **Purpose:** An Objects purpose once created by a Class is to mimic a real-world entity and interact with other objects performing a task, or tasks within a program.

### Example

```java

public class Main {
    public static void main(String[] args) {
        // Creating objects (instances) of the Car class
        Car myCar = new Car("Red", "Toyota");
        Car friendCar = new Car("Blue", "Honda");

        // Using objects
        myCar.drive();
        friendCar.drive();
    }
}
```

### Key Points

- **1.** Objects are instances(A singular constuct) of classes.
- **2.** They have state (stored in fields/variables) and behavior (defined by methods).
- **3.** An Objects state is usually kept private and must be accessed or manipulated through its behavior (Accessors and Mutator methods).
- **4.** Multiple objects can be created from the same class template. (Think of like a single item factory!).

## Comparison

### Similarities

- **Fundementals:** Both classes and objects are fundamental concepts in object-oriented programming.
- **Relationship:** Objects are created from classes.

### Differences

- **Definition:** Classes define the structure and behavior; objects are instances of classes.
- **Usage:** Classes are used to create objects (via Constructors) and define their structure(instance variables and behavior). Objects are used to perform tasks in a program.
- **Multiple Instances:** Multiple objects can be created from a single class definition.

## Conclusion

- Classes serve as blueprints, defining the properties and behaviors that objects will possess. Objects, on the other hand, are instances of these classes, representing specific entities within the program.
