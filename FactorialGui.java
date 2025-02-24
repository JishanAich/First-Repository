import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FactorialGui extends JFrame implements ActionListener{
        
    JLabel askInput, showOutput;
    JTextField input;
    JButton calButton, clrButton;
    JPanel panel, buttonPanel;

    FactorialGui(){
        super("Factorial Calculator");

        askInput = new JLabel("Enter the number here :");
        input = new JTextField(10);
        showOutput = new JLabel("");

        calButton = new JButton("Calculate");
        calButton.addActionListener(this);

        clrButton = new JButton("CLR");
        clrButton.addActionListener(this);

        panel = new JPanel(new GridLayout(3,2, 10,10));
        buttonPanel = new JPanel();

        panel.add(askInput);
        panel.add(input);
        panel.add(showOutput);

        buttonPanel.add(calButton);
        buttonPanel.add(clrButton);

        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);


        setSize(400, 350);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args){
    
        new FactorialGui();
    
    }
    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == calButton){
            
            int num = Integer.parseInt(input.getText());
            int fact =num;

            for(int i = num -1 ; i>0; i--){
                fact *= i;
            }


            showOutput.setText(String.valueOf(fact + " is the result"));
            
            
        }

        if(e.getSource() == clrButton){
            input.setText("");
            showOutput.setText("");
        }

    }
    
}
