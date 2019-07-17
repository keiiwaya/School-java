// GEdit.java

import java.awt.Graphics;  // クラスGraphicsを利用する
import java.awt.Color;     // クラスColorを利用する

// 図形エディタ用のインタフェース
// ペイントツール"PaintTool"とこのインタフェース"GEdit"を継承して
// 図形エディタのクラス"GraphicEditor"を作成する
// 宣言された各メソッドについて、継承したクラスで処理を記述すること

public interface GEdit extends GPaint{

  // メニュー"Shape"の"Edit"が選択された時に呼び出されるメソッド
  public void edit(Graphics gra);

  // ボタン"Deselect"が押された時に呼び出されるメソッド
  // このメソッドが実行された後、画面が消去され、図形が再描画される
  public void deselect(Graphics gra);

  // ボタン"Delete"が押された時に呼び出されるメソッド
  // このメソッドが実行された後、画面が消去され、図形が再描画される
  public void delete(Graphics gra);

  // ボタン"Move"が押された時に呼び出されるメソッド
  // このメソッドが実行された後、画面が消去され、図形が再描画される
  public void move(Graphics gra);

  // ボタン"Scale"が押された時に呼び出されるメソッド
  // このメソッドが実行された後、画面が消去され、図形が再描画される
  public void scale(Graphics gra);

}
