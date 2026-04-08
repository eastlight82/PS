import java.io.*;
import java.util.*;

public class Main {
  static int n,m,ans=-1;
  static StringBuilder[] graph;
  static boolean[][][] vis; 
  static int[] dx= {0,0,1,-1}; static int[] dy= {1,-1,0,0};
  static class Node {
    int y, x, cnt, destroyed; //1: 부숨
    Node(int y, int x, int cnt, int destroyed){
      this.y=y; this.x=x; this.cnt=cnt; this.destroyed=destroyed;

    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    //1,1->n,m, 1벽(1개까지 부심)
    StringTokenizer st= new StringTokenizer(br.readLine());
    n= Integer.valueOf(st.nextToken());
    m= Integer.valueOf(st.nextToken());
    graph= new StringBuilder[n];
    vis= new boolean[n][m][2];

    for (int i = 0; i < n; i++) {
      String brs= br.readLine();
      graph[i]= new StringBuilder();
      graph[i].append(brs);
    }

    bfs(0,0);
    System.out.println(ans);
  }

  static void bfs(int y, int x) {
    Queue<Node> q= new LinkedList<>();

    q.offer(new Node(0,0,1,0));
    while (!q.isEmpty()) {
      Node cur=q.poll();
      if (cur.y==n-1 && cur.x==m-1) {
        ans=cur.cnt;
        return;
      }
      
      for (int i = 0; i < 4; i++) {
        int nxtY= cur.y+dy[i]; int nxtX= cur.x+dx[i];

        if (nxtY>=0 && nxtY<n && nxtX>=0 && nxtX<m) {
          //0일때 destroy ox
          if (graph[nxtY].charAt(nxtX)=='0') {
            if (cur.destroyed==0 && !vis[nxtY][nxtX][0]) {
              q.offer(new Node(nxtY,nxtX,cur.cnt+1,0));
              vis[nxtY][nxtX][0]=true;
            }
            
            else if (cur.destroyed==1 && !vis[nxtY][nxtX][1]) {
              q.offer(new Node(nxtY,nxtX,cur.cnt+1,1));
              vis[nxtY][nxtX][1]=true;
            }
          }

          else {
            if (cur.destroyed==0 && !vis[nxtY][nxtX][0]) {
              //graph 바꾸지 말기(벽도 0처럼)
              q.offer(new Node(nxtY,nxtX,cur.cnt+1,1));
              vis[nxtY][nxtX][1]=true;
            }
          }
        }
      }
    }

  }

}