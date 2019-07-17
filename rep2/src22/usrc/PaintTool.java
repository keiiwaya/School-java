// PaintTool.java
import java.awt.Graphics;
import java.awt.Color;

public class PaintTool extends PaintPrototype {
  int width = 0;
  int height = 0;
  int st1 = 0;
  int st2 = 0;

public void mouseReleased(int xx, int yy, Graphics gra){
  xReleased = xx;
  yReleased = yy;
  width = xReleased - xPressed;
  height = yReleased - yPressed;
  st1 = xPressed;
  st2 = yPressed;

  if(width < 0){
    st1 = xReleased;
    width *= -1;
  }
  if(height < 0) {
    st2 = yReleased;
    height *= -1;
  }

    if(shapeId == 0){
      shape[numOfShape++] = new Line(xPressed, yPressed, xReleased,
      yReleased, color);
    }else if(shapeId == 1){
      shape[numOfShape++] = new Rectangle(st1, st2,
       width, height, color, filled);
    }else{
      shape[numOfShape++] = new Oval(st1, st2,
      width, height, color, filled);
    }
    shape[numOfShape - 1].draw(gra);
  }

}
