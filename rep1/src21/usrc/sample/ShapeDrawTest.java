// ShapeDrawTest.java

import java.awt.Graphics;  // クラスGraphicsを利用する
import java.awt.Color;     // クラスColorを利用する

public class ShapeDrawTest {         // 図形描画テスト用プログラム

  Shape[] shapes = new Shape[64];  // 図形の参照を記憶する配列
  int numOfShapes = 0;             // 図形数

  public void start(Graphics gra) {  // ボタン"Start"を押すとこのメソッドを実行

    // 枠
    shapes[numOfShapes++] = new Rectangle(250, 100, 300, 325, Color.yellow, true);

    // 輪郭
    shapes[numOfShapes++] = new Oval(275, 125, 100, 100, Color.black, true);
    shapes[numOfShapes++] = new Oval(425, 125, 100, 100, Color.black, true);
    shapes[numOfShapes++] = new Oval(300, 200, 200, 200, Color.black, true);

    // 顔
    shapes[numOfShapes++] = new Oval(320, 220, 100, 120, Color.white, true);
    shapes[numOfShapes++] = new Oval(380, 220, 100, 120, Color.white, true);
    shapes[numOfShapes++] = new Oval(320, 320, 160, 60, Color.white, true);

    // 目
    shapes[numOfShapes++] = new Oval(370, 250, 20, 50, Color.black, false);
    shapes[numOfShapes++] = new Oval(410, 250, 20, 50, Color.black, false);
    shapes[numOfShapes++] = new Oval(375, 275, 10, 20, Color.black, true);
    shapes[numOfShapes++] = new Oval(415, 275, 10, 20, Color.black, true);

    // 鼻
    shapes[numOfShapes++] = new Oval(380, 310, 40, 20, Color.black, true);

    // 口
    shapes[numOfShapes++] = new Oval(380, 350, 40, 10, Color.red, true);
    shapes[numOfShapes++] = new Rectangle(375, 350, 50, 5, Color.white, true);
    shapes[numOfShapes++] = new Line(340, 345, 360, 355, Color.black);
    shapes[numOfShapes++] = new Line(360, 355, 440, 355, Color.black);
    shapes[numOfShapes++] = new Line(440, 355, 460, 345, Color.black);
    shapes[numOfShapes++] = new Line(342, 342, 338, 348, Color.black);
    shapes[numOfShapes++] = new Line(458, 342, 462, 348, Color.black);

    for (int i = 0; i < numOfShapes; i++) {  // 生成した図形分だけ
      shapes[i].draw(gra);                   // 図形描画
    }

  }
}
