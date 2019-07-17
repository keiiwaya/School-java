// Editable.java

// interface Editable
public interface Editable {

  // method to move the shape
  // 1st argument: distance to move in x direction
  // 2nd argument: distance to move in y direction
  public void move(int dx, int dy);

  // method to move the shape to the destination
  // 1st argument: x coordinate of the destination
  // 2nd argument: y coordinate of the destination
  public void moveTo(int xd, int yd);

  // method to set the shape to be highligheted
  public void highlight();

  // method to set the shape not to be highligheted
  public void resetHighlight();

  // method to determine if the shape contains 
  //        the coordinate specified by the arguments
  public boolean contains(int xs, int ys);

}

