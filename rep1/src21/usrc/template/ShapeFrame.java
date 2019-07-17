// ShapeFrame.java

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// 図形描画用フレーム（ウィンドウ)
public class ShapeFrame extends JFrame implements ActionListener {
  String[] str = {"Start", "Exit"};        // ボタン用文字列の配列
  JButton[] bt = new JButton[str.length];  // ボタンの配列
  Graphics gra;                            // Graphicsオブジェクト
  ShapeDrawTest sdt;                       // 図形描画テストオブジェクト

  // コンストラクタ、第１引数：タイトル、第２引数：テストプログラム
  public ShapeFrame(String title, ShapeDrawTest s) {
    super(title);                       // スーパクラスのコンストラクタ呼び出し
    setSize(800, 600);                  // サイズは800X600
    setBackground(Color.white);         // 背景は白
    Container cp = getContentPane();                // コンテナ設定
    cp.setBackground(getBackground());              // コンテナの背景設定
    cp.setLayout(new FlowLayout(FlowLayout.LEFT));  // 左側から並べるレイアウト
    for (int i=0; i<str.length; i++) {  // ボタンの数だけ繰り返し
      bt[i] = new JButton(str[i]);      // ボタンを生成
      bt[i].addActionListener(this);    // ボタンにリスナ（アクション監視)付加
      cp.add(bt[i]);                    // コンテナにボタンを付加
    }
    setVisible(true);       // 見えるようにする
    gra = getGraphics();    // Graphicオブジェクトを取得して記憶
    sdt = s;                // 図形描画テストオブジェクト記憶
  }

  // アクション発生時の処理、引数は発生したイベント
  public void actionPerformed(ActionEvent evt) {
    if (evt.getSource() == bt[0]) {  // イベントが"Start"ボタンならば
      System.out.println("ShapeDrawTest のメソッド start() を呼び出します。");
      sdt.start(gra);  // 図形描画テストオブジェクトのメソッドstart()呼び出し
      System.out.println("ShapeDrawTest のメソッド start() を終了しました。");
    }
    if (evt.getSource() == bt[1]) {  // イベントが"Exit"ボタンならば
      System.out.println("プログラムを終了します。");
      dispose();       // フレームを消す
      System.exit(0);  // 終了
    }
  }

  // メインプログラム
  public static void main(String[] args) {
    System.out.println("ShapeDrawTest のインスタンスを生成します。");
    ShapeDrawTest s = new ShapeDrawTest();
                            // 図形描画テストプログラムのインスタンス生成
    System.out.println("ShapeDrawTest のインスタンスを生成しました。");
    new ShapeFrame("ShapeDrawTest", s);
                            // 図形描画テスト用のフレームのインスタンス生成
  }

}
