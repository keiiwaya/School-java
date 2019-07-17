// Scalable.java

// interface Scalable
public  interface Scalable {

  // method to scale the shape in x direction by the ratio
  // argument: ratio 
  public void scaleX(double xratio);

  // method to scale the shape in y direction by the ratio
  // argument: ratio 
  public void scaleY(double yratio);

  // method to scale the shape to the desitination
  // 1st argument: x coordinate of the destination
  // 2nd argument: y coordinate of the destination
  public void scaleTo(int xs, int ys);

}
