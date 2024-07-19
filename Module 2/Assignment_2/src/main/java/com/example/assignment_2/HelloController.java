package com.example.assignment_2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.text.DecimalFormat;

/**
 * <h2>HelloController.java - A controller for the Interest Calculator GUI application using JavaFX.</h2>
 * <p>This class handles the interactions between the user and the GUI components for calculating the new balance after applying interest.</p>
 *
 * <p><b>Problem statement:</b> Create a JavaFX application that calculates the new balance after applying interest over a specified number of years based on the initial deposit and annual interest rate.</p>
 *
 * <div style="text-align: center;"><code><b>public class HelloController</b></code></div>
 *
 * @version Assignment 2 Module 2
 * @author Hunter S O'Brien
 */
public class HelloController {
    // FXML fields for user input
    @FXML
    private TextField initialDepositText;

    @FXML
    private TextField annualInterestRateText;

    @FXML
    private TextField numberOfYearsText;

    // FXML field to display the calculated balance
    @FXML
    private Label balanceLabel;

    /**
     * Event handler for the calculate button click.
     * This method calculates the new balance based on the user input and updates the balance label.
     */
    @FXML
    protected void calculateButtonClick() {
        try {
            // Parse input values from text fields
            double initialDeposit = Double.parseDouble(initialDepositText.getText());
            double annualInterestRate = Double.parseDouble(annualInterestRateText.getText());
            int numberOfYears = Integer.parseInt(numberOfYearsText.getText());

            // Calculate total interest using simple interest formula: Interest = Principal * Rate * Time
            double totalInterest = initialDeposit * (annualInterestRate / 100.0) * numberOfYears;

            // Calculate end balance
            double endBalance = initialDeposit + totalInterest;

            // Format the end balance to two decimal places
            DecimalFormat df = new DecimalFormat("#.00");

            // Update the balance label with the formatted end balance
            balanceLabel.setText("Balance: $" + df.format(endBalance));

        } catch (NumberFormatException e) {
            // Handle invalid input by printing an error message to the console
            System.out.println("Please enter valid numbers.");
        }
    }
}
