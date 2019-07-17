// SymmetricalShape.java

import java.awt.Graphics;  // クラスGraphicsを利用する
import java.awt.Color;     // クラスColorを利用する

// 左右対称の形の図形
// 塗りつぶすことも可能
public abstract class SymmetricalShape extends Shape implements Scalable {
  int width = 0;           // 幅
  int height = 0;          // 高さ
  boolean filled = false;  // 塗りつぶすかどうか
  boolean hl = false;

  // コンストラクタ
  // 引数：Ｘ座標、Ｙ座標、幅、高さ、色、塗りつぶすかどうか
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

  public void scaleX(double xratio) {
    width *= xratio;
  }

  public void scaleY(double yratio) {
    height *= yratio;
  }

  public void scaleTo(int xs, int ys) {
    width = xs - x;
    height = ys - y;
    if (width < 0) {
      width = -width;
      x = xs;
    }
    if (height < 0) {
      height = -height;
      y = ys;
    }
}
  public void move(int dx, int dy) {
    x += dx;
    y += dy;
  }

  public void moveTo(int xd, int yd) {
    x = xd;
    y = yd;
  }


    public void highlight() {
      hl = true;
    }

    public void resetHighlight() {
      hl = false;
    }

  public boolean contains(int xs, int ys) {
    if(x <= xs && x + width >= xs && y <= ys && y + height >= ys) {
      return true;
    }else{
      return false;
    }
  }

}
