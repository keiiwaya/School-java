// Oval.java

import java.awt.Graphics;  // import class Graphics
import java.awt.Color;     // import class Color

// class Oval
public class Oval extends SymmetricalShape {

  // constructor
  // 1st rgument: x coordinate of the rectangle
  // 2nd rgument: y coordinate of the rectangle
  // 3rd rgument: width of the rectangle
  // 4th rgument: height of rectangle
  // 5th rgument: color
  // 6th rgument: hilighted or not
  public Oval(int x, int y, int w, int h, Color c, boolean f) {
    super(x, y, w, h, c, f);
  }

  // method to draw the oval
  public void draw(Graphics gra) {
    if (highlighted) {                    // if highlited
      gra.setColor(highlightColor);       // set the highlight color
    } else {                              // if not highlited
      gra.setColor(color);                // set the original color
    }
    if (filled) {                         // if filled
      gra.fillOval(x, y, width, height);  // fill the rectangle
    } else {                              // if not filled
      gra.drawOval(x, y, width, height);  // draw the rectangle
    }
  }

}
