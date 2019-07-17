// Scalable.java

// 拡大縮小のためのインタフェース
public  interface Scalable {

  // 図形をＸ方向に拡大・縮小するメソッド
  public void scaleX(double xratio);

  // 図形をＹ方向に拡大・縮小するメソッド
  public void scaleY(double yratio);

  // 図形を指定座標まで拡大・縮小するメソッド
  public void scaleTo(int xs, int ys);

}
