// SymmetricalShape.java

import java.awt.Graphics;  // クラスGraphicsを利用する
import java.awt.Color;     // クラスColorを利用する

// 左右対称の形の図形
// 塗りつぶすことも可能
public abstract class SymmetricalShape extends Shape implements Scalable{
                                            // インタフェース"Scalable"を継承
  int width = 0;           // 幅
  int height = 0;          // 高さ
  boolean filled = false;  // 塗りつぶすかどうか

  // コンストラクタ
  // Ｘ座標、Ｙ座標、幅、高さ、色、塗りつぶすかどうかを引数で受ける
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

  public void scaleX(double xratio) {  // Ｘ方向拡大縮小
    width = (int)(width * xratio);     // 幅をxratio倍する
    if (width < 0) {   // 幅が負になったら（xratioが負であったら）
      width = -width;  // 幅の値を正にし
      x = x - width;   // Ｘ座標を幅分減らす
    }      
  }

  public void scaleY(double yratio) {  // Ｙ方向拡大縮小
    height = (int)(height * yratio);   // 高さをyratio倍する
    if (height < 0) {    // 高さが負になったら（yratioが負であったら）
      height = -height;  // 高さの値を正にし
      y = y - height;    // Ｙ座標を高さ分減らす
    }      
  }

  public void scaleTo(int xs, int ys) {  // 指定座標まで拡大縮小
    width = xs - x;    // 拡大縮小後の幅を算出
    height = ys - y;   // 拡大縮小後の高さを計算
    if (width < 0) {   // 幅が負になったら
      width = -width;  // 幅の値を正にし
      x = xs;          // Ｘ座標を変更
    }      
    if (height < 0) {    // 高さが負になったら
      height = -height;  // 高さの値を正にし
      y = ys;            // Ｙ座標を変更
    }      
  }

  // 図形が指定座標を含むかどうかを示すメソッド
  public boolean contains(int xs, int ys) {
    return ((x <= xs) && (xs <= (x + width))  && 
            (y <= ys) && (ys <= (y + height)));
      // (xs, ys)が(x,y)と(x+width, y+width)の範囲内かどうかを返す
  }

}
