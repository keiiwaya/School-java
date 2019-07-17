  // PaintPrototype.java

import java.awt.Graphics;  // クラスGraphicsを利用する
import java.awt.Color;     // クラスColorを利用する

// 図形作成ツール用の抽象クラス
// このクラスを継承して、ペイントツールのクラスを作成する
// ただし、画面のメニュー類の初期状態は以下とする
// 「図形」は「直線」が選択されている
// 「色」は「黒」が選択されている
// 「塗りつぶし」は「なし」が選択されている

public abstract class PaintPrototype implements GPaint {
  int shapeId = 0;                // 図形の種類を表す変数
                                  // 0:直線、1:矩形、2:楕円
  Color color = Color.black;      // 描画の色を表す変数
  boolean filled = false;         // 塗りつぶし図形かどうか
  int xPressed = 50;              // マウスキーが押された位置のＸ座標
  int yPressed = 50;              // マウスキーが押された位置のＹ座標
  int xReleased = 100;            // マウスキーが離された位置のＸ座標
  int yReleased = 100;            // マウスキーが離された位置のＹ座標
  int xDragged = 60;              // ドラッグされた時のＸ座標
  int yDragged = 60;              // ドラッグされた時のＹ座標
  Shape[] shape = new Shape[256]; // 作成した図形の参照を格納する配列
  int numOfShape = 0;             // 作成した図形の数

  // 初期化メソッド
  // インスタンス生成後に呼び出される
  // 必要であれば、継承したクラスでオーバライドする
  public void init(Graphics gra) {
  }

  // メニュー"Shape"の"Line"が選択された時に呼び出されるメソッド
  // 必要であれば、継承したクラスでオーバライドする
  public void line(Graphics gra) {
    shapeId = 0;
  }

  // メニュー"Shape"の"Rectangle"が選択された時に呼び出されるメソッド
  // 必要であれば、継承したクラスでオーバライドする
  public void rectangle(Graphics gra) {
    shapeId = 1;
  }

  // メニュー"Shape"の"Oval"が選択された時に呼び出されるメソッド
  // 必要であれば、継承したクラスでオーバライドする
  public void oval(Graphics gra) {
    shapeId = 2;
  }

  // メニュー"Color"の"Black"が選択された時に呼び出されるメソッド
  // 必要であれば、継承したクラスでオーバライドする
  public void black(Graphics gra) {
    color = Color.black;
  }

  // メニュー"Color"の"Red"が選択された時に呼び出されるメソッド
  // 必要であれば、継承したクラスでオーバライドする
  public void red(Graphics gra) {
    color = Color.red;
  }

  // メニュー"Color"の"Green"が選択された時に呼び出されるメソッド
  // 必要であれば、継承したクラスでオーバライドする
  public void green(Graphics gra) {
    color = Color.green;
  }

  // メニュー"Color"の"Blue"が選択された時に呼び出されるメソッド
  // 必要であれば、継承したクラスでオーバライドする
  public void blue(Graphics gra) {
    color = Color.blue;
  }

  // メニュー"Filled"の"Yes"が選択された時に呼び出されるメソッド
  // 必要であれば、継承したクラスでオーバライドする
  public void filled(Graphics gra) {
    filled = true;
  }

  // メニュー"Filled"の"No"が選択された時に呼び出されるメソッド
  // 必要であれば、継承したクラスでオーバライドする
  public void notFilled(Graphics gra) {
    filled = false;
  }

  // ボタン"Clear"が押された時に呼び出されるメソッド
  // このメソッドが呼ばれた後、画面が消去される
  // 必要であれば、継承したクラスでオーバライドする
  public void clear(Graphics gra) {  // 全ての図形を消去
    for (int i=0; i < numOfShape; i++) {
      shape[i] = null;
    }
    numOfShape = 0;
  }

  // ボタン"Exit"が押された時に呼び出されるメソッド
  // このメソッドが呼ばれた後、ウィンドウを消去し、プログラムを終了する
  // 必要であれば、継承したクラスでオーバライドする
  public void terminate(Graphics gra) {
  }

  // マウスキーが押された時に呼び出されるメソッド
  // 押された時点の座標が引数で渡される
  // 必要であれば、継承したクラスでオーバライドする
  public void mousePressed(int x, int y, Graphics gra) {
    xPressed = x;
    yPressed = y;
  }

  // マウスキーが離された時に呼び出されるメソッド
  // 離された時点の座標が引数で渡される
  // 必要であれば、継承したクラスでオーバライドする
  public void mouseReleased(int xx, int yy, Graphics gra) {
    xReleased = xx;
    yReleased = yy;
  }

  // マウスがドラッグされた時に呼び出されるメソッド
  // その時点の座標が第１引数、第２引数で渡される
  // ウィンドウの背景色が最後の引数で渡される
  // 必要であれば、継承したクラスでオーバライドする
  public void mouseDragged(int xx, int yy, Graphics gra, Color c) {
    xDragged = xx;
    yDragged = yy;
  }

  // 全ての図形を再描画するメソッド
  // ウィンドウが別のウィンドウに隠されて、再び現れた時などに呼び出される
  // 必要であれば、継承したクラスでオーバライドする
  public void redrawAll(Graphics gra) {
    for (int i=0; i < numOfShape; i++) {
      shape[i].draw(gra);
    }
  }

}
