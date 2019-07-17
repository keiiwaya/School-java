// Oval.java

import java.awt.Graphics;  // クラスGraphicsを利用する
import java.awt.Color;     // クラスColorを利用する

// 楕円をあらわすクラス
public class Oval extends SymmetricalShape {

  // コンストラクタ
  // 引数：Ｘ座標、Ｙ座標、幅、高さ、色、塗りつぶすかどうか
  public Oval(int x, int y, int w, int h, Color c, boolean f) {

      // ここにコンストラクタのコードを書く
      super(x,y,w,h,c,f);
      

  }

  // 楕円の描画を行うメソッド
  public void draw(Graphics gra) {

      // ここに楕円描画のためのコードを書く
      // 描画する前に、描画色の設定が必要
      // 塗りつぶすかどうかで、呼び出すGraphicsオブジェクトの
      //                             メソッドを変える必要あり
      gra.setColor(color);
      if(filledOrNot() == false){
	  gra.drawOval(x, y, width, height);
      } else {
	  gra.fillOval(x, y, width, height);
      }
	  

  }

}
