// Line.java

import java.awt.Graphics;  // import class Graphics
import java.awt.Color;     // import class Color

// class Line
public class Line extends Shape {
  int xend = 0;  // x coordinate of the end point
  int yend = 0;  // y coordinate of the end point

  // constructor
  // arguments: x coordinate of the starting point,
  //            y coordinate of the starting point,
  //            x coordinate of the end point,
  //            y coordinate of the end point,
  //            color
  public Line(int x1, int y1, int x2, int y2, Color color) {
    super(x1, y1, color);
    xend = x2;
    yend = y2;
  }

  public int getXend() {
    return xend;
  }
  public int getYend() {
    return yend;
  }

  // draw the line
  public void draw(Graphics gra) {
    gra.setColor(color);             // set the drawing color
    gra.drawLine(x, y, xend, yend);  // draw the line
  }

}
