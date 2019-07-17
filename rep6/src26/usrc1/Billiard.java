// Billiard.java

import java.io.*;          // 入出力（IO）に関するクラスを利用する
import java.awt.Graphics;  // クラスGraphicsを利用する
import java.awt.Color;     // クラスColorを利用する

public class Billiard implements BilIF {  // ビリヤードのクラス
                                          // ビリヤードインタフェースを継承
  Table table;  // ビリヤード台のインスタンスの参照
  Ball ball;    // 玉のインスタンスの参照

  // メインプログラム
  public static void main(String[] args) {
    String inStr;  // 入力文字列記憶用
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                                                               // 文字列入力
    try{
      System.out.print("ビリヤード台の横方向の大きさは？ ");
      inStr = in.readLine();              // 文字列入力
      int m = Integer.parseInt(inStr);    // 文字列を整数に変換
      System.out.print("ビリヤード台の縦方向の大きさは？ ");
      inStr = in.readLine();              // 文字列入力
      int n = Integer.parseInt(inStr);    // 文字列を整数に変換
      Billiard bil = new Billiard(m, n);  // ビリヤードのインスタンス生成
      new BilFrame("Billiard", 200 + m, 200 + n, bil);
                    // ビリヤード用フレーム(ウィンドウ)のインスタンス生成
                    // 画面サイズはビリヤード台より上下左右100ずつ大きくする
    } catch(IOException e) {            // IO例外が発生した場合
      System.out.println(e.getMessage());
      System.out.println("もう一度やりなおしてください。");
    } catch(NumberFormatException e) {  // 数字フォーマット例外が発生した場合
      System.out.println(e.getMessage());
      System.out.println("もう一度やりなおしてください。");
    }
  }

  // コンストラクタ  
  public Billiard(int xmax, int ymax) {  // 引数はテーブルのサイズ
    table = new Table (xmax, ymax);  // ビリヤード台のインスタンス生成
    ball = new Ball(table, 0, 0);    // 玉のインスタンス生成(位置は左上端)
  }

  // ゲームの処理
  public void start(Graphics g) {
    ball.go(1, 1, g);    // 玉を初速度(1, 1)で転がす
    System.out.println("玉がポケット(" + ball.getX() + ", "
                               + ball.getY() + ")に落ちました。");
    System.out.println("壁に" + ball.getCount() + "回ぶつかりました。");
  }

  // ビリヤードを表示するメソッド
  public void draw(Graphics g) {  // 引数はGraphicsオブジェクト
    table.draw(g);      // ビリヤード台を表示する
    ball.draw(g);       // 玉を表示する
  }

  // ビリヤードをリセットするメソッド
  public void reset() {
    ball.reset();       // 玉をリセットする
  }

}
