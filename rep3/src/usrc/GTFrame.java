// GTFrame.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// 図形編集テスト用フレーム
public class GTFrame extends GPFrame {

  static final int width = 900;
  static final int height = 600;

  static  String[] strTest = {"Move", "MoveTo", "ScaleX", "ScaleY", "ScaleTo", "HL", "SelHL", "ResetHL"};
                                              // 編集テストボタン用の文字列

  JButton[] btt = new JButton[strTest.length];  // 編集テストボタン

  public GTFrame(String title, EditTest etest) {    // コンストラクタ
    super(title);            // スーパクラスのコンストラクタ呼び出し
    initGUI(width, height);  // GUIの初期化
    gra = getGraphics();     // Graphicsオブジェクト記憶
    ge = etest;              // テストプログラムの参照記憶
    ge.init(gra);            // テストプログラムの初期化
  }

  // メニューとボタンを作成する
  void createMenus(Container cp) {
    createMenu4Shape(cp);
    createMenu4Color(cp);
    createMenu4Filled(cp);
    createButtons4Test(cp);
    createButtons(cp);
  }

  // 編集テストボタン
  void createButtons4Test(Container cp) {
    JPanel pn5 = new JPanel();                       // パネル生成
    pn5.setLayout(new FlowLayout(FlowLayout.LEFT));  // 左から並べるレイアウト
    for (int i=0; i<strTest.length; i++) {  // ボタン数分繰り返し
      btt[i] = new JButton(strTest[i]);     // ボタン生成
      btt[i].addActionListener(this);    // ボタンにリスナ（アクション監視)付加
      pn5.add(btt[i]);                   // パネルにボタン追加
    }
    cp.add(pn5);                         // コンテナにパネル追加
  }


  // アクションが発生した（メニューが選択された、ボタンが押された）場合の処理
  public void actionPerformed(ActionEvent evt) {

    super.actionPerformed(evt);

    if (evt.getSource() == btt[0]) {   // 移動テストボタンが押された場合は
      System.out.println("ボタン Move が押されました。");
      System.out.println("EditTestのメソッド moveAll() を呼び出します。");
      ((EditTest)ge).move(gra);  // テストプログラムのメソッド move() 呼び出し
      System.out.println("EditTestのメソッド move() の処理を終了しました。");
      repaint();    // 再描画
    }

    if (evt.getSource() == btt[1]) {   // 座標指定移動テストボタンが押された場合は
      System.out.println("ボタン MoveTo が押されました。");
      System.out.println("EditTestのメソッド moveTo() を呼び出します。");
      ((EditTest)ge).moveTo(gra); // テストプログラムのメソッド moveTo() 呼び出し
      System.out.println("EditTestのメソッド moveAll() の処理を終了しました。");
      repaint();    // 再描画
    }

    if (evt.getSource() == btt[2]) { // Ｘ方向拡大縮小テストボタンが押された場合は
      System.out.println("ボタン ScaleX が押されました。");
      System.out.println("EditTestのメソッド scaleX() を呼び出します。");
      ((EditTest)ge).scaleX(gra); // テストプログラムのメソッド scaleX() 呼び出し
      System.out.println("EditTestのメソッド scaleX() の処理を終了しました。");
      repaint();    // 再描画
    }

    if (evt.getSource() == btt[3]) { // Ｙ方向拡大縮小テストボタンが押された場合は
      System.out.println("ボタン ScaleY が押されました。");
      System.out.println("EditTestのメソッド scaleY() を呼び出します。");
      ((EditTest)ge).scaleY(gra); // テストプログラムのメソッド scaleY() 呼び出し
      System.out.println("EditTestのメソッド scaleY() の処理を終了しました。");
      repaint();    // 再描画
    }

    if (evt.getSource() == btt[4]) { // 座標指定拡大縮小テストボタンが押された場合は
      System.out.println("ボタン ScaleTo が押されました。");
      System.out.println("EditTestのメソッド scaleTo() を呼び出します。");
      ((EditTest)ge).scaleTo(gra);
                         // テストプログラムのメソッド scaleTo() 呼び出し
      System.out.println("EditTestのメソッド scaleTo() の処理を終了しました。");
      repaint();    // 再描画
    }

    if (evt.getSource() == btt[5]) {  // ハイライトテストボタンが押された場合は
      System.out.println("ボタン HL が押されました。");
      System.out.println("EditTestのメソッド highlight() を呼び出します。");
      ((EditTest)ge).highlight();
                         // テストプログラムのメソッド highlight() 呼び出し
      System.out.println("EditTestのメソッド highlight() の処理を終了しました。");
      repaint();    // 再描画
    }

    if (evt.getSource() == btt[6]) {  // 選択ハイライトテストボタンが押された場合は
      System.out.println("ボタン SelHL が押されました。");
      System.out.println("EditTestのメソッド selectHighlight() を呼び出します。");
      ((EditTest)ge).selectHighlight();
                         // テストプログラムのメソッド selectHighlight() 呼び出し
      System.out.println("EditTestのメソッド selectHighlight() の処理を終了しました。");
    }

    if (evt.getSource() == btt[7]) {  // ハイライト解除テストボタンが押された場合は
      System.out.println("ボタン ResetHL が押されました。");
      System.out.println("EditTestのメソッド resetHighlight() を呼び出します。");
      ((EditTest)ge).resetHighlight();
                          // テストプログラムのメソッド resetHighlight() 呼び出し
      System.out.println("EditTestのメソッド resetHighlight() の処理を終了しました。");
      repaint();    // 再描画
    }

  }

  // マウスキーが離された場合の処理
  public void mouseReleased(MouseEvent evt) {
    super.mouseReleased(evt);
    repaint();    // 再描画
  }

  // メインプログラム
  public static void main(String[] args) {
    System.out.println("EditTest のインスタンスを生成します。");
    EditTest et = new EditTest();  // 編集テストプログラムのインスタンス生成
    System.out.println("EditTest のインスタンスを生成しました。");
    new GTFrame("Edit Tseting", et);
                          // 編集テストプログラムのフレームのインスタンス生成
  }

}
