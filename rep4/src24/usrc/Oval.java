// Oval.java

import java.awt.Graphics;  // クラスGraphicsを利用する
import java.awt.Color;     // クラスColorを利用する

// 楕円をあらわすクラス
public class Oval extends SymmetricalShape {

  // コンストラクタ
  // Ｘ座標、Ｙ座標、幅、高さ、色、塗りつぶすかどうかを引数で受ける
  public Oval(int x, int y, int w, int h, Color c, boolean f) {
    super(x, y, w, h, c, f);
  }

  // 楕円の描画を行うメソッド
  public void draw(Graphics gra) {
    if (highlighted) {                    // ハイライト表示の場合は
      gra.setColor(highlightColor);       // ハイライト色に設定する
    } else {                              // そうでない場合は
      gra.setColor(color);                // 本来の色を設定する
    }
    if (filled) {                         // 塗りつぶす場合には
      gra.fillOval(x, y, width, height);  // 塗りつぶし楕円を描画
    } else {                              // そうでない場合は
      gra.drawOval(x, y, width, height);  // 塗りつぶさずに楕円を描画
    }
  }

}
