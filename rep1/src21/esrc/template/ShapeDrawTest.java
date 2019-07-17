// ShapeDrawTest.java

import java.awt.Graphics;  // import class Graphics
import java.awt.Color;     // import class Color

// Test Program
public class ShapeDrawTest {

  private Shape[] shapes = new Shape[64];
                                // array to store the references of shapes
  private int numOfShapes = 0;  // number of shapes

  public void start(Graphics gra) {  // executed when button "start" pressed

    Line l = new Line(100, 100, 160, 130, Color.red);
      // create an instance of class Line
      // starting point: (100, 100), end point: (160, 130), color: red
    numOfShapes++;        // increment the number of shapes
    shapes[0].draw(gra);  // draw the shape

    // code should be written here
    // the code above can also be modified

  }

}
