import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class server extends JFrame implements ActionListener{
    
    
    JTextField tf_server;
    JTextArea ta_server;
    JButton send;

    
    BufferedReader br;
    PrintWriter pr;
    ServerSocket ss;
    Socket s;

    server(){
        
        super("Server");
        setLayout(new FlowLayout());

        tf_server = new JTextField("", 50);
        //tf_server.setBounds(10, 10, 300, 30);
        
        ta_server = new JTextArea("", 8, 50);
        //ta_server.setBounds(10, 30, 300, 200);
        ta_server.setEditable(false);

        send = new JButton("Send");
        
        send.addActionListener(this);

        add(tf_server);
        add(ta_server);
        add(send);

        

        setSize(300, 300);
        setVisible(true);

        try {

            ss = new ServerSocket(9999);
            s = ss.accept();
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            pr = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));

            while (true) {

                ta_server.append("Client -> " + br.readLine() + "\n");
               
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
}

    public static void main(String[] args){

        new server();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == send){

            ta_server.append("Server -> " + tf_server.getText()+"\n");
            pr.println(tf_server.getText());
            pr.flush();
            tf_server.setText("");
            tf_server.requestFocus();
            
        }
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    
}
