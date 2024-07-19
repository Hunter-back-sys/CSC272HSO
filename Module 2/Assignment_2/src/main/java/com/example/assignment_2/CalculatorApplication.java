package com.example.assignment_2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * <h2>CalculatorApplication.java - A JavaFX application for calculating interest.</h2>
 * <p>This class launches the JavaFX application, setting up the primary stage and loading the FXML layout.</p>
 *
 * <p><b>Problem statement:</b> Create a JavaFX application that calculates the new balance after applying interest over a specified number of years based on the initial deposit and annual interest rate.</p>
 *
 * <div style="text-align: center;"><code><b>public class CalculatorApplication extends Application</b></code></div>
 *
 * @version Assignment 2 Module 2
 * @author Hunter S O'Brien
 */
public class CalculatorApplication extends Application {
    /**
     * The start method is called after the JavaFX application is initialized.
     * It sets up the primary stage and loads the FXML layout.
     *
     * @param stage the primary stage for this application
     * @throws IOException if the FXML file cannot be loaded
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Load the FXML file using FXMLLoader
        FXMLLoader fxmlLoader = new FXMLLoader(CalculatorApplication.class.getResource("hello-view.fxml"));

        // Create a scene with the loaded FXML layout, with specified width and height
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        // Set the title of the stage (window)
        stage.setTitle("Interest Calculator");

        // Set the scene to the stage
        stage.setScene(scene);

        // Show the stage
        stage.show();
    }

    /**
     * The main method is the entry point of the application.
     * It launches the JavaFX application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Launch the JavaFX application
        launch();
    }
}
