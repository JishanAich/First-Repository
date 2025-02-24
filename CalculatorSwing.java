import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorSwing extends JFrame implements ActionListener {

    private JTextField operand1, operator, operand2, result;
    private JButton calculateButton, exitButton, clearButton;
    private JLabel equal;

    CalculatorSwing() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Operand 1:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        operand1 = new JTextField(10);
        add(operand1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Operator:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        operator = new JTextField(5);
        add(operator, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Operand 2:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        operand2 = new JTextField(10);
        add(operand2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_END;
        equal = new JLabel("=");
        add(equal, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        result = new JTextField(10);
        result.setEditable(false);
        add(result, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_END;
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        add(calculateButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_START;
        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        add(clearButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_START;
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        add(exitButton, gbc);

        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            try {
                double val1 = Double.parseDouble(operand1.getText());
                double val2 = Double.parseDouble(operand2.getText());
                String operatorText = operator.getText();

                if (operatorText.equals("+")) {
                    double res = val1 + val2;
                    result.setText(String.valueOf(res));
                } else if (operatorText.equals("-")) {
                    double res = val1 - val2;
                    result.setText(String.valueOf(res));
                } else if (operatorText.equals("*")) {
                    double res = val1 * val2;
                    result.setText(String.valueOf(res));
                } else if (operatorText.equals("/")) {
                    if (val2 != 0) {
                        double res = val1 / val2;
                        result.setText(String.valueOf(res));
                    } else {
                        result.setText("Error: Division by zero!");
                    }
                } else {
                    result.setText("Error: Invalid operator!");
                }
            } catch (NumberFormatException ex) {
                result.setText("Error: Invalid input!");
            }
        } else if (e.getSource() == clearButton) {
            operand1.setText("");
            operator.setText("");
            operand2.setText("");
            result.setText("");
        } else {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new CalculatorSwing();
    }
}