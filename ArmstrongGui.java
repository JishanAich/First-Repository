import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ArmstrongGui extends JFrame implements ActionListener, KeyListener{

    JTextField inputNum;
    JLabel inputPrompt, result;
    JButton check, clr;
    JPanel panel, butPanel;

    ArmstrongGui(){

        super("Armstrong number checker");
        

        inputPrompt = new JLabel("Enter the number here - ");
        

        inputNum = new JTextField(10);
        inputNum.addActionListener(this);
        inputNum.addKeyListener(this);

        result = new JLabel("");

        check = new JButton("Check");
        check.addActionListener(this);

        clr = new JButton("CLR");
        clr.addActionListener(this);

        panel =  new JPanel(new GridLayout(3,1,10,10));

        butPanel = new JPanel();

        butPanel.add(check);
        butPanel.add(clr);

        panel.add(inputPrompt);
        panel.add(inputNum);
        panel.add(result);

        add(panel, BorderLayout.NORTH);
        add(butPanel, BorderLayout.SOUTH);
        



        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        

    }


    

    @Override
    public void keyPressed(KeyEvent k){

        if(k.getKeyCode() == KeyEvent.VK_ENTER){

            armstrong();

        }

    }

    @Override
    public void keyTyped(KeyEvent k){

    }

    @Override
    public void keyReleased(KeyEvent k){

    }

    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == clr){
            inputNum.setText("");
            result.setText("");
        }

        if(e.getSource() == check){
            armstrong();
        }
    }
    public static void main(String[] args){
    
        new ArmstrongGui();
    
    }

    public void armstrong(){
        int num = Integer.parseInt(inputNum.getText());
        int digit = 0, sum = 0;
        int y = num;
        int temp= num;
        

        
        while(y != 0){
            y = y / 10;
            digit++;
        }

        while(temp != 0){
        
            int r = temp % 10;
            sum += Math.pow(r, digit);
            temp = temp / 10;

        }

        if(sum == num){
            result.setText(num + " is an Armstrong number.");
        }else{
            result.setText(num +" is not an Armstrong number.");
        }
    }


}
