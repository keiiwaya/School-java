// ShapeDrawTest.java

import java.awt.Graphics;  // import class Graphics
import java.awt.Color;     // import class Color

// Test Program
public class ShapeDrawTest {

  Shape[] shapes = new Shape[64];  // array to store the references of shapes
  int numOfShapes = 0;             // the number of shapes

  public void start(Graphics gra) {  // executed when button "start" pressed

    // frame
    shapes[numOfShapes++] = new Rectangle(250, 100, 300, 325, Color.yellow, true);

    // outline
    shapes[numOfShapes++] = new Oval(275, 125, 100, 100, Color.black, true);
    shapes[numOfShapes++] = new Oval(425, 125, 100, 100, Color.black, true);
    shapes[numOfShapes++] = new Oval(300, 200, 200, 200, Color.black, true);

    // face
    shapes[numOfShapes++] = new Oval(320, 220, 100, 120, Color.white, true);
    shapes[numOfShapes++] = new Oval(380, 220, 100, 120, Color.white, true);
    shapes[numOfShapes++] = new Oval(320, 320, 160, 60, Color.white, true);

    // eyes
    shapes[numOfShapes++] = new Oval(370, 250, 20, 50, Color.black, false);
    shapes[numOfShapes++] = new Oval(410, 250, 20, 50, Color.black, false);
    shapes[numOfShapes++] = new Oval(375, 275, 10, 20, Color.black, true);
    shapes[numOfShapes++] = new Oval(415, 275, 10, 20, Color.black, true);

    // nose
    shapes[numOfShapes++] = new Oval(380, 310, 40, 20, Color.black, true);

    // mouth
    shapes[numOfShapes++] = new Oval(380, 350, 40, 10, Color.red, true);
    shapes[numOfShapes++] = new Rectangle(375, 350, 50, 5, Color.white, true);
    shapes[numOfShapes++] = new Line(340, 345, 360, 355, Color.black);
    shapes[numOfShapes++] = new Line(360, 355, 440, 355, Color.black);
    shapes[numOfShapes++] = new Line(440, 355, 460, 345, Color.black);
    shapes[numOfShapes++] = new Line(342, 342, 338, 348, Color.black);
    shapes[numOfShapes++] = new Line(458, 342, 462, 348, Color.black);

    for (int i = 0; i < numOfShapes; i++) {  // for all shapes
      shapes[i].draw(gra);                   // draw shapes
    }
  }

}
