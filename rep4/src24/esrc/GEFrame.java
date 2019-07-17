// GEFrame.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Frame for the graphic editor
public class GEFrame extends GPFrame {

  static final int width = 900;
  static final int height = 600;

  static  String[] strShEd = {"Line", "Rectangle", "Oval", "Edit"};
                                      // strings of menu for shapes and mode
  static  String[] strEdit = {"Deselect", "Delete", "Move", "Scale"};
                                      // strings of buttons for editing

  JButton[] bte = new JButton[strEdit.length];  // buttons for editing

  // Constructor
  // 1st argument: title, 2nd argument: reference to the graphic editor
  public GEFrame(String title, GraphicEditor ged) {
    super(title);                // call the constructor of the super class
    initGUI(width, height);      // initialize the GUI
    gra = getGraphics();         // get the Graphics object
    ge = ged;                    // set the reference to the tool
    System.out.println("calling method init() of the tool.");
    ge.init(gra);                // initialize the paint tool
    System.out.println("method init() of the tool executed.");

  }

  // Method to create Menus and Buttons
  void createMenus(Container cp) {
    createMenu4Shape(cp);
    createMenu4Color(cp);
    createMenu4Filled(cp);
    createButtons4Edit(cp);
    createButtons(cp);
  }

  // Menu for shapes and mode
  void createMenu4Shape(Container cp) {
    JPanel pn1 = new JPanel();                       // create a panel
    pn1.setLayout(new FlowLayout(FlowLayout.LEFT));  // set the layout

    JLabel lb1 = new JLabel(labelStr[0]);  // create label "Shape"
    lb1.setForeground(Color.black);        // set the string color to black
    pn1.add(lb1);                          // add the label to the panel

    cb1 = new JComboBox<String>();        // create a combo box
    cb1.setEditable(false);               // set the attribute editable false
    for (int i=0; i<strShEd.length; i++) {
                                          // repeat for the number of the items
      cb1.addItem(strShEd[i]);               // set the string of the item
    }
    cb1.addActionListener(this);  // add the action listener to the combo box
    pn1.add(cb1);                 // add the combo box to the panel
    cp.add(pn1);                  // add the panel to the container
  }

  // Buttons for editing
  void createButtons4Edit(Container cp) {
    JPanel pn6 = new JPanel();                       // create a panel
    pn6.setLayout(new FlowLayout(FlowLayout.LEFT));  // set the layout
    for (int i=0; i<strEdit.length; i++) {
                                       // repeat for the number of the buttons
      bte[i] = new JButton(strEdit[i]);   // create a button
      bte[i].addActionListener(this);  // add the action listener to the button
      pn6.add(bte[i]);                 // set the string of the item
    }
    cp.add(pn6);                       // add the panel to the container
  }

  // Method to be called when an action occurrs
  public void actionPerformed(ActionEvent evt) {

    super.actionPerformed(evt);

    if (evt.getSource() == bte[0]) {   // if button "Deselect" pressed
      System.out.println("button Deselect is pressed.");
      System.out.println("calling method deselect() of class GraphicEditor.");
      ((GEdit)ge).deselect(gra);
                           // call method deselect() of class GraphicEditor
      System.out.println("method deselect() of class GraphicEditor executed.");
    }

    if (evt.getSource() == bte[1]) {   // if button "Delete" pressed
      System.out.println("button Delete is pressed.");
      System.out.println("calling method delete() of class GraphicEditor.");
      ((GEdit)ge).delete(gra);  // call method delete() of class GraphicEditor
      System.out.println("method delete() of class GraphicEditor executed.");
    }

    if (evt.getSource() == bte[2]) {   // if button "Move" pressed
      System.out.println("button Move is pressed.");
      System.out.println("calling method move() of class GraphicEditor.");
      ((GEdit)ge).move(gra);   // call method move() of class GraphicEditor
      System.out.println("method move() of class GraphicEditor executed.");
    }

    if (evt.getSource() == bte[3]) {   // if button "Scale" pressed
      System.out.println("button Scale is pressed.");
      System.out.println("calling method scale() of class GraphicEditor.");
      ((GEdit)ge).scale(gra);  // call method scale() class GraphicEditor
      System.out.println("method scale() of class GraphicEditor executed.");
    }

    repaint();    // repaint
  }

  // Method to be called when menu for shapes and mode selected
  void shapeOperation() {
    String selStr; // variable to store the selected string

    repaint();  // repaint 
                  // becouse shapes may be collapsed by a pull-down menu
    selStr = (String)cb1.getSelectedItem();
                                    // store the string of the selected item
    if (selStr == strShEd[0]) {      // if "Line" selected 
      System.out.println("Line of menu Shape is selected.");
      System.out.println("calling method line() of class GraphicEditor.");
      ge.line(gra);       // call method line() of class GraphicEditor
      System.out.println("method line of class GraphicEditor executed.");
    } else if (selStr == strShEd[1]) {  // if "Rectangle" selected
      System.out.println("Rectangle of menu Shape is selected.");
      System.out.println("calling method rectangle() of class GraphicEditor.");
      ge.rectangle(gra);  // call method rectangle() of class GraphicEditor
      System.out.println("method rectangle() of class GraphicEditor executed.");
    } else if (selStr == strShEd[2]) {  // if "Oval" selected
      System.out.println("Oval of menu Shape is selected.");
      System.out.println("calling method oval() of class GraphicEditor.");
      ge.oval(gra);       // call method oval() of class GraphicEditor
      System.out.println("method oval() of class GraphicEditor executed.");
    } else if (selStr == strShEd[3]) {  // if "Edit" selected
      System.out.println("Edit of menu Shape is selected.");
      System.out.println("calling method edit() of class GraphicEditor");
      ((GEdit)ge).edit(gra);     // call method edit() of class GraphicEditor
      System.out.println("method edit() of class GraphicEditor executed.");
    }
  }

  // Method to be called when the mouse key released
  public void mouseReleased(MouseEvent evt) {
    super.mouseReleased(evt);
    repaint();                 // repaint
  }


  // main program
  public static void main(String[] args) {
    System.out.println("creating an instace of class GraphicEditor.");
    GraphicEditor ged = new GraphicEditor();
                               // create an instance of GraphicEditor
    System.out.println("an instace of class GraphicEditor created.");
    new GEFrame("Graphic Editor", ged);  // create an instance of GEFrame
  }

}
