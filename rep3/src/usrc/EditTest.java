// EditTest.java

import java.awt.Graphics;  // クラスGraphicsを利用する
import java.awt.Color;     // クラスColorを利用する

// 編集テスト用プログラム
public class EditTest extends PaintTool {

  boolean selHL = false;  // マウスによる図形選択・ハイライト表示を行うかどうか

  public void line(Graphics gra) {
    selHL = false;    // マウスによる図形選択・ハイライト表示は行わない
    super.line(gra);  // スーパークラスに処理を任せる
  }

  public void rectangle(Graphics gra) {
    selHL = false;         // マウスによる図形選択・ハイライト表示は行わない
    super.rectangle(gra);  // スーパークラスに処理を任せる
  }

  public void oval(Graphics gra) {
    selHL = false;    // マウスによる図形選択・ハイライト表示は行わない
    super.oval(gra);  // スーパークラスに処理を任せる
  }

  public void black(Graphics gra) {
    selHL = false;     // マウスによる図形選択・ハイライト表示は行わない
    super.black(gra);  // スーパークラスに処理を任せる
  }

  public void red(Graphics gra) {
    selHL = false;   // マウスによる図形選択・ハイライト表示は行わない
    super.red(gra);  // スーパークラスに処理を任せる
  }

  public void green(Graphics gra) {
    selHL = false;     // マウスによる図形選択・ハイライト表示は行わない
    super.green(gra);  // スーパークラスに処理を任せる
  }

  public void blue(Graphics gra) {
    selHL = false;    // マウスによる図形選択・ハイライト表示は行わない
    super.blue(gra);  // スーパークラスに処理を任せる
  }

  public void filled(Graphics gra) {
    selHL = false;      // マウスによる図形選択・ハイライト表示は行わない
    super.filled(gra);  // スーパークラスに処理を任せる
  }

  public void notFilled(Graphics gra) {
    selHL = false;         // マウスによる図形選択・ハイライト表示は行わない
    super.notFilled(gra);  // スーパークラスに処理を任せる
  }

  public void clear(Graphics gra) {  // 全ての図形を消去
    selHL = false;     // マウスによる図形選択・ハイライト表示は行わない
    super.clear(gra);  // スーパークラスに処理を任せる
  }


  public void move(Graphics g) {  // 全ての図形を移動
    selHL = false;  // マウスによる図形選択・ハイライト表示は行わない
    int dx = 100;   // Ｘ方向の移動量を100とする（値を変えてもよい)
    int dy = 50;    // Ｙ方向の移動量を50とする（値を変えてもよい)
    for (int i=0; i < numOfShape; i++) {  // 全ての図形を
        shape[i].move(dx, dy);            // 移動
    }
  }

  public void moveTo(Graphics g) {  // 全ての図形を移動
    selHL = false;  // マウスによる図形選択・ハイライト表示は行わない
    int xd = 300;   // 移動先のＸ座標を300とする（値を変えてもよい)
    int yd = 300;   // 移動先のＹ座標を300とする（値を変えてもよい)
    for (int i=0; i < numOfShape; i++) {  // 全ての図形を
        shape[i].moveTo(xd, yd);          // 移動
    }
  }

  public void scaleX(Graphics g) {  // 直線でない全ての図形をＸ方向拡大縮小
    selHL = false;    // マウスによる図形選択・ハイライト表示は行わない
    double rx = 2.0;  // Ｘ方向の拡大率を2.0とする（値を変えてもよい)
    for (int i=0; i < numOfShape; i++) {        // 全ての図形について
      if (shape[i] instanceof Scalable) {       // 拡大縮小可能であれば
        ((Scalable)shape[i]).scaleX(rx);        // Ｘ方向拡大縮小
      }
    }
  }

  public void scaleY(Graphics g) {  // 直線でない全ての図形をＹ方向拡大縮小
    selHL = false;    // マウスによる図形選択・ハイライト表示は行わない
    double ry = 0.5;  // Ｙ方向の拡大率を0.5とする（値を変えてもよい)
    for (int i=0; i < numOfShape; i++) {        // 全ての図形について
      if (shape[i] instanceof Scalable) {       // 拡大縮小可能であれば
        ((Scalable)shape[i]).scaleY(ry);        // Ｙ方向拡大縮小
      }
    }
  }

  public void scaleTo(Graphics g) {  // 直線でない全ての図形を座標指定拡大縮小
    selHL = false;    // マウスによる図形選択・ハイライト表示は行わない
    int xs = 400;   // 拡大縮小先のＸ座標を400とする（値を変えてもよい)
    int ys = 400;   // 拡大縮小先先のＹ座標を400とする（値を変えてもよい)
    for (int i=0; i < numOfShape; i++) {        // 全ての図形について
      if (shape[i] instanceof Scalable) {       // 拡大縮小可能であれば
        ((Scalable)shape[i]).scaleTo(xs, ys);   // 座標指定拡大縮小
      }
    }
  }

  public void highlight() {  // 全ての図形をハイライト表示に設定
    selHL = false;    // マウスによる図形選択・ハイライト表示は行わない
    for (int i=0; i < numOfShape; i++) {  // 全ての図形を
      shape[i].highlight();               // ハイライト表示
    }
  }

  public void selectHighlight() {  // 図形をマウスで選択してハイライト表示設定
    selHL = true;    // マウスによる図形選択・ハイライト表示を行う
  }

  public void resetHighlight() {  // 全ての図形をハイライト表示解除
    selHL = false;    // マウスによる図形選択・ハイライト表示は行わない
    for (int i=0; i < numOfShape; i++) {  // 全ての図形について
      shape[i].resetHighlight();          // ハイライト表示をやめる
    }
  }

    public void mouseReleased(int x, int y, Graphics g) {
    if (selHL) {     // マウスによる図形選択・ハイライト表示を行うならば
	if (numOfShape > 0) {   // 図形が存在するならば
        boolean found = false;  // まだ見つかってないものとする
        int i = numOfShape;     // 後ろから探す（後ろの方が上に表示されるので)
        while (!found && (i > 0)) {  // 見つかっておらず、図形がまだあるならば
          i--;                       // インデックス更新
          if (shape[i].contains(x, y)) {  // 図形が指定座標を含んでいれば
            shape[i].highlight();            // その図形をハイライト表示
            found = true;                    // 図形が見つかったとする
          }
        }
      }
    } else {         // マウスによる図形選択・ハイライト表示を行わないなら
      super.mouseReleased(x, y, g);  // スーパークラスに処理を任せる
    }
  }
}
