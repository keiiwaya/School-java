// PaintPrototype.java

import java.awt.Graphics;  // import class Graphics
import java.awt.Color;     // import class Color

// Abstract class for tools
// This class is inheritted by class PaintTool
// The initial items of the muneus are shown below
// Item "Line" of menu "Spape" is setected
// Item "Black" of menu "SColor" is setected
// Item "No" of menu "Filled" is selected

public abstract class PaintPrototype {
  int shapeId = 0;                 // kind of Shape to draw
                                   // 0:Line, 1:Rectangle, 2:Oval
  Color color = Color.black;       // color
  boolean filled = false;          // filled or not
  int xPressed = 50;               // x coordinate when the mouse key pressed
  int yPressed = 50;               // y coordinate when the mouse key pressed
  int xReleased = 100;             // x coordinate when the mouse key released
  int yReleased = 100;             // y coordinate when the mouse key released
  int xDragged = 60;               // x coordinate when the mouse dragged
  int yDragged = 60;               // y coordinate when the mouse dragged
  Shape[] shape = new Shape[256];  // array to store the references to shapes
  int numOfShape = 0;              // the number of shapes

  // method to initialize
  // called after creating an instance
  // override this method in a subclass if needed
  public void init(Graphics gra) {
  }

  // Method to be called when item "Line" of menu "Shape" is selected
  // override this method in a subclass if needed
  public void line(Graphics gra) {
    shapeId = 0;
  }

  // Method to be called when item "Rectangle" of menu "Shape" is selected
  // override this method in a subclass if needed
  public void rectangle(Graphics gra) {
    shapeId = 1;
  }

  // Method to be called when item "Oval" of menu "Shape" is selected
  // override this method in a subclass if needed
  public void oval(Graphics gra) {
    shapeId = 2;
  }

  // Method to be called when item "Black" of menu "Color" is selected
  // override this method in a subclass if needed
  public void black(Graphics gra) {
    color = Color.black;
  }

  // Method to be called when item "Red" of menu "Color" is selected
  // override this method in a subclass if needed
  public void red(Graphics gra) {
    color = Color.red;
  }

  // Method to be called when item "Green" of menu "Color" is selected
  // override this method in a subclass if needed
  public void green(Graphics gra) {
    color = Color.green;
  }

  // Method to be called when item "Blue" of menu "Color" is selected
  // override this method in a subclass if needed
  public void blue(Graphics gra) {
    color = Color.blue;
  }

  // Method to be called when item "Yes" of menu "Filled" is selected
  // override this method in a subclass if needed
  public void filled(Graphics gra) {
    filled = true;
  }

  // Method to be called when item "No" of menu "Filled" is selected
  // override this method in a subclass if needed
  public void notFilled(Graphics gra) {
    filled = false;
  }

  // Method to be called when button "Clear" is pressed
  // The frame is cleared after executing this method
  // override this method in a subclass if needed
  public void clear(Graphics gra) {  // clear all the shape
    for (int i=0; i < numOfShape; i++) {
      shape[i] = null;
    }
    numOfShape = 0;
  }

  // Method to be called when button "Exit" is pressed
  // After executing this method, the frame is diposed and the program ends
  // override this method in a subclass if needed
  public void terminate(Graphics gra) {
  }

  // Method to be called when the mouse key is pressed
  // The x and y coordinates are passed as the arguments
  // override this method in a subclass if needed
  public void mousePressed(int xx, int yy, Graphics gra) {
    xPressed = xx;
    yPressed = yy;
  }

  // Method to be called when the mouse key is released
  // The x and y coordinates are passed as the arguments
  // override this method in a subclass if needed
  public void mouseReleased(int xx, int yy, Graphics gra) {
    xReleased = xx;
    yReleased = yy;
  }

  // Method to be called when the mouse is dragged
  // The x and y coordinates are passed as the 1st and 2nd arguments
  // The background color is passed as the last argument
  // override this method in a subclass if needed
  public void mouseDragged(int xx, int yy, Graphics gra, Color c) {
    xDragged = xx;
    yDragged = yy;
  }

  // Method to redraw all the shapes
  // (for example, this mehod is called when the freme is popupped)
  // override this method in a subclass if needed
  public void redrawAll(Graphics gra) {
    for (int i=0; i < numOfShape; i++) {
      shape[i].draw(gra);
    }
  }

}
