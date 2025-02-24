import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComplexNumberCalculator extends JFrame {

    private JTextField real1, imaginary1, real2, imaginary2, result;
    private JComboBox<String> operation;
    private String[] operations = {"Addition", "Subtraction", "Multiplication", "Division"};

    public ComplexNumberCalculator() {
        setLayout(new BorderLayout());

        // Create input fields
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 4));
        inputPanel.add(new JLabel("Real 1"));
        real1 = new JTextField();
        inputPanel.add(real1);
        inputPanel.add(new JLabel("Imaginary 1"));
        imaginary1 = new JTextField();
        inputPanel.add(imaginary1);
        inputPanel.add(new JLabel("Real 2"));
        real2 = new JTextField();
        inputPanel.add(real2);
        inputPanel.add(new JLabel("Imaginary 2"));
        imaginary2 = new JTextField();
        inputPanel.add(imaginary2);

        // Create operation combo box
        JPanel operationPanel = new JPanel();
        operationPanel.add(new JLabel("Operation"));
        operation = new JComboBox<>(operations);
        operationPanel.add(operation);

        // Create calculate button and result field
        JPanel resultPanel = new JPanel();
        JButton calculate = new JButton("Calculate");
        calculate.addActionListener(new CalculateListener());
        resultPanel.add(calculate);
        result = new JTextField();
        result.setEditable(false);
        resultPanel.add(result);

        // Add panels to frame
        add(inputPanel, BorderLayout.NORTH);
        add(operationPanel, BorderLayout.CENTER);
        add(resultPanel, BorderLayout.SOUTH);

        // Set up frame
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class CalculateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double real1Value = Double.parseDouble(real1.getText());
                double imaginary1Value = Double.parseDouble(imaginary1.getText());
                double real2Value = Double.parseDouble(real2.getText());
                double imaginary2Value = Double.parseDouble(imaginary2.getText());

                ComplexNumber num1 = new ComplexNumber(real1Value, imaginary1Value);
                ComplexNumber num2 = new ComplexNumber(real2Value, imaginary2Value);

                ComplexNumber resultNum = null;
                switch ((String) operation.getSelectedItem()) {
                    case "Addition":
                        resultNum = num1.add(num2);
                        break;
                    case "Subtraction":
                        resultNum = num1.subtract(num2);
                        break;
                    case "Multiplication":
                        resultNum = num1.multiply(num2);
                        break;
                    case "Division":
                        resultNum = num1.divide(num2);
                        break;
                }

                result.setText(resultNum.toString());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input");
            }
        }
    }

    private static class ComplexNumber {
        private double real;
        private double imaginary;

        public ComplexNumber(double real, double imaginary) {
            this.real = real;
            this.imaginary = imaginary;
        }

        public ComplexNumber add(ComplexNumber other) {
            return new ComplexNumber(real + other.real, imaginary + other.imaginary);
        }

        public ComplexNumber subtract(ComplexNumber other) {
            return new ComplexNumber(real - other.real, imaginary - other.imaginary);
        }

        public ComplexNumber multiply(ComplexNumber other) {
            return new ComplexNumber(real * other.real - imaginary * other.imaginary,
                    real * other.imaginary + imaginary * other.real);
        }

        public ComplexNumber divide(ComplexNumber other) {
            double denominator = other.real * other.real + other.imaginary * other.imaginary;
            return new ComplexNumber((real * other.real + imaginary * other.imaginary) / denominator,
                    (imaginary * other.real - real * other.imaginary) / denominator);
        }

        @Override
        public String toString() {
            return real + " + " + imaginary + "i";
        }
    }

    public static void main(String[] args) {
        new ComplexNumberCalculator();
    }
}