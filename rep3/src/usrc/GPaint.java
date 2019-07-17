// GPaint.java

import java.awt.Graphics;  // クラスGraphicsを利用する
import java.awt.Color;     // クラスColorを利用する

// 図形作成ツール用のインタフェース

public interface GPaint {

  // 初期化メソッド
  // インスタンス生成後に呼び出される
  public void init(Graphics gra);

  // メニュー"Shape"の"Line"が選択された時に呼び出されるメソッド
  public void line(Graphics gra);

  // メニュー"Shape"の"Rectangle"が選択された時に呼び出されるメソッド
  public void rectangle(Graphics gra);

  // メニュー"Shape"の"Oval"が選択された時に呼び出されるメソッド
  public void oval(Graphics gra);

  // メニュー"Color"の"Black"が選択された時に呼び出されるメソッド
  public void black(Graphics gra);

  // メニュー"Color"の"Red"が選択された時に呼び出されるメソッド
  public void red(Graphics gra);

  // メニュー"Color"の"Green"が選択された時に呼び出されるメソッド
  public void green(Graphics gra);

  // メニュー"Color"の"Blue"が選択された時に呼び出されるメソッド
  public void blue(Graphics gra);

  // メニュー"Filled"の"Yes"が選択された時に呼び出されるメソッド
  public void filled(Graphics gra);

  // メニュー"Filled"の"No"が選択された時に呼び出されるメソッド
  public void notFilled(Graphics gra);

  // ボタン"Clear"が押された時に呼び出されるメソッド
  // このメソッドが呼ばれた後、画面が消去される
  public void clear(Graphics gra);

  // ボタン"Exit"が押された時に呼び出されるメソッド
  // このメソッドが呼ばれた後、ウィンドウを消去し、プログラムを終了する
  public void terminate(Graphics gra);

  // マウスキーが押された時に呼び出されるメソッド
  // 押された時点の座標が引数で渡される
  public void mousePressed(int x, int y, Graphics gra);

  // マウスキーが離された時に呼び出されるメソッド
  // 離された時点の座標が引数で渡される
  public void mouseReleased(int xx, int yy, Graphics gra);

  // マウスがドラッグされた時に呼び出されるメソッド
  // その時点の座標が第１引数、第２引数で渡される
  // ウィンドウの背景色が最後の引数で渡される
  public void mouseDragged(int xx, int yy, Graphics gra, Color c);

  // 全ての図形を再表示するメソッド
  // 図形編集時やウィンドウやメニューを操作したときに呼び出される
  public void redrawAll(Graphics gra);

}

