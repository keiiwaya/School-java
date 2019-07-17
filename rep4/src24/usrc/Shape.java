// Shape.java

import java.awt.Graphics;  // クラスGraphicsを利用する
import java.awt.Color;     // クラスColorを利用する

// 図形のクラス
public abstract class Shape implements Editable {
             // インタフェース"Editable"を継承

  int x = 0;                         // Ｘ座標
  int y = 0;                         // Ｙ座標
  Color color = Color.black;         // 図形の色（初期値は黒）
  Color highlightColor = Color.cyan; // ハイライト色はシアンとする
  boolean highlighted = false;       // ハイライト表示かどうか（初期値はfalse）

  // コンストラクタ
  // Ｘ座標、Ｙ座標、色を引数で受ける
  public Shape(int xx, int yy, Color c) {
    x = xx;
    y = yy;
    color = c;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  // 図形を移動するメソッド（引数は移動量）
  public void move(int dx, int dy) {
    x = x + dx;    // Ｘ座標をdx分移動
    y = y + dy;    // Ｙ座標をdy分移動
  }

  // 図形を移動するメソッド（引数は移動先座標）
  public void moveTo(int xd, int yd) {
    x = xd;    // Ｘ座標をxdとする
    y = yd;    // Ｙ座標をdyとする
  }

  // 図形を描画するメソッド
  public abstract void draw(Graphics gra);

  // 図形をハイライト表示に設定するメソッド
  public void highlight() {
    highlighted = true;     // ハイライト表示の属性をtrueとする
  }

  // ハイライト表示の設定を解除するメソッド
  public void resetHighlight() {
    highlighted = false;    // ハイライト表示の属性をfalseとする
  }

}
