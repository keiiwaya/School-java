// ShapeFrame.java

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Frame (Window)
public class ShapeFrame extends JFrame implements ActionListener {
  String[] str = {"Start", "Exit"};
  JButton[] bt = new JButton[str.length];
  Graphics gra;
  ShapeDrawTest sdt;

  // constructor
  public ShapeFrame(String title, ShapeDrawTest s) {
    super(title);
    setSize(800, 600);
    setBackground(Color.white);
    Container cp = getContentPane();
    cp.setBackground(getBackground());
    cp.setLayout(new FlowLayout(FlowLayout.LEFT));
    for (int i=0; i<str.length; i++) {
      bt[i] = new JButton(str[i]);
      bt[i].addActionListener(this);
      cp.add(bt[i]);
    }
    setVisible(true);
    gra = getGraphics();
    sdt = s;
  }

  // behavior when an action performed
  public void actionPerformed(ActionEvent evt) {
    if (evt.getSource() == bt[0]) {
      System.out.println("calling start() of ShapeDrawTest.");
      sdt.start(gra);
      System.out.println("start() of ShapeDrawTest called.");
    }
    if (evt.getSource() == bt[1]) {
      System.out.println("exit the program.");
      dispose();
      System.exit(0);
    }
  }

  // main program
  public static void main(String[] args) {
    System.out.println("creating an instance of ShapeDrawTest.");
    ShapeDrawTest s = new ShapeDrawTest();
    System.out.println("an instance of ShapeDrawTest created.");
    new ShapeFrame("ShapeDrawTest", s);
  }

}
