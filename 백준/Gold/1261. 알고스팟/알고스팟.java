import java.io.*;
import java.util.*;

public class Main {
  static int n,m,ans=Integer.MAX_VALUE;
  static StringBuilder[] graph;

  static int[][] vis;
  static int[] dx= {0,0,-1,1}; static int[] dy= {-1,1,0,0};
  static class Node {
    int y,x,wall;
    Node(int y, int x, int wall){//전체수-rg바뀐수
      this.y=y; this.x=x; this.wall=wall;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    //n*m미로, 빈방or벽, 부숴야하는 벽#
    StringTokenizer st= new StringTokenizer(br.readLine());
    m= Integer.valueOf(st.nextToken());
    n= Integer.valueOf(st.nextToken());
    graph= new StringBuilder[n]; vis= new int[n][m];

    for (int i=0; i<n; i++) {
      String brs= br.readLine();
      graph[i]= new StringBuilder();
      graph[i].append(brs);
    }

    for (int i=0; i<n; i++) {
      for (int j=0; j<m; j++)
        vis[i][j]=Integer.MAX_VALUE;
    }

    bfs();
    System.out.println(ans);
  }


  static void bfs() {
    Queue<Node> q= new ArrayDeque<>();
    q.offer(new Node(0,0,0)); vis[0][0]=0;

    while (!q.isEmpty()) {
      Node cur= q.poll();
      if (cur.y==n-1 && cur.x==m-1 && ans>cur.wall) ans=cur.wall;

      for (int i=0; i<4; i++) {
        int nxtY=cur.y+dy[i]; int nxtX=cur.x+dx[i];

        if (nxtY>=0 && nxtY<n && nxtX>=0 && nxtX<m) {
          if (graph[nxtY].charAt(nxtX)=='1' && vis[nxtY][nxtX]>cur.wall+1) {
            q.offer(new Node(nxtY,nxtX,cur.wall+1));
            vis[nxtY][nxtX]=cur.wall+1;
          }

          else if (graph[nxtY].charAt(nxtX)=='0' && vis[nxtY][nxtX]>cur.wall){
            q.offer(new Node(nxtY,nxtX,cur.wall));
            vis[nxtY][nxtX]=cur.wall;
          }
        }
        
      } 

    }
  }
    
}

