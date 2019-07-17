// Line.java

import java.awt.Graphics;  // クラスGraphicsを利用する
import java.awt.Color;     // クラスColorを利用する

// 直線(線分)を表すクラス
public class Line extends Shape {
  int xend = 0;   // 終点のＸ座標
  int yend = 0;   // 終点のＹ座標
  int xlength = 0;
  int ylength = 0;

  // コンストラクタ
  // 引数：始点のＸ座標、始点のＹ座標、終点のＸ座標、終点のＹ座標、色
  public Line(int x1, int y1, int x2, int y2, Color color) {
    super(x1, y1, color);
    xend = x2;
    yend = y2;
    xlength = xend - x;
    ylength = yend - y;
  }

  public int getXend() {
    return xend;
  }
  public int getYend() {
    return yend;
  }

  // 直線を描画するメソッド
  public void draw(Graphics gra) {
    gra.setColor(color);             // 描画色を設定
    gra.drawLine(x, y, xend, yend);  // 直線(線分)を描画
  }

  public void move(int dx, int dy) {
    x += dx;
    y += dy;
    xend += dx;
    yend += dy;
  }

  public void moveTo(int xd, int yd) {
    x = xd;
    y = yd;
    xend = x + xlength;
    yend = y + ylength;
  }

  public void highlight() {
  }

  public void resetHighlight() {
  }

  public boolean contains(int xs, int ys) {
    if(x <= xs && xend >= xs && y <= ys && yend >= ys) {
      return true;
    }else{
      return false;
    }
  }







}
