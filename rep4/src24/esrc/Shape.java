// Shape.java

import java.awt.Graphics;  // import class Graphics
import java.awt.Color;     // import class Color

// class Shape
public abstract class Shape implements Editable {
                            // inherit interfece "Editable"

  int x = 0;                         // x coorsdinate
  int y = 0;                         // y coordinate
  Color color = Color.black;         // color
  Color highlightColor = Color.cyan; // highlight color: cyan
  boolean highlighted = false;       // hilighted or not

  // constructor
  // 1st rgument: x coordinate
  // 2nd rgument: y coordinate
  // 3rd rgument: color
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

  // method to move the shape
  // 1st argument: distance to move in x direction
  // 2nd argument: distance to move in y direction
  public void move(int dx, int dy) {
    x = x + dx;    // move the x coordinate
    y = y + dy;    // move the y coordinate
  }

  // method to move the shape to the destination
  // 1st argument: x coordinate of the destination
  // 2nd argument: y coordinate of the destination
  public void moveTo(int xd, int yd) {
    x = xd;    // move the x coordinate to the destination
    y = yd;    // move the y coordinate to the destination
  }

  // method to draw the shape
  public abstract void draw(Graphics gra);

  // method to set the shape to be highlighted
  public void highlight() {
    highlighted = true;     // let attribute highlighted be true
  }

  // method to set the shape not to be highlighted
  public void resetHighlight() {
    highlighted = false;    // let attribute highlighted be false
  }

}
