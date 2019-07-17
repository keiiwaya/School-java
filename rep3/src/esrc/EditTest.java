// EditTest.java

import java.awt.Graphics;  // import class Graphics
import java.awt.Color;     // import class Color

public class EditTest extends PaintTool {

  boolean selHL = false;  // picking and highlighting are allowed or not

  public void line(Graphics gra) {
    selHL = false;    // inhibit picking and hilighting
    super.line(gra);  // delegated to the super class
  }

  public void rectangle(Graphics gra) {
    selHL = false;         // inhibit picking and hilighting
    super.rectangle(gra);  // delegated to the super class
  }

  public void oval(Graphics gra) {
    selHL = false;    // inhibit picking and hilighting
    super.oval(gra);  // delegated to the super class
  }

  public void black(Graphics gra) {
    selHL = false;     // inhibit picking and hilighting
    super.black(gra);  // delegated to the super class
  }

  public void red(Graphics gra) {
    selHL = false;   // inhibit picking and hilighting
    super.red(gra);  // delegated to the super class
  }

  public void green(Graphics gra) {
    selHL = false;     // inhibit picking and hilighting
    super.green(gra);  // delegated to the super class
  }

  public void blue(Graphics gra) {
    selHL = false;    // inhibit picking and hilighting
    super.blue(gra);  // delegated to the super class
  }

  public void filled(Graphics gra) {
    selHL = false;      // inhibit picking and hilighting
    super.filled(gra);  // delegated to the super class
  }

  public void notFilled(Graphics gra) {
    selHL = false;         // inhibit picking and hilighting
    super.notFilled(gra);  // delegated to the super class
  }

  public void clear(Graphics gra) {  // clear all the shapes
    selHL = false;     // inhibit picking and hilighting
    super.clear(gra);  // delegated to the super class
  }


  public void move(Graphics g) {  // move all the shape
    selHL = false;  // inhibit picking and hilighting
    int dx = 100;   // distance to move in x direction is 100
    int dy = 50;    // distance to move in x direction is 50
    for (int i=0; i < numOfShape; i++) {  // for all the shapes
        shape[i].move(dx, dy);            // move the shape
    }
  }

  public void moveTo(Graphics g) {  // move all the shape
    selHL = false;  // inhibit picking and hilighting
    int xd = 300;   // the x coordinate of the destination is 300
    int yd = 300;   // the y coordinate of the destination is 300
    for (int i=0; i < numOfShape; i++) {  // for all the shapes
        shape[i].moveTo(xd, yd);          // move the shape
    }
  }

  public void scaleX(Graphics g) {
                      // scale all the scalable shapes in x direction
    selHL = false;    // inhibit picking and hilighting
    double rx = 2.0;  // scaling ratio in x direction is 2.0
    for (int i=0; i < numOfShape; i++) {    // for all the shapes
      if (shape[i] instanceof Scalable) {   // if scalable
        ((Scalable)shape[i]).scaleX(rx);    // scale the shape in x direction
      }
    }
  }

  public void scaleY(Graphics g) {
                      // scale all the scalable shapes in y direction
    selHL = false;    // inhibit picking and hilighting
    double ry = 0.5;  // scaling ratio in y direction is 0.5
    for (int i=0; i < numOfShape; i++) {    // for all the shapes
      if (shape[i] instanceof Scalable) {   // if scalable
        ((Scalable)shape[i]).scaleY(ry);    // scale the shape in y direction
      }
    }
  }

  public void scaleTo(Graphics g) {  // scale all the scalable shapes
    selHL = false;  // inhibit picking and hilighting
    int xs = 400;   // the x coodinate of the destination to scale is 400
    int ys = 400;   // the y coodinate of the destination to scale is 400
    for (int i=0; i < numOfShape; i++) {    // for all the shapes
      if (shape[i] instanceof Scalable) {   // if scalable
        ((Scalable)shape[i]).scaleTo(xs, ys);
                                     // scale the shape to the destination
      }
    }
  }

  public void highlight() {  // set all the shapes to be highlighted
    selHL = false;           // inhibit picking and hilighting
    for (int i=0; i < numOfShape; i++) {  // for all the shapes
      shape[i].highlight();               // highlight the shape
    }
  }

  public void selectHighlight() {
                     // select a shape with the mouse and highlight it
    selHL = true;    // allow picking and hilighting
  }

  public void resetHighlight() {  // set all the shapes not to be highlighted
    selHL = false;    // inhibit picking and hilighting
    for (int i=0; i < numOfShape; i++) {  // for all the shapes
      shape[i].resetHighlight();  // set the shape not to be highlighted
    }
  }

    public void mouseReleased(int x, int y, Graphics g) {
    if (selHL) {                // if picking and hilighting are allowed
	if (numOfShape > 0) {   // if any shapes exsist
        boolean found = false;  // let the flag be false
        int i = numOfShape;     
              // search from the last shape
              // because the latter shape is displayed over the former shape
        while (!found && (i > 0)) {  // while not found and any shapes left
          i--;                       // decrement the index
          if (shape[i].contains(x, y)) {  // if the shape contains (x,y)
            shape[i].highlight();            // hifhlight the shape
            found = true;                    // the shape is found
          }
        }
      }
    } else {                    // if picking and hilighting are not allowed
      super.mouseReleased(x, y, g);  // delegated to the super class
    }
  }
}
