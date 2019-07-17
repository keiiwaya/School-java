// SymmetricalShape.java

import java.awt.Graphics;  // import class Graphics
import java.awt.Color;     // import class Color

// class SymmetricalShape
public abstract class SymmetricalShape extends Shape implements Scalable{
                              // inherit clas "Shape" and interfece "Scalable"
  int width = 0;           // width
  int height = 0;          // height
  boolean filled = false;  // filled or not

  // constructor
  // 1st rgument: x coordinate
  // 2nd rgument: y coordinate
  // 3rd rgument: width
  // 4th rgument: height
  // 5th rgument: color
  // 6th rgument: hilighted or not
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

  // method to scale the symmetrical shape in x direction by the ratio
  // argument: ratio 
  public void scaleX(double xratio) {
    width = (int)(width * xratio);  // multiply the width by the ratio
    if (width < 0) {   // if the width is negative
      width = -width;  // let the width be positive
      x = x - width;   // subtract the width from the x coordinate
    }      
  }

  // method to scale the symmetrical shape in y direction by the ratio
  // argument: ratio 
  public void scaleY(double yratio) {
    height = (int)(height * yratio);  // multiply the height by the ratio
    if (height < 0) {    // if the height is negative
      height = -height;  // let the height be positive
      y = y - height;    // subtract the height from the y coordinate
    }      
  }

  // method to scale the symmetrical shape to the desitination
  // 1st argument: x coordinate of the destination
  // 2nd argument: y coordinate of the destination
  public void scaleTo(int xs, int ys) {
    width = xs - x;    // calculate the width sfter scaling
    height = ys - y;   // calculate the height sfter scaling
    if (width < 0) {   // if the width is negative
      width = -width;  // let the width be positive
      x = xs;   // let the x coordinate be the x coordinate of the destination
    }      
    if (height < 0) {    // if the height is negative
      height = -height;  // let the height be positive
      y = ys;   // let the y coordinate be the y coordinate of the destination
    }      
  }

  // method to determine if the symmetrical shape contains 
  //                        the coordinate specified by the arguments
  public boolean contains(int xs, int ys) {
    return ((x <= xs) && (xs <= (x + width))  && 
            (y <= ys) && (ys <= (y + height)));
                 // return if the bounding box contains (xs, ys) or not
  }

}
