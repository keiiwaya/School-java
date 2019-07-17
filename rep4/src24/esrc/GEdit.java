// GEditt.java

import java.awt.Graphics;  // import class Graphics
import java.awt.Color;     // import class Color

// interface for a graphic editor
// define class GraphicEditor inheriting class PaintTool and interface GEdit
// implement the method declared in GEdit

// interface GEdit
public interface GEdit extends GPaint{

  // Method to be called when item "Edit" of menu "Shape" is selected
  public void edit(Graphics gra);

  // Method to be called when button "Deselect" is pressed
  // the frame is cleared and shapes are redrawed after executing this method
  public void deselect(Graphics gra);

  // Method to be called when button "Delete" is pressed
  // the frame is cleared and shapes are redrawed after executing this method
  public void delete(Graphics gra);

  // Method to be called when button "Move" is pressed
  // the frame is cleared and shapes are redrawed after executing this method
  public void move(Graphics gra);

  // Method to be called when button "Scale" is pressed
  // the frame is cleared and shapes are redrawed after executing this method
  public void scale(Graphics gra);

}
