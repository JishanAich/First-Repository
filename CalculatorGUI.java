import java.awt.Frame;
import java.awt.Button;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextField;
import java.awt.Label;
import java.awt.FlowLayout;

public class CalculatorGUI extends Frame implements ActionListener, WindowListener {

    Button Calculate, clear, exit;
    TextField operand1, operator, operand2, result;
    Label equal;

    CalculatorGUI() {

        setLayout(new FlowLayout());
        

        operand1 = new TextField(10);
        operator = new TextField(2);
        operand2 = new TextField(10);
        equal = new Label("=");
        result = new TextField(10);

        Calculate = new Button("Calculate");
        Calculate.addActionListener(this);
        clear = new Button("Clear");
        clear.addActionListener(this);
        exit = new Button("Exit");
        exit.addActionListener(this);

        add(operand1);
        add(operator);
        add(operand2);
        add(equal);
        add(result);
        add(Calculate);
        add(clear);
        add(exit);

        addWindowListener(this);
        setSize(400, 500);
        setVisible(true);

    }

    public void windowOpened(WindowEvent e) {
    }

    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    public void windowClosed(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Calculate) {
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
                        result.setText("Error : Division by zero");
                    }

                }
            } catch (NumberFormatException ex) {
                result.setText("Invalid input");
            }

        } else if (e.getSource() == clear) {

            operand1.setText("");
            operator.setText("");
            operand2.setText("");
            result.setText("");
        }else{
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }
}
