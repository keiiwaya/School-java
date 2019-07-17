// GTFrame.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Frame for editting shapes
public class GTFrame extends GPFrame {

  static final int width = 900;
  static final int height = 600;

  static  String[] strTest = {"Move", "MoveTo", "ScaleX", "ScaleY", "ScaleTo", "HL", "SelHL", "ResetHL"};
                                      // strings of buttons for testing
  JButton[] btt = new JButton[strTest.length];  // buttons for testing

  // constructor
  // 1st argument: title, 2nd argument: reference to the test program
  public GTFrame(String title, EditTest etest) { 
    super(title);                // call the constructor of the super class
    initGUI(width, height);      // initialize the GUI
    gra = getGraphics();         // get the Graphics object
    ge = etest;                  // set the reference to the tool
    ge.init(gra);                // initialize the test program
  }

  // Method to create Menus and Buttons
  void createMenus(Container cp) {
    createMenu4Shape(cp);
    createMenu4Color(cp);
    createMenu4Filled(cp);
    createButtons4Test(cp);
    createButtons(cp);
  }

  // Buttons for testing
  void createButtons4Test(Container cp) {
    JPanel pn5 = new JPanel();                       // create a panel
    pn5.setLayout(new FlowLayout(FlowLayout.LEFT));  // set the layout
    for (int i=0; i<strTest.length; i++) { // repeat for the number of the buttons
      btt[i] = new JButton(strTest[i]);   // create a button
      btt[i].addActionListener(this);  // add the action listener to the button
      pn5.add(btt[i]);                 // set the string of the item
    }
    cp.add(pn5);                       // add the panel to the container
  }

  // Method to be called when an action occurrs
  public void actionPerformed(ActionEvent evt) {

    super.actionPerformed(evt);

    if (evt.getSource() == btt[0]) {  // if button "Move" pressed
      System.out.println("button Move is pressed.");
      System.out.println("calling method moveAll() of class EditTest.");
      ((EditTest)ge).move(gra);       // call method move() of class EditTest
      System.out.println("method moveAll() of class EditTest executed.");
      repaint();                      // repaint
    }

    if (evt.getSource() == btt[1]) {  // if button "MoveTo" pressed
      System.out.println("button MoveTo is pressed,");
      System.out.println("calling method moveTo() of class EditTest.");
      ((EditTest)ge).moveTo(gra);     // call method moveTo() of class EditTest
      System.out.println("method moveTo() of class EditTest executed.");
      repaint();                      // repaint
    }

    if (evt.getSource() == btt[2]) {  // if button "ScaleX" pressed
      System.out.println("button ScaleX is pressed.");
      System.out.println("calling method scaleX() of class EditTest.");
      ((EditTest)ge).scaleX(gra);     // call method scaleX() of class EditTest
      System.out.println("method scaleX() of class EditTest executed.");
      repaint();                      // repaint
    }

    if (evt.getSource() == btt[3]) {  // if button "ScaleY" pressed
      System.out.println("button ScaleY is pressed.");
      System.out.println("calling method scaleY() of class EditTest.");
      ((EditTest)ge).scaleY(gra);     // call method scaleX() of class EditTest
      System.out.println("EditTestのメソッド scaleY() の処理を終了しました。");
      repaint();                      // repaint
    }

    if (evt.getSource() == btt[4]) {  // if button "ScaleTo" pressed
      System.out.println("button ScaleTo is pressed.");
      System.out.println("calling method scaleTo() of class EditTest.");
      ((EditTest)ge).scaleTo(gra);   // call method scaleTo() of class EditTest
      System.out.println("method scaleTo() of class EditTest executed.");
      repaint();                    // repaint
    }

    if (evt.getSource() == btt[5]) {  // if button "HL" pressed
      System.out.println("button HL is pressed.");
      System.out.println("calling method highlight() of class EditTest.");
      ((EditTest)ge).highlight();  // call method highlight() of class EditTest
      System.out.println("method highlight() of class EditTest executrd.");
      repaint();                   // repaint
    }

    if (evt.getSource() == btt[6]) {  // if button "SelHL" pressed
      System.out.println("button SelHL is pressed.");
      System.out.println("calling method selectHighlight() of class EditTest.");
      ((EditTest)ge).selectHighlight();
                            // call method selectHighlight() of class EditTest
      System.out.println("method selectHighlight() of class EditTest executed.");
    }

    if (evt.getSource() == btt[7]) {  // if button "ResetHL" pressed
      System.out.println("button ResetHL is pressed");
      System.out.println("calling method resetHighlight() of class EditTest.");
      ((EditTest)ge).resetHighlight();
                              // call method resetHighlight() of class EditTest
      System.out.println("method resetHighlight() of class EditTest executed.");
      repaint();            // repaint
    }

  }

  // Method to be called when the mouse key released
  public void mouseReleased(MouseEvent evt) {
    super.mouseReleased(evt);
    repaint();                 // repaint
  }

  // main program
  public static void main(String[] args) {
    System.out.println("creating an instace of class EditTest.");
    EditTest et = new EditTest();     // create an instance of EditTest
    System.out.println("an instace of class EditTest created.");
    new GTFrame("Edit Tseting", et);  // create an instance of GTFrame
  }

}
