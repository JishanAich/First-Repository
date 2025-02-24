
import java.awt.Frame;

import java.awt.Button;

import java.awt.FlowLayout; 

import java.awt.TextField;

import java.awt.TextArea;

import java.awt.Label;

import java.awt.Panel;

import javax.swing.JComboBox;

class MyfirstGUI {

	Frame f;

	Button b1, b2;

	Panel P;

	Label l;

	JComboBox<String> CB;

	MyfirstGUI(){

		f = new Frame();

		f.setLayout(new FlowLayout());

		P = new Panel();

		b1 = new Button("ok");

		b2=  new Button("Cancel");

		f.add(new TextField("Bye world"));

		f.add(new Label("ram ram"));

		f.add(b1);

		f.add(b2);

		f.add(new TextArea("What!", 5, 48));

		P.add(new Label("Choose any"));

		String[] options = {"Option 1", "Option 2", "Option 3", "Option 4", "Option 5"};

		CB = new JComboBox<>(options);

		f.add(CB); 
		f.add(P);

		f.setSize(500, 500);

		f.setVisible(true);

	}

		

		

	

	public static void main(String[] args){

		new MyfirstGUI();
	}
}
