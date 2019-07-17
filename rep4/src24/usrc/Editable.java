// Editable.java

// 図形の編集のためのインタフェース
public interface Editable {

  // 図形を移動するメソッド（引数は移動量）
  public void move(int dx, int dy);

  // 図形を移動するメソッド（引数は移動先座標）
  public void moveTo(int xd, int yd);

  // 図形をハイライト表示に設定するメソッド
  public void highlight();

  // ハイライト表示の設定を解除するメソッド
  public void resetHighlight();

  // 図形が指定座標を含むかどうかを示すメソッド
  public boolean contains(int xs, int ys);

}
