import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalaculatorNumpad implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] operatorButtons = new JButton[9];
    JButton addButton, subButton, divButton, mulButton;
    JButton decButton, equalButton, clrButton, delButton, negButton;

    Font font = new Font("Monospace",Font.PLAIN, 30);
    double num1, num2, result;
    char operator;
    JPanel panel;

    CalaculatorNumpad() {

        frame = new JFrame("Calculator");
        frame.setSize(400, 550);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField = new JTextField();
        textField.setBounds(50, 40, 300, 50);

        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        divButton = new JButton("/");
        mulButton = new JButton("*");
        decButton = new JButton(".");
        delButton = new JButton("DEL");
        clrButton = new JButton("CLR");
        equalButton = new JButton("=");
        negButton = new JButton("(-)");

        operatorButtons[0] = addButton;
        operatorButtons[1] = subButton;
        operatorButtons[2] = divButton;
        operatorButtons[3] = mulButton;
        operatorButtons[4] = decButton;
        operatorButtons[5] = delButton;
        operatorButtons[6] = clrButton;
        operatorButtons[7] = equalButton;
        operatorButtons[8] = negButton;
        

        for (int i = 0; i < 9; i++) {

            operatorButtons[i].addActionListener(this);
            operatorButtons[i].setFont(font);
            operatorButtons[i].setFocusable(false);

        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFocusable(false);
            numberButtons[i].setFont(font);
            numberButtons[i].addActionListener(this);

        }

        delButton.setBounds(150, 435, 100, 50);
        clrButton.setBounds(250, 435, 100, 50);
        negButton.setBounds(50,435,100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        frame.add(panel);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equalButton);
        panel.add(divButton);

        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);

    }

    public static void main(String[] args) {

        new CalaculatorNumpad();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i =0; i <=9; i++){
            if(e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
            
        }
        

        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }

        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            
            textField.setText("");
        }
        if(e.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        
        if(e.getSource() == equalButton){
            num2 = Double.parseDouble(textField.getText());

            switch(operator){

                case '+' :
                    result = num1 + num2;
                    break;
                case '-' :
                    result = num1 - num2;
                    break;
                case '*' :
                    result = num1 * num2;
                    break;
                case '/' :
                    if(num2 != 0){
                        result = num1 / num2;
                    }else{
                        textField.setText("Can not divide by 0");
                    }
                    break;
            }

            textField.setText(String.valueOf(result));
            num1 = result;
        }


        if(e.getSource() == delButton){
            String str = textField.getText();
            if(str.length() > 0) {
                textField.setText(str.substring(0,str.length()-1));
            }
        }
    
        if(e.getSource() == negButton){
            double temp = Double.parseDouble(textField.getText());

            temp *= -1;

            textField.setText(String.valueOf(temp));

        }
        
        if(e.getSource() == clrButton){
            textField.setText("");
        }

    }
}
