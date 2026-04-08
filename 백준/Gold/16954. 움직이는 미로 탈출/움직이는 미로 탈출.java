import java.io.*;
import java.util.*;

public class Main {
  static int ans;
  static StringBuilder[] graph;
  static int[] dx= {0,0,1,-1,1,1,-1,-1,0}; static int[] dy= {1,-1,0,0,1,-1,1,-1,0};
  static class Node {
    int y, x, time;
    Node(int y, int x, int time){
      this.y=y; this.x=x; this.time=time;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    //8*8 좌하->우상, 1초마다 벽# 1하, 상하좌우대그
    graph= new StringBuilder[8];

    for (int i = 0; i < 8; i++) {
      String brs= br.readLine();
      graph[i]= new StringBuilder();
      graph[i].append(brs);
    }

    bfs();
    System.out.println(ans);
  }

  static void bfs() {
    Queue<Node> q= new LinkedList<>();

    q.offer(new Node(7,0,0));
    while (!q.isEmpty()) {
      Node cur=q.poll();
      // System.out.println(cur.y+" "+cur.x);
      
      if (cur.time>=8) { //벽 사라짐
        ans=1; return;
      }

      if (cur.y==0 && cur.x==7) {
        ans=1; return;
      }
      
      for (int i = 0; i < 9; i++) {
        int nxtY= cur.y+dy[i]; int nxtX= cur.x+dx[i]; int nxtT= cur.time+1;

        if (nxtY>=0 && nxtY<8 && nxtX>=0 && nxtX<8) {
          if ((nxtY-cur.time<0 || graph[nxtY-cur.time].charAt(nxtX)=='.') && (nxtY-nxtT<0 || graph[nxtY-nxtT].charAt(nxtX)=='.')) {
            q.offer(new Node(nxtY,nxtX,nxtT));
          }
        }

      }
    }
  }

}