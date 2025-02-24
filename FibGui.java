import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class FibGui extends JFrame implements ActionListener {

    JLabel prompt, resPrompt;
    JTextField inputField;
    JTextArea outputField;
    JButton calButton, clrButton;
    JPanel panel, buttonPanel;

    FibGui() {

        super("Fibonacci series generator");

        prompt = new JLabel("Enter the number of fibonacci series");

        inputField = new JTextField(10);

        resPrompt = new JLabel("Generated series");

        outputField = new JTextArea(20, 20);
        outputField.setEditable(false);

        calButton = new JButton("Generate");

        calButton.addActionListener(this);

        clrButton = new JButton("CLR");

        clrButton.addActionListener(this);

        panel = new JPanel(new GridLayout(6, 1, 10, 10));

        buttonPanel = new JPanel();

        panel.add(prompt);
        panel.add(inputField);
        panel.add(resPrompt);
        panel.add(outputField);

        buttonPanel.add(calButton);
        buttonPanel.add(clrButton);

        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == calButton) {

            int first = 0;
            int second = 1;
            int next = 1;
            int input = Integer.parseInt(inputField.getText());

            outputField.append(String.valueOf(first + ", " + second + ", "));

            for (int i = next; i < input; i++) {

                next = first + second;
                first = second;
                second = next;

                outputField.append(String.valueOf(next + ", "));

            }

        }
        if (e.getSource() == clrButton) {

            inputField.setText("");
            outputField.setText("");
        }

    }

    public static void main(String[] args) {
        new FibGui();
    }
}