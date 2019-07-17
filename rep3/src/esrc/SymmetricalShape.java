// SymmetricalShape.java

import java.awt.Graphics;  // import class Graphics
import java.awt.Color;     // import class Color

// class SymmetricalShape
public abstract class SymmetricalShape extends Shape {
  int width = 0;           // width
  int height = 0;          // height
  boolean filled = false;  // filled or not

  // constructor
  // arguments: x coordinate, y coordinate, 
  //            width, height, color, filled or not
  public SymmetricalShape(int x, int y, int w, int h, Color c, boolean f) {
    super(x, y, c);
    width = w;
    height = h;
    filled = f;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public boolean filledOrNot() {
    return filled;
  }

}
