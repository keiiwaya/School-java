// Rectangle.java

import java.awt.Graphics;  // クラスGraphicsを利用する
import java.awt.Color;     // クラスColorを利用する

// 矩形を表すクラス
public class Rectangle extends SymmetricalShape {
  int enx = 0;
  int eny = 0;

  // コンストラクタ
  // 引数：Ｘ座標、Ｙ座標、幅、高さ、色、塗りつぶすかどうか
  public Rectangle(int x, int y, int w, int h, Color c, boolean f) {
    super(x, y, w, h, c, f);
  }

  // 矩形を描画するメソッド
  public void draw(Graphics gra) {
    if(hl == false) {
      gra.setColor(color);                  // 描画色を設定
    }else{
      gra.setColor(Color.cyan);
    }
    if (filled) {                         // 塗りつぶす場合には
      gra.fillRect(x, y, width, height);  // 塗りつぶし矩形を描画
    } else {
      gra.drawRect(x, y, width, height);  // 塗りつぶさずに矩形を描画
    }
  }
/*
  public void scaleX(double xratio) {
    width *= xratio;
  }

  public void scaleY(double yratio) {
    height *= yratio;
  }

  public void scaleTo(int xs, int ys) {

    if(xs > 0) {
      width = xs;
    }else if(xs < 0){
      width = -xs;
    }

    if(ys > 0){
      height = ys;
    }else if(ys < 0){
      height = -ys;
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

*/

}
