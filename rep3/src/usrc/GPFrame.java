// GPFrame.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// ペイントツール用フレーム（ウィンドウ）
public class GPFrame extends JFrame 
             implements ActionListener, MouseListener, MouseMotionListener{

  static final int width = 800;   // ウィンドウの幅
  static final int height = 600;  // ウィンドウの高さ

  static  String[] labelStr = {"Shape", "Color", "Filled"};
                                              // 図形描画用ラベルの文字列
  static  String[] strShape = {"Line", "Rectangle", "Oval"};
                                              // 図形メニュー用の文字列
  static  String[] strColor = {"Black", "Red", "Green", "Blue"};
                                              // 色メニュー用の文字列
  static  String[] strFill = {"No", "Yes"};   // 塗りつぶしメニュー用の文字列

  static  String[] strClEx = {"Clear", "Exit"};  // 消去・終了ボタン用の文字列


  JComboBox<String> cb1, cb2, cb3;     // メニューやボタン用のコンボボックス

  JButton[] bt = new JButton[strClEx.length];  // 消去・終了ボタン

  Graphics gra;          // Graphicsオブジェクト

  int xPressed = 50;     // マウスキーを押したＸ座標
  int yPressed = 50;     // マウスキーを押したＹ座標
  int xReleased = 100;   // マウスキーを離したＸ座標
  int yReleased = 100;   // マウスキーを離したＹ座標
  int xDragged = 60;     // マウスをドラッグしたＸ座標
  int yDragged = 60;     // マウスをドラッグしたＹ座標

  PaintPrototype ge;              // ペイントツール

  // コンストラクタ、引数：タイトル
  public GPFrame(String title) {
    super(title);            // スーパクラスのコンストラクタ呼び出し
  }


  // コンストラクタ、第１引数：タイトル、第２引数：ペイントツールの参照
  public GPFrame(String title, PaintPrototype gp) {
    super(title);            // スーパクラスのコンストラクタ呼び出し
    initGUI(width, height);  //  GUIの初期化
    gra = getGraphics();     // Graphicsオブジェクト記憶
    ge = gp;                 // ペイントツールの参照記憶
    System.out.println("ペイントツールのメソッド init() を呼び出します。");
    ge.init(gra);            // ペイントツールの初期化
    System.out.println("ペイントツールのメソッド init() を呼び出しました。");
  }

  // GUIの初期化
  void initGUI(int width, int height) {
    setSize(width, height);          // フレームの幅と高さを設定する
    setBackground(Color.white);      // 背景色を白とする
    Container cp = getContentPane();                // コンテナ設定
    cp.setBackground(getBackground());              // コンテナの背景設定
    cp.setLayout(new FlowLayout(FlowLayout.LEFT));  // 左側から並べるレイアウト

    createMenus(cp);  // メニューやボタンの生成

    addMouseListener(this);        // マウスリスナー（アクション監視）付加
    addMouseMotionListener(this);  // マウス動作リスナー（移動監視）付加
    setVisible(true);        // 見えるようにする
  }

  // メニューとボタンを作成する
  void createMenus(Container cp) {
    createMenu4Shape(cp);
    createMenu4Color(cp);
    createMenu4Filled(cp);
    createButtons(cp);
  }

  // 図形の種類のメニュー
  void createMenu4Shape(Container cp) {
    JPanel pn1 = new JPanel();                       // パネル生成
    pn1.setLayout(new FlowLayout(FlowLayout.LEFT));  // 左から並べるレイアウト

    JLabel lb1 = new JLabel(labelStr[0]);  // "Shape"ラベルの生成
    lb1.setForeground(Color.black);        // ラベルの文字色を黒とする
    pn1.add(lb1);                          // パネルにラベルを付加

    cb1 = new JComboBox<String>();                // コンボボックス生成
    cb1.setEditable(false);               // コンボボックスの編集は不可とする
    for (int i=0; i<strShape.length; i++) {   // 図形メニュー項目数分繰り返し
      cb1.addItem(strShape[i]);               // 図形メニュー項目追加
    }
    cb1.addActionListener(this);  // コンボボックスにリスナ(アクション監視)付加
    pn1.add(cb1);                 // パネルにコンボボックスを付加
    cp.add(pn1);                  // コンテナにパネル追加
  }
    

  // 図形の色のメニュー
  void createMenu4Color(Container cp) {
    JPanel pn2 = new JPanel();                       // パネル生成
    pn2.setLayout(new FlowLayout(FlowLayout.LEFT));  // 左から並べるレイアウト

    JLabel lb2 = new JLabel(labelStr[1]);  // "Color"ラベルの生成
    lb2.setForeground(Color.black);        // ラベルの文字色を黒とする
    pn2.add(lb2);                          // パネルにラベルを付加

    cb2 = new JComboBox<String>();                // コンボボックス生成
    cb2.setEditable(false);               // コンボボックスの編集は不可とする
    for (int i=0; i<strColor.length; i++) {   // 色メニュー項目数分繰り返し
      cb2.addItem(strColor[i]);               // 色メニュー項目追加
    }

    cb2.addActionListener(this);  // コンボボックスにリスナ(アクション監視)付加
    pn2.add(cb2);                 // パネルにコンボボックスを付加
    cp.add(pn2);                  // コンテナにパネル追加
  }

    
  // 塗りつぶしのメニュー
  void createMenu4Filled(Container cp) {
    JPanel pn3 = new JPanel();                       // パネル生成
    pn3.setLayout(new FlowLayout(FlowLayout.LEFT));  // 左から並べるレイアウト

    JLabel lb3 = new JLabel(labelStr[2]);  // "Filled"ラベルの生成
    lb3.setForeground(Color.black);        // ラベルの文字色を黒とする
    pn3.add(lb3);                          // パネルにラベルを付加

    cb3 = new JComboBox<String>();                // コンボボックス生成
    cb3.setEditable(false);               // コンボボックスの編集は不可とする
    for (int i=0; i<strFill.length; i++) {   // 塗りつぶしメニュー項目数分繰り返し
      cb3.addItem(strFill[i]);               // 塗りつぶしメニュー項目追加
    }

    cb3.addActionListener(this);  // コンボボックスにリスナ(アクション監視)付加
    pn3.add(cb3);                 // パネルにコンボボックスを付加
    cp.add(pn3);                  // コンテナにパネル追加
  }

    
  // 消去・終了ボタン
  void createButtons(Container cp) {
    JPanel pn4 = new JPanel();                       // パネル生成
    pn4.setLayout(new FlowLayout(FlowLayout.LEFT));  // 左から並べるレイアウト
    for (int i=0; i<strClEx.length; i++) {  // ボタン数分繰り返し
      bt[i] = new JButton(strClEx[i]);      // ボタン生成
      bt[i].addActionListener(this);     // ボタンにリスナ（アクション監視)付加
      pn4.add(bt[i]);                    // パネルにボタン追加
    }
    cp.add(pn4);                         // コンテナにパネル追加
  }



  // アクションが発生した（メニューが選択された、ボタンが押された）場合の処理
  public void actionPerformed(ActionEvent evt) {

    if (evt.getSource() == cb1) {   // 図形の種類のメニューが選択された場合は
      shapeOperation();
    }

    if (evt.getSource() == cb2) {   // 図形の色のメニューが選択された場合は
      colorOperation();
    }

    if (evt.getSource() == cb3) {   // 塗りつぶしのメニューが選択された場合は
      filledOperation();
    }

    if (evt.getSource() == bt[0]) {   // 全図形消去ボタンが押された場合は
      System.out.println("ボタン Clear が押されました。");
      System.out.println("PaintToolのメソッド clear() を呼び出します。");
      ge.clear(gra);  // ペイントツールのメソッド clear() 呼び出し
      System.out.println("PaintToolのメソッド clear() の処理を終了しました。");
      repaint();      // 画面をクリアして再描画
    }

    if (evt.getSource() == bt[1]) {   // 終了ボタンが押された場合は
      System.out.println("ボタン Exit が押されました。");
      System.out.println("PaintToolのメソッド terminate() を呼び出します。");
      ge.terminate(gra);  // ペイントツールのメソッド terminate() 呼び出し
      System.out.println("PaintToolのメソッド terminate() の処理を終了しました。");
      dispose();       // フレームを消す
      System.exit(0);  // 終了
    }

  }


  // 図形の種類のメニューが選択された場合に呼ばれるメソッド
  void shapeOperation() {
    String selStr;  // 選択された文字列記憶用変数

    repaint();  // 再描画（プルダウンメニューで図形が消えることがあるので)
    selStr = (String)cb1.getSelectedItem();  // 選択された項目の文字列を得る
    if (selStr == strShape[0]) {  // 選択された文字列が"Line"であれば
      System.out.println("Shapeメニューの Line が選択されました。");
      System.out.println("PaintToolのメソッド line() を呼び出します。");
      ge.line(gra);  // ペイントツールのメソッド line() 呼び出し
      System.out.println("PaintToolのメソッド line() の処理を終了しました。");
    } else if (selStr == strShape[1]) {  // 選択された文字列が"Rectangle"であれば
      System.out.println("Shapeメニューの Rectangle が選択されました。");
      System.out.println("PaintToolのメソッド rectangle() を呼び出します。");
      ge.rectangle(gra);  // ペイントツールのメソッド rectangle() 呼び出し
      System.out.println("PaintToolのメソッド rectangle() の処理を終了しました。");
    } else if (selStr == strShape[2]) {  // 選択された文字列が"Oval"であれば
      System.out.println("Shapeメニューの Oval が選択されました。");
      System.out.println("PaintToolのメソッド oval() を呼び出します。");
      ge.oval(gra);  // ペイントツールのメソッド oval() 呼び出し
      System.out.println("PaintToolのメソッド oval() の処理を終了しました。");
    }
  }

  // 図形の色のメニューが選択された場合に呼び出されるメソッド
  void colorOperation() {
    String selStr;  // 選択された文字列記憶用変数

    repaint();  // 再描画（プルダウンメニューで図形が消えることがあるので)
    selStr = (String)cb2.getSelectedItem();  // 選択された項目の文字列を得る
    if (selStr == strColor[0]) {  // 選択された文字列が"Black"であれば
      System.out.println("Colorメニューの Black が選択されました。");
      System.out.println("PaintToolのメソッド black() を呼び出します。");
      ge.black(gra);  // ペイントツールのメソッド black() 呼び出し
      System.out.println("PaintToolのメソッド black() の処理を終了しました。");
    } else if (selStr == strColor[1]) {  // 選択された文字列が"Red"であれば
      System.out.println("Colorメニューの Red が選択されました。");
      System.out.println("PaintToolのメソッド red() を呼び出します。");
      ge.red(gra);  // ペイントツールのメソッド red() 呼び出し
      System.out.println("PaintToolのメソッド red() の処理を終了しました。");
    } else if (selStr == strColor[2]) {  // 選択された文字列が"Green"であれば
      System.out.println("Colorメニューの Green が選択されました。");
      System.out.println("PaintToolのメソッド green() を呼び出します。");
      ge.green(gra);  // ペイントツールのメソッド green() 呼び出し
      System.out.println("PaintToolのメソッド green() の処理を終了しました。");
    } else { if (selStr == strColor[3])  // 選択された文字列が"Blue"であれば
      System.out.println("Colorメニューの Blue が選択されました。");
      System.out.println("PaintToolのメソッド blue() を呼び出します。");
      ge.blue(gra);  // ペイントツールのメソッド blue() 呼び出し
      System.out.println("PaintToolのメソッド blue() の処理を終了しました。");
    }
  }

  // 塗りつぶしのメニューが選択された場合に呼び出されるメソッド
  void filledOperation() {
    String selStr;  // 選択された文字列記憶用変数
    
    repaint();  // 再描画（プルダウンメニューで図形が消えることがあるので)
    selStr = (String)cb3.getSelectedItem();  // 選択された項目の文字列を得る
    if (selStr == strFill[0]) {  // 選択された文字列が"No"であれば
      System.out.println("Filledメニューの No が選択されました。");
      System.out.println("PaintToolのメソッド notFilled() を呼び出します。");
      ge.notFilled(gra);  // ペイントツールのメソッド notFilled() 呼び出し
      System.out.println("PaintToolのメソッド notFilled() の処理を終了しました。");
    } else if (selStr == strFill[1]) {  // 選択された文字列が"Yes"であれば
      System.out.println("Filledメニューの Yes が選択されました。");
      System.out.println("PaintToolのメソッド filled() を呼び出します。");
      ge.filled(gra);  // ペイントツールのメソッド filled() 呼び出し
      System.out.println("PaintToolのメソッド filled() の処理を終了しました。");
    }
  }
    
  // マウスキーが押された場合の処理
  public void mousePressed(MouseEvent evt) {
    xPressed = evt.getX();  // イベントが発生したところのＸ座標を記憶
    yPressed = evt.getY();  // イベントが発生したところのＹ座標を記憶
    System.out.println("マウスキーが押されました。座標は ("
                        + xPressed + ", " + yPressed + ") です。");
    System.out.println("PaintToolのメソッド mousePressed() を呼び出します。");
    ge.mousePressed(xPressed, yPressed, gra);
                    // ペイントツールのメソッド mousePressed() 呼び出し
    System.out.println("PaintToolのメソッド mousePressed() の処理を終了しました。");
  }

  // マウスキーが離された場合の処理
  public void mouseReleased(MouseEvent evt) {
    xReleased = evt.getX();  // イベントが発生したところのＸ座標を記憶
    yReleased = evt.getY();  // イベントが発生したところのＹ座標を記憶
    System.out.println("マウスキーが離されました。座標は ("
                        + xReleased + ", " + yReleased + ") です。");
    System.out.println("PaintToolのメソッド mouseReleased() を呼び出します。");
    ge.mouseReleased(xReleased, yReleased, gra);
                     // ペイントツールのメソッド mouseReleased() 呼び出し
    System.out.println("PaintToolのメソッド mouseReleased() の処理を終了しました。");
  }

  // マウスキーがクリックされた場合の処理
  public void mouseClicked(MouseEvent evt) {
  }

  // マウスが領域内に入った場合の処理
  public void mouseEntered(MouseEvent evt) {
  }

  // マウスが領域外に出た場合の処理
  public void mouseExited(MouseEvent evt) {
  }

  // マウスがドラッグ（キーを押して移動)された場合の処理
  public void mouseDragged(MouseEvent evt) {
    xDragged = evt.getX();  // イベントが発生したところのＸ座標を記憶
    yDragged = evt.getY();  // イベントが発生したところのＹ座標を記憶
    System.out.println("マウスがドラッグされました。座標は ("
                        + xDragged + ", " + yDragged + ") です。");
    System.out.println("PaintToolのメソッド mouseDragged() を呼び出します。");
    ge.mouseDragged(xDragged, yDragged, gra, getBackground());
      // ペイントツールのメソッド mouseDragged() 呼び出し（最後の引数は背景色）
    System.out.println("PaintToolのメソッド mouseDragged() の処理を終了しました。");
  }

  // マウスが移動した場合の処理
  public void mouseMoved(MouseEvent evt) {
  }

  // フレームを復元（再描画）する処理
  public void paint(Graphics g) {
    super.paint(g);    // スーパークラス（JFrame）の paint() 呼び出し
    if (ge != null) {  // ペイントツールがあれば
      System.out.println("PaintToolのメソッド redrawAll() を呼び出します。");
      ge.redrawAll(g);  // ペイントツールのメソッド redrawAll() 呼び出し
      System.out.println("PaintToolのメソッド redrawAll() の処理を終了しました。");
    }
  }

  // メインプログラム
  public static void main(String[] args) {
    System.out.println("PaintTool のインスタンスを生成します。");
    PaintPrototype gp = new PaintTool();  // ペイントツールのインスタンス生成
    System.out.println("PaintTool のインスタンスを生成しました。");
    new GPFrame("Paint Tool", gp);  // ペイントツール用フレームのインスタンス生成
  }

}
