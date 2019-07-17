// PaintTool.java

import java.awt.Graphics;  // クラスGraphicsを利用する
import java.awt.Color;     // クラスColorを利用する

// ペイントツール
public class PaintTool extends PaintPrototype {  // PaintPrototypeを継承

  public void mouseReleased(int xx, int yy, Graphics gra) {
    super.mouseReleased(xx, yy, gra);
        // スーパークラス（PaintPrototype）のメソッド mouseReleased() 呼び出し

    if (numOfShape < shape.length) {   // 図形数がまだ記憶できる範囲であれば

      if (shapeId == 0) {  // 図形が直線の場合
        shape[numOfShape]
                   = new Line(xPressed, yPressed, xReleased, yReleased, color);
                                    // 直線のインスタンスを生成し、参照を記憶

      } else {             // 図形が直線以外（矩形または楕円）の場合
        int x = xPressed;    // 図形のＸ座標をマウスキーを押したＸ座標とする
        int y = yPressed;    // 図形のＹ座標をマウスキーを押したＸ座標とする
        int width = xReleased - x;   // 図形の幅をマウスキーを押したＸ座標と
                                     // 離したＸ座標から計算する
        int height = yReleased - y;  // 図形の幅をマウスキーを押したＹ座標と
                                     // 離したＹ座標から計算する

        if (width < 0) {     // 幅が負になってしまった場合は
          width = -width;    // 幅を正にして
          x = xReleased;     // 図形のＸ座標をマウスキーを離したＸ座標とする
        }
        if (height < 0) {  // 高さが負になってしまった場合は
          height = -height;  // 高さを正にして
          y = yReleased;     // 図形のＹ座標をマウスキーを離したＹ座標とする
        }    

        if (shapeId == 1) {         // 矩形の場合
          shape[numOfShape]
                     = new Rectangle(x, y, width, height, color, filled);
                                    // 矩形のインスタンスを生成し、参照を記憶
        } else if (shapeId == 2) {  // 楕円の場合
          shape[numOfShape]
                     = new Oval(x, y, width, height, color, filled);
                                    // 楕円のインスタンスを生成し、参照を記憶
        }
      }

      shape[numOfShape].draw(gra);  // 生成した図形を描画
      numOfShape++;                 // 図形数を１増やす

    }
  }

}
