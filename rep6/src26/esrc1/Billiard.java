// Billiard.java

import java.io.*;          // import classes in package java.io
import java.awt.Graphics;  // import class Graphics
import java.awt.Color;     // import class Color

// Class Billiard
public class Billiard implements BilIF {  // inherits interface BilIF
  Table table;  // reference to the instance of Table
  Ball ball;    // reference to the instance of Ball

  // main program
  public static void main(String[] args) {
    String inStr;  // variable for input string
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                                                    // create a string reader
    try{
      System.out.print("Input the width of the table: ");
      inStr = in.readLine();              // input string
      int m = Integer.parseInt(inStr);    // convert the string to an integer
      System.out.print("Input the height of the table: ");
      inStr = in.readLine();              // input string
      int n = Integer.parseInt(inStr);    // convert the string to an integer
      Billiard bil = new Billiard(m, n);  // create an instance of Billiard
      new BilFrame("Billiard", 200 + m, 200 + n, bil);
                        // create an instance of BilFrame
                        // the width and height are 200 larger than the table
    } catch(IOException e) {            // if an IO exception occurs
      System.out.println(e.getMessage());
      System.out.println("Try once more.");
    } catch(NumberFormatException e) {  // if a number foramt exception occurs
      System.out.println(e.getMessage());
      System.out.println("Try onece more.");
    }
  }

  // constractor
  public Billiard(int xmax, int ymax) {
                                   // 1st argument: width, 2nd argument height
    table = new Table (xmax, ymax);  // creare an instance of Table
    ball = new Ball(table, 0, 0);    // create an instance of Ball
                                     // the initial position is (0, 0)
  }

  // Method to start the game
  public void start(Graphics g) {  // argument: object of Graphics
    ball.go(1, 1, g);    // poke the ball to move with initial velocity (0, 0)
    System.out.println("The ball fell in pocket (" + ball.getX() + ", "
                               + ball.getY() + ").");
    System.out.println("The ball hit the wall " + ball.getCount() + " times.");
  }

  // Method to display the billiard
  public void draw(Graphics g) {  // argument: object of Graphics
    table.draw(g);      // display the table
    ball.draw(g);       // display the ball
  }

  // Method to reset the game
  public void reset() {
    ball.reset();       // reset the state of the ball
  }

}
