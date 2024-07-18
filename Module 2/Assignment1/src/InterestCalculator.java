import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * <h2>InterestCalculator.java - A GUI application to calculate the new balance after applying interest over a number of years.</h2>
 * <p>This class provides a graphical interface to input initial deposit, annual interest rate, and number of years, and calculates the new balance.</p>
 *
 * <p><b>Problem statement:</b> Create a graphical user interface (GUI) application to calculate the new balance after applying interest over a specified number of years based on the initial deposit and annual interest rate.</p>
 *
 * <div style="text-align: center;"><code><b>public class InterestCalculator extends JFrame</b></code></div>
 *
 * @version Assignment 1 Module 2
 * @author Hunter S O'Brien
 */
public class InterestCalculator extends JFrame {
    // Text fields for user input
    private JTextField initialDepositField;
    private JTextField annualInterestRateField;
    private JTextField numberOfYearsField;
    // Label to display the calculated balance
    private JLabel balanceLabel;
    // Constants for frame dimensions
    private final int FRAME_HEIGHT = 200;
    private final int FRAME_WIDTH = 500;

    /**
     * Constructor to initialize the InterestCalculator GUI.
     */
    public InterestCalculator() {
        // Set up the GUI components
        createView();

        // Set the title of the window
        setTitle("Interest Calculator");
        // Ensure the application exits when the window is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Set the size of the window
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        // Center the window on the screen
        setLocationRelativeTo(null);
        // Prevent the window from being resized
        setResizable(false);
    }

    /**
     * Creates the view components and layout for the GUI.
     */
    private void createView() {
        // Create a panel to hold all components
        JPanel panel = new JPanel();
        // Add the panel to the frame
        getContentPane().add(panel);

        // Use GridBagLayout for flexible layout management
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add initial deposit label and text field
        JLabel initialDepositLabel = new JLabel("Initial Deposit:");
        panel.add(initialDepositLabel, gbc);

        initialDepositField = new JTextField(20);
        panel.add(initialDepositField, gbc);

        // Add annual interest rate label and text field
        gbc.gridy = 1;
        JLabel annualInterestRateLabel = new JLabel("Annual Interest Rate:");
        panel.add(annualInterestRateLabel, gbc);

        annualInterestRateField = new JTextField(20);
        panel.add(annualInterestRateField, gbc);

        // Add number of years label and text field
        gbc.gridy = 2;
        JLabel numberOfYearsLabel = new JLabel("Number of Years:");
        panel.add(numberOfYearsLabel, gbc);

        numberOfYearsField = new JTextField(20);
        panel.add(numberOfYearsField, gbc);

        // Add calculate button
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton calculateButton = new JButton("Calculate New Balance");
        panel.add(calculateButton, gbc);
        // Add action listener to the calculate button
        calculateButton.addActionListener(new CalculateButtonActionListener());

        // Add balance label to display the result
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        balanceLabel = new JLabel("Balance: 0.00");
        panel.add(balanceLabel, gbc);
    }

    /**
     * Action listener class for the calculate button.
     */
    private class CalculateButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Get input values from text fields
                double initialDeposit = Double.parseDouble(initialDepositField.getText());
                double annualInterestRate = Double.parseDouble(annualInterestRateField.getText());
                int numberOfYears = Integer.parseInt(numberOfYearsField.getText());

                // Calculate the new balance
                double balance = calculateNewBalance(initialDeposit, annualInterestRate, numberOfYears);

                // Format and update balanceLabel with the new balance
                DecimalFormat df = new DecimalFormat("#.00");
                balanceLabel.setText("Balance: " + df.format(balance));
            } catch (NumberFormatException ex) {
                // Show error message if input is invalid
                JOptionPane.showMessageDialog(InterestCalculator.this, "Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        /**
         * Calculates the new balance based on the initial deposit, annual interest rate, and number of years.
         * @param initialDeposit the initial amount of money deposited
         * @param annualInterestRate the annual interest rate in percentage
         * @param numberOfYears the number of years the money is invested
         * @return the new balance after interest is applied
         */
        private double calculateNewBalance(double initialDeposit, double annualInterestRate, int numberOfYears) {
            // Calculate total interest using simple interest formula: Interest = Principal * Rate * Time
            double totalInterest = initialDeposit * (annualInterestRate / 100.0) * numberOfYears;

            // Calculate end balance
            double endBalance = initialDeposit + totalInterest;

            return endBalance;
        }
    }
}
