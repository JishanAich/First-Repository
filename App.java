/*
 * This source file was generated by the Gradle 'init' task
 */

 import javax.swing.*;
 import java.awt.event.*;
 
 
 
 
 public class App extends JFrame implements ActionListener, KeyListener{
     
     JTextField textfield;
     JPanel panel;
     
     App(){
         
         
     }
     
     public String getGreeting() {
         return "Hello world";
     }
 
     public static void main(String[] args) {
         System.out.println(new App().getGreeting());
     }
     
     @Override
     public void keyPressed(KeyEvent k){}
     
     @Override
     public void keyReleased(KeyEvent k){}
     
     @Override
     public void keyTyped(KeyEvent k){}
     
     @Override
     public void actionPerformed(ActionEvent e){
     
     
     }
     
 }
 
