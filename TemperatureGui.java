import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureGui extends JFrame implements ActionListener {

    JButton calButton, clrButton;
    JTextField F, C;
    JLabel prompt, equal;

    TemperatureGui() {
        setTitle("Temperature Converter");
        setLayout(new FlowLayout());

        F = new JTextField(20);
        C = new JTextField(20);
        equal = new JLabel("=");
        prompt = new JLabel("Enter the Fahrenheit value ");

        calButton = new JButton("Convert");
        calButton.addActionListener(this);
        clrButton = new JButton("CLR");
        clrButton.addActionListener(this);
        

        add(prompt);
        add(F);
        add(equal);
        add(C);
        add(calButton);
        add(clrButton);

        setSize(350, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {

        new TemperatureGui();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == calButton) {
            double f = Double.parseDouble(F.getText());
            double res = (f - 32) * 5 / 9;

            C.setText(String.valueOf(res));

        }

        if (e.getSource() == clrButton) {

            F.setText("");
            C.setText("");
        }

    }

}