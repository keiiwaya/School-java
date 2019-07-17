// GPaint.java

import java.awt.Graphics;  // import class Graphics
import java.awt.Color;     // import class Color

// interface GPint
public interface GPaint {

  // method for initialization
  // called after creating an instance
  public boolean init(String fn, Graphics gra);

  // Method to be called when item "Line" of menu "Shape" is selected
  public void line(Graphics gra);

  // Method to be called when item "Rectangle" of menu "Shape" is selected
  public void rectangle(Graphics gra);

  // Method to be called when item "Oval" of menu "Shape" is selected
  public void oval(Graphics gra);

  // Method to be called when item "Black" of menu "Color" is selected
  public void black(Graphics gra);

  // Method to be called when item "Red" of menu "Color" is selected
  public void red(Graphics gra);

  // Method to be called when item "Green" of menu "Color" is selected
  public void green(Graphics gra);

  // Method to be called when item "Blue" of menu "Color" is selected
  public void blue(Graphics gra);

  // Method to be called when item "Yes" of menu "Filled" is selected
  public void filled(Graphics gra);

  // Method to be called when item "No" of menu "Filled" is selected
  public void notFilled(Graphics gra);

  // Method to be called when button "Clear" is pressed
  // The frame is cleared after executing this method
  public void clear(Graphics gra);

  // Method to be called when button "Exit" is pressed
  // After executing this method, the frame is diposed and the program ends
  public void terminate(Graphics gra);

  // Method to be called when the mouse key is pressed
  // The x and y coordinates are passed as the arguments
  public void mousePressed(int x, int y, Graphics gra);

  // Method to be called when the mouse key is released
  // The x and y coordinates are passed as the arguments
  public void mouseReleased(int xx, int yy, Graphics gra);

  // Method to be called when the mouse is dragged
  // The x and y coordinates are passed as the 1st and 2nd arguments
  // The background color is passed as the last argument
  public void mouseDragged(int xx, int yy, Graphics gra, Color c);

  // Method to redraw all the shapes
  // (for example, this mehod is called when the freme is popupped)
  public void redrawAll(Graphics gra);

}

