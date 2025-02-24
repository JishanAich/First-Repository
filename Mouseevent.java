import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Mouseevent  implements MouseListener {

    JFrame f;
    JLabel l1;

    Mouseevent(){

        f = new JFrame();

        f.setLayout(null);

        l1 = new JLabel("");
        

        f.add(l1, BorderLayout.CENTER);


        f.addMouseListener(this);


        f.setSize(400, 400);
        f.setVisible(true);
        
    }


    public static void main(String[] args) {
        new Mouseevent();
    }

    public void mouseClicked(MouseEvent e) {

        l1.setText(e.getX() + " " + e.getY());

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

}
