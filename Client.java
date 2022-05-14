package LCPChainOfResponsibilityDecorator;

// For GUI
import javax.swing.*;
import java.awt.event.*;

/**
 * @author melis
 * @version 1.0
 * @created 22-Mar-2022 9:52:47 PM
 */
public class Client {

	public static void main(String args[]) {
        // Setup Chain of Responsibility
        LengthConversionHandler mileHandler = new MileHandler();
        LengthConversionHandler yardHandler = new YardHandler();
        LengthConversionHandler footHandler = new FootHandler();

        mileHandler.setSuccessor(yardHandler);
        yardHandler.setSuccessor(footHandler);

        // Creating the Frame
        JFrame frame = new JFrame("Length Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // First row
        JTextField kmInput = new JTextField(); // Input field for km
        kmInput.setBounds(50, 50, 200, 20); // Location and size on frame
        JLabel kmLabel = new JLabel("Kilometer"); // Km label
        kmLabel.setBounds(275, 50, 75, 20);

        // Second row
        JTextField conversionOutput = new JTextField(); // Output field for conversion result
        conversionOutput.setEditable(false); // Can't edit output field, just view
        conversionOutput.setBounds(50, 100, 200, 20);
        String unit[] = {"Mile","Yard","Foot"}; // Dropdown options
        JComboBox<String> unitDropdown = new JComboBox<String>(unit); // Dropdown
        unitDropdown.setBounds(275, 100, 75, 20);

        // Third row
        JButton convertButton = new JButton("Convert"); // Convert button
        convertButton.setBounds(50, 200, 100, 25);
        convertButton.addActionListener(new ActionListener() { // Action for when Convert button clicked
            public void actionPerformed(ActionEvent e) {

                try {
                    double kmInputDecimal = Double.parseDouble(kmInput.getText()); // Convert inputted km string to double
                    String selectedUnit = unitDropdown.getItemAt(unitDropdown.getSelectedIndex()); // Get selected dropdown unit
                    // Decorate
					LengthConversionHandler mileHandlerDecorated = new Unit(new ExponentialNotation(new Round(mileHandler)));
                    String result = mileHandlerDecorated.handleConversion(kmInputDecimal, selectedUnit); // Handle conversion
                    conversionOutput.setText(result); // Set textview to decorated conversion result
                } catch (Exception exception) {
                    System.out.println("Error: Invalid value inputted for kilometer");
                }
            }
        });

        // Add elements to frame
        frame.getContentPane().add(kmInput);
        frame.getContentPane().add(kmLabel);
        frame.getContentPane().add(conversionOutput);
        frame.getContentPane().add(unitDropdown);
        frame.getContentPane().add(convertButton);
        frame.setLayout(null); // No layout manager
        frame.setVisible(true); 

    }
}//end Client