// BilFrame.java

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Frame for Billiard
public class BilFrame extends JFrame implements ActionListener {
  String[] str = {"Draw", "Start", "Reset", "Exit"};  // strings for buttons
  JButton[] bt = new JButton[str.length];             // buttons for testing
  Graphics gra;  // object of Graphics
  BilIF bil;     // object of Billiards (Type id BilIF)

  // constructor
  // 1st argument: title, 2nd argument: width, 3rd argument: height
  // 4th argument: object of Billiard
  public BilFrame(String title, int width, int height,   BilIF b) {  
    super(title);                 // call the constructor of the super class
    setSize(width, height);       // set the frame size
    setBackground(Color.white);   // set the background color to white
    Container cp = getContentPane();    // set the container
    cp.setBackground(getBackground());  // set the background of the container
    cp.setLayout(new FlowLayout(FlowLayout.LEFT));  // set the layout
    for (int i=0; i<str.length; i++) {  // repeat for the number of the buttons
      bt[i] = new JButton(str[i]);    // create a button
      bt[i].addActionListener(this);  // add the action listener to the button
      cp.add(bt[i]);                  // add the button to the container
    }
    setVisible(true);       // set the attribute visible true
    gra = getGraphics();    // get the Graphics object
    bil = b;                // set the referense to the billiard
  }

  // Method to be called when an action occurrs
  public void actionPerformed(ActionEvent evt) {
    if (evt.getSource() == bt[0]) {  // if button "Draw" pressed
      System.out.println("calling method draw() of Billiard.");
      bil.draw(gra);                 // call method draw() of Billiard
      System.out.println("method draw() of Billiard executed.");
    }
    if (evt.getSource() == bt[1]) {  // if button "Start" pressed
      System.out.println("calling method start() of Billiard.\n");
      bil.start(gra);                // call method start() of Billiard
      System.out.println("\nmethod start() of Billiard executed.");
    }
    if (evt.getSource() == bt[2]) {  // if button "Reset" pressed
	repaint();                   // repaint
      System.out.println("calling method reset() of Billiard.");
      bil.reset();                   // call method reset() of Billiard
      System.out.println("method reset() of Billiard executed.");
    }
    if (evt.getSource() == bt[3]) {  // if button "Exit" pressed
      System.out.println("Program ends.");
      dispose();       // dispose the frame
      System.exit(0);  // exit
    }
  }

}
