// PaintTool.java

import java.awt.Graphics;  // import class Graphics
import java.awt.Color;     // import class Color

// PaintTool
public class PaintTool extends PaintPrototype {  // inherit PaintPrototype

  public void mouseReleased(int xx, int yy, Graphics gra) {
    super.mouseReleased(xx, yy, gra);
        // call method mouseReleased() of the super class (PaintPrototype)

    if (numOfShape < shape.length) {
                    // if the number of shapes is less than the array size

      if (shapeId == 0) {  // if Line is selected
        shape[numOfShape]
                   = new Line(xPressed, yPressed, xReleased, yReleased, color);
                   // create an instance of class Line and store the reference

      } else {   // if the selected shape is not Line (Rectangle or Oval)
        int x = xPressed;  // let the x coordinate of the shape
                           //   be the y coordinate when the mouse key pressed
        int y = yPressed;  // let the y coordinate of the shape
                           //   be the y coordinate when the mouse key pressed
        int width = xReleased - x;  // let the width be the diffrence between 
                                    //     the x coordinate when mouse presed
                                    // and the x coordinate when mouse released
        int height = yReleased - y; // let the height be the diffrence between 
                                    //     the y coordinate when mouse presed
                                    // and the y coordinate when mouse released

        if (width < 0) {     // if the width is negative
          width = -width;    // make the width positive
          x = xReleased;     // let the x coordinate be 
                             //   the x coordinate when the mouse key released
        }
        if (height < 0) {    // if the height is negative
          height = -height;  // make the height positive
          y = yReleased;     // let the y coordinate be 
                             //   the y coordinate when the mouse key released
        }    

        if (shapeId == 1) {  // if Rectangle is selected
          shape[numOfShape]
                     = new Rectangle(x, y, width, height, color, filled);
               // create an instance of class Rectangle and store the reference
        } else if (shapeId == 2) {  // if Oval is selected
          shape[numOfShape]
                     = new Oval(x, y, width, height, color, filled);
               // create an instance of class Oval and store the reference
        }
      }
      numOfShape++;        // increment the number of shapes
      redrawAll(gra);      // draw all the shapes
    }
  }

}
