// BilIF.java

// ビリヤード用フレーム（ウィンドウ）のクラス BilFrame を用いる場合は
// このインタフェースを継承すること

import java.awt.Graphics;  // クラスGraphicsを利用する

public interface BilIF {  // ビリヤードインタフェース

  // ゲームの処理
  public void start(Graphics g);  // 引数はGraphicsオブジェクト

  // ビリヤードを表示するメソッド
  public void draw(Graphics g);  // 引数はGraphicsオブジェクト

  // ビリヤードをリセットするメソッド
  public void reset();

}
