// BilFrame.java

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// ビリヤード用フレーム（ウィンドウ)
public class BilFrame extends JFrame implements ActionListener {
  String[] str = {"Draw", "Start", "Reset", "Exit"}; // ボタン用文字列の配列
  JButton[] bt = new JButton[str.length];   // ボタンの配列
  Graphics gra;  // Graphicsオブジェクト
  BilIF bil;     // ビリヤードオブジェクト（型はビリヤード用インタフェース)

  // コンストラクタ、第１引数：タイトル、第２引数：幅、第３引数：高さ
  //                 第４引数：ビリヤードオブジェクト
  public BilFrame(String title, int width, int height,   BilIF b) {  
    super(title);                       // スーパクラスのコンストラクタ呼び出し
    setSize(width, height);             // サイズ設定
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
    gra = getGraphics();    // Graphicオブジェクト記憶
    bil = b;                // ビリヤード記憶
  }

  // アクション発生時の処理、引数は発生したイベント
  public void actionPerformed(ActionEvent evt) {
    if (evt.getSource() == bt[0]) {  // イベントが"Draw"ボタンならば
      System.out.println("Billiardのメソッド draw() を呼び出します。");
      bil.draw(gra);     // ビリヤードオブジェクトのメソッドdraw()呼び出し
      System.out.println("Billiardのメソッド draw() を終了しました。");
    }
    if (evt.getSource() == bt[1]) {  // イベントが"Start"ボタンならば
      System.out.println("Billiardのメソッド start() を呼び出します。\n");
      bil.start(gra);    // ビリヤードオブジェクトのメソッドstart()呼び出し
      System.out.println("\nBilliardのメソッド start() を終了しました。");
    }
    if (evt.getSource() == bt[2]) {  // イベントが"Reset"ボタンならば
      repaint();
      System.out.println("Billiardのメソッド reset() を呼び出します。");
      bil.reset();    // ビリヤードオブジェクトのメソッドreset()呼び出し
      System.out.println("Billiardのメソッド reset() を終了しました。");
    }
    if (evt.getSource() == bt[3]) {  // イベントが"Exit"ボタンならば
      System.out.println("プログラムを終了します。");
      dispose();       // フレームを消す
      System.exit(0);  // 終了
    }
  }

}
