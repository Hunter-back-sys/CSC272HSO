import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * <h2>CircleDrawingApplication.java - A simple application for drawing circles on a JPanel.</h2>
 * <p>This class provides a GUI where users can click to set the center of a circle, input the radius, and draw the circle on the panel.</p>
 *
 * <p><b>Problem statement:</b> Create a graphical user interface (GUI) application that allows users to draw circles on a panel by clicking to set the center and inputting the radius.</p>
 *
 * <div style="text-align: center;"><code><b>public class CircleDrawingApplication</b></code></div>
 *
 * @version Midterm
 * @author Hunter S O'Brien
 */
public class CircleDrawingApplication {
    /**
     * The main method to run the CircleDrawingApplication.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Circle Drawing Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Create the custom panel
        CirclePanel panel = new CirclePanel();

        // Add a mouse listener to the panel to handle click events
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse clicked at (" + e.getX() + ", " + e.getY() + ")");

                // Prompt the user to enter the radius of the circle
                String input = JOptionPane.showInputDialog(frame, "Enter the radius of the circle:");
                System.out.println("Input dialog shown");

                // If input is not null, try to parse the radius and draw the circle
                if (input != null) {
                    try {
                        int radius = Integer.parseInt(input);
                        System.out.println("Radius entered: " + radius);
                        panel.setCircle(e.getX(), e.getY(), radius);
                    } catch (NumberFormatException ex) {
                        // Show error message if the input is not a valid number
                        JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid number.");
                    }
                }
            }
        });

        // Add the panel to the frame
        frame.add(panel);
        frame.setVisible(true);
    }

    /**
     * CirclePanel.java - A custom JPanel for drawing a circle.
     */
    static class CirclePanel extends JPanel {
        private int x = -1; // X coordinate of the circle center
        private int y = -1; // Y coordinate of the circle center
        private int radius = -1; // Radius of the circle

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Draw the circle if a valid radius is set
            if (radius > 0) {
                g.drawOval(x - radius, y - radius, radius * 2, radius * 2);
            }
        }

        /**
         * Sets the circle parameters and repaints the panel.
         * @param x the x coordinate of the circle center
         * @param y the y coordinate of the circle center
         * @param radius the radius of the circle
         */
        public void setCircle(int x, int y, int radius) {
            this.x = x;
            this.y = y;
            this.radius = radius;
            repaint();
        }
    }
}
