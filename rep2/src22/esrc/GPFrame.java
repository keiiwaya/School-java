// GPFrame.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Frame (Window) for Paint Tool
public class GPFrame extends JFrame 
             implements ActionListener, MouseListener, MouseMotionListener{

  static final int width = 800;
  static final int height = 600;

  static  String[] labelStr = {"Shape", "Color", "Filled"};
                                              // strings of labels for munus
  static  String[] strShape = {"Line", "Rectangle", "Oval"};
                                              // strings of menu Shape
  static  String[] strColor = {"Black", "Red", "Green", "Blue"};
                                              // strings of menu Color
  static  String[] strFill = {"No", "Yes"};      // strings of menu Filled
  static  String[] strClEx = {"Clear", "Exit"};  // strings of buttons

  JComboBox<String> cb1, cb2, cb3;     // combo boxes for menus and buttons

  JButton[] bt = new JButton[strClEx.length];  // buttons for Delete and Exit

  Graphics gra;          // object of Graphics

  int xPressed = 50;     // x coordinate when mouse key pressed
  int yPressed = 50;     // y coordinate when mouse key pressed
  int xReleased = 100;   // x coordinate when mouse key released
  int yReleased = 100;   // y coordinate when mouse key released
  int xDragged = 60;     // x coordinate when mouse dragged
  int yDragged = 60;     // y coordinate when mouse dragged

  PaintPrototype ge;              // reference to the paint tool

  // Constructor, argument: title
  public GPFrame(String title) {
    super(title);                // call the constructor of the super class
  }

  // Constructor
  // 1st argument: title, 2nd argument: reference to the paint tool
  public GPFrame(String title, PaintTool gp) {
    super(title);                // call the constructor of the super class
    initGUI(width, height);      // initialize the GUI
    gra = getGraphics();         // get the Graphics object
    ge = gp;                     // set the reference to the tool
    System.out.println("calling method init() of the tool.");
    ge.init(gra);                // initialize the paint tool
    System.out.println("method init() of the tool executed.");
  }

  // Method to initialize GUI
  void initGUI(int width, int height) {
    setSize(width, height);      // set the frame size, width: 800, height: 600
    setBackground(Color.white);         // set the background color to white
    Container cp = getContentPane();    // set the container
    cp.setBackground(getBackground());  // set the background of the container
    cp.setLayout(new FlowLayout(FlowLayout.LEFT));  // set the layout

    createMenus(cp);

    addMouseListener(this);        // add a mouse listener
    addMouseMotionListener(this);  // add a mouse motion listener
    setVisible(true);              // set the attribute visible true
  }

  // Method to create Menus and Buttons
  void createMenus(Container cp) {
    createMenu4Shape(cp);
    createMenu4Color(cp);
    createMenu4Filled(cp);
    createButtons(cp);
  }

  // Menu for shapes
  void createMenu4Shape(Container cp) {
    JPanel pn1 = new JPanel();                       // create a panel
    pn1.setLayout(new FlowLayout(FlowLayout.LEFT));  // set the layout

    JLabel lb1 = new JLabel(labelStr[0]);  // create label "Shape"
    lb1.setForeground(Color.black);        // set the string color to black
    pn1.add(lb1);                          // add the label to the panel

    cb1 = new JComboBox<String>();        // create a combo box
    cb1.setEditable(false);               // set the attribute editable false
    for (int i=0; i<strShape.length; i++) {
                                          // repeat for the number of the items
      cb1.addItem(strShape[i]);           // set the string of the item
    }
    cb1.addActionListener(this);  // add the action listener to the combo box
    pn1.add(cb1);                 // add the combo box to the panel
    cp.add(pn1);                  // add the panel to the container
  }

  // Menu for colors
  void createMenu4Color(Container cp) {
    JPanel pn2 = new JPanel();                       // create a panel
    pn2.setLayout(new FlowLayout(FlowLayout.LEFT));  // set the layout

    JLabel lb2 = new JLabel(labelStr[1]);  // create label "Color"
    lb2.setForeground(Color.black);        // set the string color to black
    pn2.add(lb2);                          // add the label to the panel

    cb2 = new JComboBox<String>();        // create a combo box
    cb2.setEditable(false);               // set the attribute editable false
    for (int i=0; i<strColor.length; i++) {
                                          // repeat for the number of the items
      cb2.addItem(strColor[i]);           // set the string of the item
    }

    cb2.addActionListener(this);  // add the action listener to the combo box
    pn2.add(cb2);                 // add the combo box to the panel
    cp.add(pn2);                  // add the panel to the container
  }

  // Menu for filled or not
 void createMenu4Filled(Container cp) {
    JPanel pn3 = new JPanel();                       // create a panel
    pn3.setLayout(new FlowLayout(FlowLayout.LEFT));  // set the layout

    JLabel lb3 = new JLabel(labelStr[2]);  // create label "Filled"
    lb3.setForeground(Color.black);        // set the string color to black
    pn3.add(lb3);                          // add the label to the panel

    cb3 = new JComboBox<String>();        // create a combo box
    cb3.setEditable(false);               // set the attribute editable false
    for (int i=0; i<strFill.length; i++) {
                                          // repeat for the number of the items
      cb3.addItem(strFill[i]);            // set the string of the item
    }

    cb3.addActionListener(this);  // add the action listener to the combo box
    pn3.add(cb3);                 // add the combo box to the panel
    cp.add(pn3);                  // add the panel to the container
  }

  // Buttons for Clear and Exit
  void createButtons(Container cp) {
    JPanel pn4 = new JPanel();                       // create a panel
    pn4.setLayout(new FlowLayout(FlowLayout.LEFT));  // set the layout
    for (int i=0; i<strClEx.length; i++) {
                                       // repeat for the number of the buttons
      bt[i] = new JButton(strClEx[i]); // create a button
      bt[i].addActionListener(this);   // add the action listener to the button
      pn4.add(bt[i]);                  // add the button to the panel
    }
    cp.add(pn4);                       // add the panel to the container
  }

  // Method to be called when an action occurred
  public void actionPerformed(ActionEvent evt) {

    if (evt.getSource() == cb1) {   // if an item of menu Shape selected
      shapeOperation();
    }

    if (evt.getSource() == cb2) {   // if an item of menu Color selected
      colorOperation();
    }

    if (evt.getSource() == cb3) {   // if an item of menu Filled selected
      filledOperation();
    }

    if (evt.getSource() == bt[0]) {   // if button "Clear" pressed
      System.out.println("button Clear is pressed.");
      System.out.println("calling method clear().");
      ge.clear(gra);  // call method clear() of the Tool
      System.out.println("method clear() executed.");
      repaint();      // repaint
    }

    if (evt.getSource() == bt[1]) {   //  if button "Exit" pressed
      System.out.println("button Exit is pressed.");
      System.out.println("calling method terminate().");
      ge.terminate(gra);
                  // call method terminate() of the Tool
      System.out.println("method terminate() executed.");
      dispose();       // dispose the frame
      System.exit(0);  // exit
    }

  }

  // Method to be called when menu Shape selected
  void shapeOperation() {
    String selStr;  // variable to store the selected string

    repaint();                    // repaint
    selStr = (String)cb1.getSelectedItem();
                                  // store the string of the selected item
    if (selStr == strShape[0]) {      // if "Line" selected 
      System.out.println("Line of menu Shape is selected.");
      System.out.println("calling method line().");
      ge.line(gra);               // call method line() of class PaintTool
      System.out.println("method line of class PaintTool executed.");
    } else if (selStr == strShape[1]) {  // if "Rectangle" selected
      System.out.println("Rectangle of menu Shape is selected.");
      System.out.println("calling method rectangle().");
      ge.rectangle(gra);        // call method rectangle() of class PaintTool
      System.out.println("method rectangle() executed.");
    } else if (selStr == strShape[2]) {  // if "Oval" selected
      System.out.println("Oval of menu Shape is selected.");
      System.out.println("calling method oval().");
      ge.oval(gra);                  // call method oval() of class PaintTool
      System.out.println("method oval() executed.");
    }

  }

  // Method to be called when menu Color selected
  void colorOperation() {
    String selStr;  // variable to store the selected string

    repaint();                    // repaint
    selStr = (String)cb2.getSelectedItem();
                                  // store the string of the selected item
    if (selStr == strColor[0]) {      // if "Black" selected
      System.out.println("Black of menu Color is selected.");
      System.out.println("calling method black().");
      ge.black(gra);              // call method black() of class PaintTool
      System.out.println("method black() executed.");
    } else if (selStr == strColor[1]) {  // if "Red" selected
      System.out.println("Red of menu Color is selected.");
      System.out.println("calling method red().");
      ge.red(gra);                   // call method red() of class PaintToll
      System.out.println("method red() executed.");
    } else if (selStr == strColor[2]) {  // if "Green" selected
      System.out.println("Green of menu Color is selected.");
      System.out.println("calling method green().");
      ge.green(gra);               // call method green() of class PaintTool
      System.out.println("method green() executed.");
    } else if (selStr == strColor[3]) {  // if "Blue" selected
      System.out.println("Blue of menu Color is selected.");
      System.out.println("calling method blue().");
      ge.blue(gra);                // call method blue() of class PaintToll
      System.out.println("method blue() executed.");
    }
  }

  // Method to be called when menu Filled selected
  void filledOperation() {
    String selStr;  // variable to store the selected string

    repaint();                    // repaint
    selStr = (String)cb3.getSelectedItem();
                                  // store the string of the selected item
    if (selStr == strFill[0]) {  // if "No" selected
      System.out.println("No of menu Filled is selected.");
      System.out.println("calling method notFilled().");
      ge.notFilled(gra);       // call method notFilled() of class PaintTool
      System.out.println("method notFilled() executed.");
    } else if (selStr == strFill[1]) {  // if "Yes" seleted
      System.out.println("Yes of menu Filled is selected.");
      System.out.println("calling method filled().");
      ge.filled(gra);             // call method filled() of class PaintTool
      System.out.println("method filled() executed.");
    }
  }

  // Method to be called when the mouse key pressed
  public void mousePressed(MouseEvent evt) {
    xPressed = evt.getX();  // store the x coordinate of the mouse
    yPressed = evt.getY();  // store the y coordinate of the mouse
    System.out.println("Mouse key pressed at coordinate ("
                        + xPressed + ", " + yPressed + ").");
    System.out.println("calling method mousePressed() of class PaintTool.");
    ge.mousePressed(xPressed, yPressed, gra);
                            // call method mousePressed() of class PaintTool
    System.out.println("method mousePressed() of class PaintTool executed.");
  }

  // Method to be called when the mouse key released
  public void mouseReleased(MouseEvent evt) {
    xReleased = evt.getX();  // store the x coordinate of the mouse
    yReleased = evt.getY();  // store the y coordinate of the mouse
    System.out.println("Mouse key released at coordinate ("
                        + xReleased + ", " + yReleased + ").");
    System.out.println("calling method mouseReleased()of class PaintTool.");
    ge.mouseReleased(xReleased, yReleased, gra);
                             // call method mouseReleased() of class paintTool
    System.out.println("method mouseReleased() of class PaintTool executed.");
  }

  // Method to be called when the mouse key clicked
  public void mouseClicked(MouseEvent evt) {
  }

  // Method to be called when the mouse enters to the frame
  public void mouseEntered(MouseEvent evt) {
  }

  // Method to be called when the mouse exits from the frame
  public void mouseExited(MouseEvent evt) {
  }

  // Method to be called when the mouse dragged
  public void mouseDragged(MouseEvent evt) {
    xDragged = evt.getX();  // store the x coordinate of the mouse
    yDragged = evt.getY();  // store the y coordinate of the mouse
    System.out.println("Mouse dragged at coordinate ("
                        + xDragged + ", " + yDragged + ").");
    System.out.println("calling method mouseDragged() of PaintTool.");
    ge.mouseDragged(xDragged, yDragged, gra, getBackground());
                            // call method mouseDragged() of class PaintTool
    System.out.println("method mouseDragged() of class PaintTool executed.");
  }

  // Method to be called when the mouse moved
  public void mouseMoved(MouseEvent evt) {
  }

  // Method to redraw the frame
  public void paint(Graphics g) {
    super.paint(g);             // call method paint() of super class (JFrame)
    if (ge != null) {           // if the paint tool exists
      System.out.println("calling method redrawAll() of PaintTool.");
      ge.redrawAll(g);          // call method redrawAll() of class PaintTool
      System.out.println("method redrawAll() of class PaintTool executed.");
    }
  }

  // main program
  public static void main(String[] args) {
    System.out.println("creating an instace of class PaintTool.");
    PaintTool gp = new PaintTool();  // create an instance of PaintTool
    System.out.println("an instace of class PaintTool created.");
    new GPFrame("Paint Tool", gp);   // create an instance of GPFrame
  }

}
