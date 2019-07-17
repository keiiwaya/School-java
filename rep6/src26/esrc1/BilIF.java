// BilIF.java

// Inherit this class if you use BilFrame

import java.awt.Graphics;  // import class Graphics

// Interface BilIF
public interface BilIF {

  // start the game
  public void start(Graphics g);  // argument: object of Graphics

  // display the billiard
  public void draw(Graphics g);  // argument: object of Graphics

  // reset the game
  public void reset();

}
