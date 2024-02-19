import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ScientificCalculator extends JFrame implements ActionListener {
    private JTextField textField;
    private double num1, num2, result;
    private char operator;
    private double memory = 0; // Memory variable

    public ScientificCalculator() {
        setTitle("Scientific Calculator");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Text Field
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 20));
        textField.setBounds(0, 0, 786, 60);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        add(textField, BorderLayout.NORTH);

        // Buttons Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(0, 61, 786, 400);
        buttonPanel.setLayout(new GridLayout(5, 10));

        String[] buttonLabels = {
                "(", ")", "mc", "m+","m-", "mr", " ", "+/-","%", "/",
                "2nd", "X^2", "X^3", "X^Y","e^x", "10^x", "7", "8","9", "*",
                "1/x", "sqrtx", "cbrtx", "yrtx","ln", "log10","4", "5","6", "-",
                "x!", "sin", "cos", "tan","e", "EE","1", "2","3", "+",
                "Rad", "sinh", "cosh", "tanh","pi", "Rand","0", "C",".", "="
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        // Handle the actions based on the button labels
        switch (actionCommand) {
            case "C":
                textField.setText(""); // Clear the text field
                break;
            case "=":
                num2 = Double.parseDouble(textField.getText());
                calculate();
                break;
            // Handle other buttons as needed
            // Add additional cases for other functionalities
            case "mc":
                memory = 0; // Clear memory
                break;
            case "m+":
                memory += Double.parseDouble(textField.getText()); // Add to memory
                break;
            case "m-":
                memory -= Double.parseDouble(textField.getText()); // Subtract from memory
                break;
            case "mr":
                textField.setText(String.valueOf(memory)); // Recall memory value
                break;
            // Handle unary operations
            case "+/-":
                num1 = Double.parseDouble(textField.getText());
                num1 = -num1; // Change sign
                textField.setText(String.valueOf(num1));
                break;
            case "%":
                num1 = Double.parseDouble(textField.getText());
                num1 = num1 / 100; // Calculate percentage
                textField.setText(String.valueOf(num1));
                break;
            // Handle binary operations
            case "+":
            case "-":
            case "*":
            case "/":
                num1 = Double.parseDouble(textField.getText());
                operator = actionCommand.charAt(0);
                textField.setText("");
                break;
            // Handle other unary mathematical functions
            case "X^2":
                num1 = Double.parseDouble(textField.getText());
                result = num1 * num1; // Square
                textField.setText(String.valueOf(result));
                break;
            case "X^3":
                num1 = Double.parseDouble(textField.getText());
                result = num1 * num1 * num1; // Cube
                textField.setText(String.valueOf(result));
                break;
            // Add more cases for other functionalities
            default:
                // Append the button label to the text field
                textField.setText(textField.getText() + actionCommand);
                break;
        }
    }

    private void calculate() {
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
        }
        textField.setText(String.valueOf(result));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ScientificCalculator calc = new ScientificCalculator();
            calc.setVisible(true);
        });
    }
}
