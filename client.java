import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;





public class client extends JFrame implements ActionListener{
    
    
    JTextField tf_client;
    JTextArea ta_client;
    JButton send;

    
    BufferedReader br;
    PrintWriter pr;
    Socket s;

    client(){
        
        super("client");
        setLayout(new FlowLayout());

        tf_client = new JTextField("", 50);
        //tf_client.setBounds(10, 10, 300, 30);
        
        ta_client = new JTextArea("", 8, 50);
        //ta_client.setBounds(10, 30, 300, 200);
        ta_client.setEditable(false);

        send = new JButton("Send");
        send.addActionListener(this);

        add(tf_client);
        add(ta_client);
        add(send);

        

        setSize(300, 300);
        setVisible(true);

        try {

            
            s = new Socket("localhost", 9999);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            pr = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));

            while (true) {

                ta_client.append("Server -> " + br.readLine() + "\n");
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
}

    public static void main(String[] args){

        new client();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == send){

            ta_client.append("Client -> " + tf_client.getText()+"\n");
            pr.println(tf_client.getText());
            pr.flush();
            tf_client.setText("");
            tf_client.requestFocus();
        }
        
    }

    
}
