// GEFrame.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// 図形エディタ用フレーム
public class GEFrame extends GPFrame {

  static final int width = 900;
  static final int height = 600;

  static  String[] strShEd = {"Line", "Rectangle", "Oval", "Edit"};
                                     // 図形およびモード選択メニュー用の文字列
  static  String[] strEdit = {"Deselect", "Delete", "Move", "Scale"};
                                              // 編集ボタン用の文字列

  JButton[] bte = new JButton[strEdit.length];  // 編集ボタン

  // コンストラクタ
  public GEFrame(String title, String fileName, GraphicEditor ged) {
    super(title);            // スーパクラスのコンストラクタ呼び出し
    initGUI(width, height);  // GUIの初期化
    gra = getGraphics();     // Graphicsオブジェクト記憶
    ge = ged;                // 図形エディタの参照記憶
    System.out.println("GraphicEditorのメソッド init() を呼び出します。");
    if (ge.init(fileName, gra)) {      // 図形エディタの初期化
      System.out.println("GraphicEditorのメソッド init() の処理を終了しました。");
      repaint();    // 再描画
    } else {
      System.out.println("初期化に失敗しましたので、終了します。");
      dispose();       // フレームを消す
      System.exit(0);  // 終了
    }
  }

  // メニューとボタンを作成する
  void createMenus(Container cp) {
    createMenu4Shape(cp);
    createMenu4Color(cp);
    createMenu4Filled(cp);
    createButtons4Edit(cp);
    createButtons(cp);
  }


  // 図形の種類およびモード変更のメニュー
  void createMenu4Shape(Container cp) {
    JPanel pn1 = new JPanel();                       // パネル生成
    pn1.setLayout(new FlowLayout(FlowLayout.LEFT));  // 左から並べるレイアウト

    JLabel lb1 = new JLabel(labelStr[0]);  // "Shape"ラベルの生成
    lb1.setForeground(Color.black);        // ラベルの文字色を黒とする
    pn1.add(lb1);                          // パネルにラベルを付加

    cb1 = new JComboBox<String>();        // コンボボックス生成
    cb1.setEditable(false);               // コンボボックスの編集は不可とする
    for (int i=0; i<strShEd.length; i++) {   // 図形メニュー項目数分繰り返し
      cb1.addItem(strShEd[i]);               // 図形メニュー項目追加
    }
    cb1.addActionListener(this);  // コンボボックスにリスナ(アクション監視)付加
    pn1.add(cb1);                 // パネルにコンボボックスを付加
    cp.add(pn1);                  // コンテナにパネル追加
  }

  // 編集ボタン
  void createButtons4Edit(Container cp) {
    JPanel pn6 = new JPanel();                       // パネル生成
    pn6.setLayout(new FlowLayout(FlowLayout.LEFT));  // 左から並べるレイアウト
    for (int i=0; i<strEdit.length; i++) {  // ボタン数分繰り返し
      bte[i] = new JButton(strEdit[i]);  // ボタン生成
      bte[i].addActionListener(this);    // ボタンにリスナ（アクション監視)付加
      pn6.add(bte[i]);                   // set the string of the item
    }
    cp.add(pn6);                         // コンテナにパネル追加
  }

  // アクションが発生した（メニューが選択された、ボタンが押された）場合の処理
  public void actionPerformed(ActionEvent evt) {

    super.actionPerformed(evt);

    if (evt.getSource() == bte[0]) {   // 選択解除ボタンが押された場合は
      System.out.println("ボタン Deselect が押されました。");
      System.out.println("GraphicEditorのメソッド deselect() を呼び出します。");
      ((GEdit)ge).deselect(gra);  // 図形エディタのメソッド deselect() 呼び出し
      System.out.println("GraphicEditorのメソッド deselect() の処理を終了しました。");
    }

    if (evt.getSource() == bte[1]) {   // 削除ボタンが押された場合は
      System.out.println("ボタン Delete が押されました。");
      System.out.println("GraphicEditorのメソッド delete() を呼び出します。");
      ((GEdit)ge).delete(gra);  // 図形エディタのメソッド delete() 呼び出し
      System.out.println("GraphicEditorのメソッド delete() の処理を終了しました。");
    }

    if (evt.getSource() == bte[2]) {   // 移動ボタンが押された場合は
      System.out.println("ボタン Move が押されました。");
      System.out.println("GraphicEditorのメソッド move() を呼び出します。");
      ((GEdit)ge).move(gra);
      System.out.println("GraphicEditorのメソッド move() の処理を終了しました。");
    }

    if (evt.getSource() == bte[3]) {   // 拡大縮小ボタンが押された場合は
      System.out.println("ボタン Scale が押されました。");
      System.out.println("GraphicEditorのメソッド scale() を呼び出します。");
      ((GEdit)ge).scale(gra);  // 図形エディタのメソッド scale() 呼び出し
      System.out.println("GraphicEditorのメソッド scale() の処理を終了しました。");
    }

    repaint();    // 再描画
  }

  // 図形の種類とモード選択のメニューが選択された場合に呼ばれるメソッド
  void shapeOperation() {
    String selStr;  // 選択された文字列記憶用変数

    repaint();  // 再描画（プルダウンメニューで図形が消えることがあるので)
    selStr = (String)cb1.getSelectedItem();  // 選択された項目の文字列を得る

    if (selStr == strShEd[0]) {  // 選択された文字列が"Line"であれば
      System.out.println("Shapeメニューの Line が選択されました。");
      System.out.println("GraphicEditorのメソッド line() を呼び出します。");
      ge.line(gra);  // グラフィックエディタのメソッド line() 呼び出し
      System.out.println("GraphicEditorのメソッド line() の処理を終了しました。");
    } else if (selStr == strShEd[1]) {  // 選択された文字列が"Rectangle"であれば
      System.out.println("Shapeメニューの Rectangle が選択されました。");
      System.out.println("GraphicEditorのメソッド rectangle() を呼び出します。");
      ge.rectangle(gra);  // グラフィックエディタのメソッド rectangle() 呼び出し
      System.out.println("GraphicEditorのメソッド rectangle() の処理を終了しました。");
    } else if (selStr == strShEd[2]) {  // 選択された文字列が"Oval"であれば
      System.out.println("Shapeメニューの Oval が選択されました。");
      System.out.println("GraphicEditorのメソッド oval() を呼び出します。");
      ge.oval(gra);  // グラフィックエディタのメソッド oval() 呼び出し
      System.out.println("GraphicEditorのメソッド oval() の処理を終了しました。");
    } else if (selStr == strShEd[3]) {  // 選択された文字列が"Edit"であれば
      System.out.println("Shapeメニューの Edit が選択されました。");
      System.out.println("GraphicEditorのメソッド edit() を呼び出します。");
      ((GEdit)ge).edit(gra);  // グラフィックエディタのメソッド edit() を呼び出し
      System.out.println("GraphicEditorのメソッド edit() の処理を終了しました。");
    }
  }

  // マウスキーが離された場合の処理
  public void mouseReleased(MouseEvent evt) {
    super.mouseReleased(evt);
    repaint();    // 再描画
  }

  // メインプログラム
  public static void main(String[] args) {
    String fileName = "temp.shape";
    if (args.length <= 1 ) {
      if (args.length == 1) {
        fileName = args[0];
      }
      System.out.println("GraphicEditor のインスタンスを生成します。");
      GraphicEditor ged = new GraphicEditor();  // 図形エディタのインスタンス生成
      System.out.println("GraphicEditor のインスタンスを生成しました。");
      System.out.println("ファイル名は" + fileName + "です。");
      new GEFrame("Graphic Editor", fileName, ged);
                            // 図形エディアのフレームのインスタンス生成
    } else {
      System.out.println("コマンド引数が多すぎます。");
    }
  }

}
