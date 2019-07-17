// Rectangle.java

import java.awt.Graphics;  // クラスGraphicsを利用する
import java.awt.Color;     // クラスColorを利用する

// 矩形を表すクラス
public class Rectangle extends SymmetricalShape {

  // コンストラクタ
  // 引数：Ｘ座標、Ｙ座標、幅、高さ、色、塗りつぶすかどうか
  public Rectangle(int x, int y, int w, int h, Color c, boolean f) {

      // ここにコンストラクタのコードを書く

  }

  // 矩形を描画するメソッド
  public void draw(Graphics gra) {

      // ここに矩形描画のためのコードを書く
      // 描画する前に、描画色の設定が必要
      // 塗りつぶすかどうかで、呼び出すGraphicsオブジェクトの
      //                             メソッドを変える必要あり

  }

}
