// Line.java

import java.awt.Graphics;  // クラスGraphicsを利用する
import java.awt.Color;     // クラスColorを利用する

// 直線を表すクラス
public class Line extends Shape {
  int xend = 0;   // 終点のＸ座標
  int yend = 0;   // 終点のＹ座標

  // コンストラクタ
  // 始点のＸ座標、始点のＹ座標、終点のＸ座標、終点のＹ座標、
  // 色を引数で受ける
  public Line(int x1, int y1, int x2, int y2, Color color) {
    super(x1, y1, color);
    xend = x2;
    yend = y2;
  }

  public int getXend() {
    return xend;
  }
  public int getYend() {
    return yend;
  }

  // 図形を移動するメソッド（引数は移動量）
  public void move(int dx, int dy) {
    super.move(dx, dy);  // （始点の）Ｘ座標、Ｙ座標を移動
    xend = xend + dx;    // 終点のＸ座標をdx分移動
    yend = yend + dy;    // 終点のＹ座標をdy分移動
  }

  // 図形を移動するメソッド（引数は移動先座標）
  public void moveTo(int xd, int yd) {
    xend = xend + (xd - x);    // 終点のＸ座標を移動
    yend = yend + (yd - y);    // 終点のＹ座標を移動
    super.moveTo(xd, yd);      // （始点の）Ｘ座標、Ｙ座標を移動
  }

  // 直線を描画するメソッド
  public void draw(Graphics gra) {
    if (highlighted) {               // ハイライト表示の場合は
      gra.setColor(highlightColor);  // ハイライト色に設定する
    } else {                         // そうでない場合は
      gra.setColor(color);           // 本来の色を設定する
    }
    gra.drawLine(x, y, xend, yend);  // 直線（線分）を描画する
  }

  // 図形が指定座標を含むかどうかを示すメソッド
  public boolean contains(int xs, int ys) {
    int x1 = x;     // 外接矩形の左上のＸ座標x1を（仮に）始点のＸ座標とする
    int y1 = y;     // 外接矩形の左上のＹ座標y1を（仮に）始点のＹ座標とする
    int x2 = xend;  // 外接矩形の右下のＸ座標x2を（仮に）終点のＸ座標とする
    int y2 = yend;  // 外接矩形の右下のＹ座標y2を（仮に）終点のＹ座標とする
    if (x > xend) {   // 始点のＸ座標が終点のＸ座標より大きい場合は
      x1 = xend;      // x1を終点のＸ座標とする
      x2 = x;         // x2を始点のＸ座標とする
    }
    if (y > yend) {   // 始点のＹ座標が終点のＹ座標より大きい場合は
      y1 = yend;      // y1を終点のＹ座標とする
      y2 = y;         // y2を始点のＹ座標とする
    }
    return ((x1 <= xs) && (xs <= x2) && (y1 <= ys) && (ys <= y2));
                                     // (xs, ys)が外接矩形内かどうかを返す
  }

}
