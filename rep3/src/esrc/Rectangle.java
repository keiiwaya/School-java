// Rectangle.java

import java.awt.Graphics;  // import class Graphics
import java.awt.Color;     // import class Color

// class Rectangle
public class Rectangle extends SymmetricalShape {

  // constructor
  // arguments: x coordinate, y coordinate, 
  //            width, height, color, filled or not
  public Rectangle(int x, int y, int w, int h, Color c, boolean f) {
    super(x, y, w, h, c, f);
  }

  // draw the rectangle
  public void draw(Graphics gra) {
    gra.setColor(color);                  // set the drawing color
    if (filled) {                         // if the the rectangle is filled
      gra.fillRect(x, y, width, height);  // fill the oval
    } else {
      gra.drawRect(x, y, width, height);  // draw the oval
    }
  }

}
