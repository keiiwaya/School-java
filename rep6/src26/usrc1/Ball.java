import java.io.*;          // 入出力（IO）に関するクラスを利用する
import java.awt.Graphics;  // クラスGraphicsを利用する
import java.awt.Color;     // クラスColorを利用する

public class Ball extends Billiard{
  int x;
  int y;
  int vx;
  int vy;
  int count = 0;
  int flag = 1;
  public static void main(String[] args) {
  }

  public void getX(){
    return x;
  }
  public void getY(){
    return y;
  }
  public void getCount(){
    return count;
  }

  public void go(int x, int y, Graphics gra){
    //とりあえず壁まですすめる
    //壁にあたったら、count+1する
    //壁の座標が角か判断し角なら終了、否なら続行
    do {
      x += vx;
      y += vy;

      if(x != 0 || x != xmax && y != 0 || y != ymax){
        flag = 1;
      }else{
        flag = 0;
      }

      try {
        Thread.currentThread().sleep(1);
      } catch (InterruptedException e) {
        System.out.println(e.getMessage());
      }
    } while(flag == 1);


    }
  
}
