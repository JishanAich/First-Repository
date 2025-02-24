import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class SiAndCi extends JFrame implements ActionListener {

    JTextField Principle, IRate, time;
    JButton siButton, ciButton, clrButton;
    JLabel P, R, T, result;
    JPanel panel, buttonPanel;

    SiAndCi() {
        super("Interest Calculator");
        setLayout(new BorderLayout());


        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));
        panel.setVisible(true);


        Principle = new JTextField(20);
        Principle.setBounds(250, 50, 70, 30);
        P = new JLabel("Enter principle amount here - ");
        P.setBounds(5, 50, 200, 30);

        IRate = new JTextField(20);
        IRate.setBounds(250, 100, 70, 30);
        R = new JLabel("Enter interest rate here - ");
        R.setBounds(5, 100, 200, 30);

        time = new JTextField(20);
        time.setBounds(250, 150, 70, 30);
        T = new JLabel("Enter time - ");
        T.setBounds(5, 150, 200, 30);

        result = new JLabel("");
        result.setBounds(150, 200, 400, 30);

       

        siButton = new JButton("SI");
        siButton.setBounds(100, 300, 100, 30);
        siButton.addActionListener(this);

        ciButton = new JButton("CI");
        ciButton.setBounds(250, 300, 100, 30);
        ciButton.addActionListener(this);

        clrButton = new JButton("CLR");
        clrButton.setBounds(400, 300, 100, 30);
        clrButton.addActionListener(this);

        panel.add(P);
        panel.add(Principle);
        panel.add(R);
        panel.add(IRate);
        panel.add(T);
        panel.add(time);
        panel.add(new JLabel(""));
        panel.add(result);

        add(panel, BorderLayout.CENTER);

        buttonPanel = new JPanel();
        buttonPanel.setVisible(true);
        buttonPanel.add(siButton);
        buttonPanel.add(ciButton);
        buttonPanel.add(clrButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setSize(600, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new SiAndCi();
    }

    public void actionPerformed(ActionEvent e) {

        double p, r, t, res;
        
        if (e.getSource() == clrButton) {
            Principle.setText("");
            IRate.setText("");
            time.setText("");
            result.setText("");
        }

        if (e.getSource() == siButton) {
            p = Double.parseDouble(Principle.getText());
            r = Double.parseDouble(IRate.getText());
            t = Double.parseDouble(time.getText());

            if (p != 0 && r != 0 && t != 0) {
                res = (p * r * t) / 100;
                result.setText(String.valueOf(res + " is the interest amount."));
            } else {
                result.setText("Invalid input");
            }
        }
        if (e.getSource() == ciButton) {

            p = Double.parseDouble(Principle.getText());
            r = Double.parseDouble(IRate.getText());
            t = Double.parseDouble(time.getText());

            if (p != 0 && r != 0 && t != 0) {
                double Amount = p * Math.pow((1 + r / 100), t);
                res = Amount - p;
                result.setText(String.valueOf(res + " is the compound interest amount."));
            } else {

                result.setText("Invalid input.");

            }

        }

    }

}
