import java.io.*;
import java.util.*;

public class Main {
  static int n,chk,chkS;
  static StringBuilder[] graph;
  //재방문이 더 cost적을수도
  static int[][][] vis; //영역별로 부여
  static int[] dx= {0,0,-1,1}; static int[] dy= {-1,1,0,0};
  static class Node {
    int y, x; char color; boolean rg;
    Node(int y, int x, char color, boolean rg){//전체수-rg바뀐수
      this.y=y; this.x=x; this.color=color; this.rg=rg;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    n= Integer.valueOf(br.readLine());
    graph= new StringBuilder[n]; vis=new int[n][n][2];

    for (int i = 0; i < n; i++) {
      String brs= br.readLine();
      graph[i]= new StringBuilder();
      graph[i].append(brs);
    }
    
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (vis[i][j][0]==0) {
          // System.out.println();
          chk++;
          bfs(i,j);
        }
      }
    }

    // for (int i = 0; i < n; i++) {
    //   for (int j = 0; j < n; j++) {
    //     // Math.max(vis[i][j][1],chkS);
    //     System.out.print(vis[i][j][0  ]+" ");
    //   }
    //   System.out.println();
    // }
    // System.out.println();

    // for (int i = 0; i < n; i++) {
    //   for (int j = 0; j < n; j++) {
    //     // Math.max(vis[i][j][1],chkS);
    //     System.out.print(vis[i][j][1]+" ");
    //   }
    //   System.out.println();
    // }

    System.out.println(chk+" "+chkS);
  }


  static void bfs(int y, int x) {
    Queue<Node> q= new ArrayDeque<>();
    q.offer(new Node(y,x,graph[y].charAt(x),false)); 
    vis[y][x][0]=chk;
    if (vis[y][x][1]==0) {
      chkS++;
      vis[y][x][1]=chkS;
    }
      
    
    while (!q.isEmpty()) {
      Node cur=q.poll();
      // System.out.println(cur.y+" "+cur.x+" "+cur.color+" "+cur.rg+" "+vis[y][x][1]);

      for (int i = 0; i < 4; i++) {
        int nxtY= cur.y+dy[i]; int nxtX= cur.x+dx[i];
        
        if (nxtY>=0 && nxtY<n && nxtX>=0 && nxtX<n) {

          if (graph[nxtY].charAt(nxtX)==cur.color) {
            if (!cur.rg && vis[nxtY][nxtX][0]==0) {
              q.offer(new Node(nxtY,nxtX,cur.color,cur.rg));
              vis[nxtY][nxtX][0]=vis[cur.y][cur.x][0];
              if (vis[nxtY][nxtX][1]==0)
                vis[nxtY][nxtX][1]=vis[cur.y][cur.x][1];
            }
            else if (cur.rg && vis[nxtY][nxtX][1]==0) {
              q.offer(new Node(nxtY,nxtX,cur.color,cur.rg));
              vis[nxtY][nxtX][1]=vis[cur.y][cur.x][1];
            }
          }

          else if ((graph[nxtY].charAt(nxtX)=='R' && graph[cur.y].charAt(cur.x)=='G') || (graph[cur.y].charAt(cur.x)=='R' && graph[nxtY].charAt(nxtX)=='G')) {
            if (vis[nxtY][nxtX][1]==0) {
              q.offer(new Node(nxtY,nxtX,graph[nxtY].charAt(nxtX),true));
              vis[nxtY][nxtX][1]=vis[cur.y][cur.x][1];
            }
          }

          else {
            continue;
          }
        }
      }
    }  
  }
    
}

