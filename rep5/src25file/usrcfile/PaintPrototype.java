// PaintPrototype.java

import java.awt.Graphics;  // クラスGraphicsを利用する
import java.awt.Color;     // クラスColorを利用する
import java.io.*;          // パッケージjava.io.*を利用する

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
  Shape[] shape;                  // 作成した図形の参照を格納する配列
  int numOfShape = 0;             // 作成した図形の数
  String fileName;                // 作成した図形を保存するファイル名

  // 初期化メソッド１ // インスタンス生成後に呼び出される
  // 必要であれば、継承したクラスでオーバライドする
  public void init(Graphics gra) {
  }

  // 初期化メソッド２
  // インスタンス生成後に呼び出される
  // 必要であれば、継承したクラスでオーバライドする
  public boolean init(String fn, Graphics gra) {
    fileName = fn;
    try{
      FileInputStream fileIn = new FileInputStream(fileName);
      ObjectInputStream oin = new ObjectInputStream(fileIn);
      shape = (Shape[])oin.readObject();
      while ((numOfShape < shape.length) &&
        (shape[numOfShape] != null)) {
        numOfShape++;
      }
      System.out.println("ファイル" + fileName + "のデータを読み込みました。");
      return true;
    } catch (FileNotFoundException fe) {
      System.out.println("ファイル" + fileName + "は存在しませんので、新規作成とします。");
      shape= new Shape[256];
      return true;
    } catch (IOException ie) {
      System.out.println(ie.getMessage());
      System.out.println("IO例外が発生したので、終了します。");
      return false;
    } catch (ClassNotFoundException ce) {
      System.out.println(ce.getMessage());
      System.out.println("クラス例外が発生したので、終了します。");
      return false;
    }
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
    try {
      FileOutputStream fileOut = new FileOutputStream(fileName);
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(shape);
    } catch (IOException ie) {
      System.out.println(ie.getMessage());
      System.out.println("IO例外が発生したので、保存せずに終了します。");
    }
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
