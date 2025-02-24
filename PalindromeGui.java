import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PalindromeGui extends JFrame implements ActionListener, KeyListener{

    JLabel inputPrompt, statusPrompt, result;
    JTextField inputField;
    JButton check, clr;
    JPanel butpanel, panel;
    




    PalindromeGui(){

        super("Palindrome checker");

        inputPrompt = new JLabel("Input text ");
        inputField = new JTextField(20);
        inputField.addKeyListener(this);
        inputField.addActionListener(this);

        statusPrompt = new JLabel("Palindrome status");

        result = new JLabel("");

        check = new JButton("Check");
        check.addActionListener(this);
        

        clr = new JButton("CLR");
        clr.addActionListener(this);
        

        panel = new JPanel(new GridLayout(4, 1, 10, 10));

        panel.add(inputPrompt);
        panel.add(inputField);
        panel.add(statusPrompt);
        panel.add(result);

        butpanel = new JPanel(new FlowLayout());

        butpanel.add(check);
        butpanel.add(clr);

        add(panel, BorderLayout.NORTH);
        add(butpanel, BorderLayout.SOUTH);


        

        setSize(400, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }




    public static void main(String[] args) {
        new PalindromeGui();
    }


    @Override
    public void keyPressed(KeyEvent k){

        if(k.getKeyCode() == KeyEvent.VK_ENTER){
            palindromeCh();
        }

    }

    @Override
    public void keyReleased(KeyEvent k){

    }

    @Override
    public void keyTyped(KeyEvent k){

    }

    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == check){
            palindromeCh();
        }
        if(e.getSource() == clr){
            inputField.setText("");
            result.setText("");
        }

    

    }

    public void palindromeCh(){

        String str = inputField.getText();

        int i = 0, j = str.length() - 1, f=0;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                f=1;
                break;
            }
            i++;
            j--;
        }

        if(f == 1){
            result.setText(str + " is not palindrome");
        }else{
            result.setText(str + " is palindrome");
        }
    }
    
}
