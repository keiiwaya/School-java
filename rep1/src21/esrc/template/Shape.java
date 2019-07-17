// Shape.java

import java.awt.Graphics;  // import class Graphics
import java.awt.Color;     // import class Color

// class Shape
public abstract class Shape {
  int x = 0;                  // xcoordinate
  int y = 0;                  // y coordinate
  Color color = Color.black;  // color (initial value is black)

  // constructor
  // arguments: x coordinate, y coordinate, color
  public Shape(int xx, int yy, Color c) {
    x = xx;
    y = yy;
    color = c;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  // draw the shape
  public abstract void draw(Graphics gra);

}
