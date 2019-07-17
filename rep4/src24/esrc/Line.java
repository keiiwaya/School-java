// Line.java

import java.awt.Graphics;  // import class Graphics
import java.awt.Color;     // import class Color

// class Line
public class Line extends Shape {
  int xend = 0;  // x coordinate of the end point
  int yend = 0;  // y coordinate of the end point

  // constructor
  // 1st rgument: x coordinate of the starting point
  // 2nd rgument: y coordinate of the starting point
  // 3rd rgument: x coordinate of the end point
  // 4th rgument: y coordinate of the end point
  // 5th rgument: color
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

  // method to move the line
  // 1st argument: distance to move in x direction
  // 2nd argument: distance to move in y direction
  public void move(int dx, int dy) {
    super.move(dx, dy);  // move the starting point
    xend = xend + dx;    // move the x coordinate of the end point
    yend = yend + dy;    // move the y coordinate of the end point
  }

  // method to move the line
  // 1st argument: x coordinate of the destination
  // 2nd argument: y coordinate of the destination
  public void moveTo(int xd, int yd) {
    xend = xend + (xd - x);    // move the x coordinate of the end point
    yend = yend + (yd - y);    // move the y coordinate of the end point
    super.moveTo(xd, yd);      // move the starting point
  }

  // method to draw the line
  public void draw(Graphics gra) {
    if (highlighted) {               // if highlited
      gra.setColor(highlightColor);  // set the highlight color
    } else {                         // if not highlited
      gra.setColor(color);           // set the original color
    }
    gra.drawLine(x, y, xend, yend);  // draw the line
  }

  // method to determine if the line contains 
  //                        the coordinate specified by the arguments
  public boolean contains(int xs, int ys) {
    int x1 = x;     // suppose that x1 of the bounding rectangle is x
    int y1 = y;     // suppose that y1 of the bounding rectangle is y
    int x2 = xend;  // suppose that x2 of the bounding rectangle is xend
    int y2 = yend;  // suppose that y2 of the bounding rectangle is yend
    if (x > xend) {   // if x > xend
      x1 = xend;      // let x1 be xend
      x2 = x;         // let x2 be x
    }
    if (y > yend) {   // if y > yend
      y1 = yend;      // let y1 be yend
      y2 = y;         // let y2 be y
    }
    return ((x1 <= xs) && (xs <= x2) && (y1 <= ys) && (ys <= y2));
           // return if the bounding box contains (xs, ys) or not
  }

}
