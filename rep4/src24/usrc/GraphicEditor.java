// GraphicEditor.java

import java.awt.Graphics;
import java.awt.Color;

public class GraphicEditor extends PaintTool implements GEdit {
  boolean highlighted = false;
  boolean moveBool = false;
  Color highlightColor = Color.cyan;
  int i;
  int k;
  int l;


  public void edit(Graphics gra) {
    shapeId = -1;
  }

  public void deselect(Graphics gra){
    for(i=0;i<numOfShape;i++){
      shape[i].resetHighlight();
      shape[i].draw(gra);
    }
  }

  // ボタン"Delete"が押された時に呼び出されるメソッド
  // このメソッドが実行された後、画面が消去され、図形が再描画される
  public void delete(Graphics gra){
    if(shapeId == -1){
      for(i=0;i<numOfShape;i++){
        if(shape[i].highlighted){

          shape[i] = null;
          for(k=i;k<numOfShape;k++){
            shape[k] = shape[k+1];
          }
          numOfShape--;
          i = 0;
        }
      }
    }
  }


  // ボタン"Move"が押された時に呼び出されるメソッド
  // このメソッドが実行された後、画面が消去され、図形が再描画される
  public void move(Graphics gra){
    moveBool = true;

  }

  // ボタン"Scale"が押された時に呼び出されるメソッド
  // このメソッドが実行された後、画面が消去され、図形が再描画される
  public void scale(Graphics gra){

  }

  public void mousePressed(int x, int y, Graphics gra) {
      super.mousePressed(x, y, gra);
      if(shapeId == -1){
        for(i=0;i<numOfShape;i++){
          if(shape[i].contains(x,y)) {
            shape[i].highlight();
            shape[i].draw(gra);
          }
          if(shape[i].highlighted && moveBool){
            for(k=i;k<numOfShape;k++){
              shape[k].moveTo(x, y);
              shape[k].draw(gra);
              deselect(gra);
              shape[k].draw(gra);

          }
        }




        }
      }
  }








}
