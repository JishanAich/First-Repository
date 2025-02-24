
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class SquareRoot extends JFrame implements ActionListener , KeyListener{

    JLabel inputPrompt, result;
    JTextField input;
    JButton calButton, clrButton;
    JPanel panel, buttonPanel;

    SquareRoot() {

        super("Square Root Calculator");

        inputPrompt = new JLabel("Enter the number here - ");

        input = new JTextField(10);
        input.setSize(100, 30);
        input.addKeyListener(this);

        result = new JLabel("");

        calButton = new JButton("Calculate");
        calButton.addActionListener(this);
        

        clrButton = new JButton("CLR");
        clrButton.addActionListener(this);

        panel = new JPanel(new GridLayout(3, 1, 10, 10));
        buttonPanel = new JPanel();

        panel.add(inputPrompt);
        panel.add(input);
        panel.add(result);

        buttonPanel.add(calButton);
        buttonPanel.add(clrButton);

        add(panel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        setSize(400, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new SquareRoot();
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {

        

        if (e.getSource() == calButton) {

            calculateSqRoot();
            

        }

        if (e.getSource() == clrButton) {
            input.setText("");
            result.setText("");
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
        

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() ==  KeyEvent.VK_ENTER){
            calculateSqRoot();
        }
    }
       

    @Override
    public void keyReleased(KeyEvent e) {

    }


    public void calculateSqRoot(){

        double num = Double.parseDouble(input.getText());
        double res = Math.sqrt(num);

        result.setText(String.valueOf(res + " is the square root of " + num));
        
    }

}
