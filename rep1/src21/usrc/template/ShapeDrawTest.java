// ShapeDrawTest.java

import java.awt.Graphics;  // クラスGraphicsを利用する
import java.awt.Color;     // クラスColorを利用する

public class ShapeDrawTest {         // 図形描画テスト用プログラム

  private Shape[] shapes = new Shape[64];  // 図形の参照を記憶する配列
  private int numOfShapes = 0;             // 図形数

  public void start(Graphics gra) {  // ボタン"Start"を押すとこのメソッドを実行

    shapes[numOfShapes++] = new Line(100, 100, 160, 130, Color.red);
                 // 線分(始点(100,100),終点(160,130),色は赤)
                 // のインスタンスの生成
            // 図形数更新
    shapes[0].draw(gra);  // 図形描画
	shapes[numOfShapes++] = new Line(200, 200, 260, 230, Color.red);
	shapes[1].draw(gra);
    


    // ここに矩形（塗りつぶしなし、塗りつぶしあり）や
    // 楕円（塗りつぶしなし、塗りつぶしあり）など、
    // いろいろな図形のインスタンスを生成し、描画するコードを書く
    // 上のLineのインスタンスを生成し、描画しているところも変更可

  }
}
