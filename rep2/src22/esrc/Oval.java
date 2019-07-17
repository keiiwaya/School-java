// Oval.java

import java.awt.Graphics;  // import class Graphics
import java.awt.Color;     // import class Color

// class Oval
public class Oval extends SymmetricalShape {

  // constructor
  // arguments: x coordinate, y coordinate, 
  //            width, height, color, filled or not
  public Oval(int x, int y, int w, int h, Color c, boolean f) {
    super(x, y, w, h, c, f);
  }

  // draw the oval
  public void draw(Graphics gra) {
    gra.setColor(color);                  // set the drawing color
    if (filled) {                         // if the oval is filled
      gra.fillOval(x, y, width, height);  // fill the oval
    } else {
      gra.drawOval(x, y, width, height);  // draw the oval
    }
  }

}
