import java.io.*;
import java.util.*;

public class Main {
  static int w,h,ans=Integer.MAX_VALUE; static boolean bfsEndChk;
  static StringBuilder[] graph;
  //재방문이 더 cost적을수도
  static int[][][] dist;
  static int[] dx= {0,0,-1,1}; static int[] dy= {-1,1,0,0};
  static class Node {
    int y, x, cnt, route;
    Node(int y, int x, int cnt, int route){
      this.y=y; this.x=x; this.cnt=cnt; this.route=route;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st= new StringTokenizer(br.readLine());
    w= Integer.valueOf(st.nextToken());
    h= Integer.valueOf(st.nextToken());
    graph= new StringBuilder[h]; dist= new int[h][w][4];

    for (int i = 0; i < h; i++) {
      String brs= br.readLine();
      graph[i]= new StringBuilder();
      graph[i].append(brs);
    }

    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        for (int j2 = 0; j2 < 4; j2++) {
          dist[i][j][j2]=Integer.MAX_VALUE;
        }
      }
    }

    for (int i = 0; i < h && !bfsEndChk; i++) {
      for (int j = 0; j < w && !bfsEndChk; j++) {
        if (graph[i].charAt(j)=='C') {
          bfs(i,j); bfsEndChk=true;
        }
      }
    }

    System.out.println(ans);
  }

  static void bfs(int y, int x) {
    Queue<Node> q= new ArrayDeque<>();
    q.offer(new Node(y,x,-1,-1)); 
    for (int i = 0; i < 4; i++) {
      dist[y][x][i]=-1;
    }
    
    while (!q.isEmpty()) {
      Node cur=q.poll();
      // System.out.println(cur.y+" "+cur.x+" "+cur.cnt+" "+cur.route);
      if ((cur.y!=y || cur.x!=x) && graph[cur.y].charAt(cur.x)=='C') {
        ans=Math.min(ans,cur.cnt);
      }

      for (int i = 0; i < 4; i++) {
        int nxtY= cur.y+dy[i]; int nxtX= cur.x+dx[i];

        if (nxtY>=0 && nxtY<h && nxtX>=0 && nxtX<w && graph[nxtY].charAt(nxtX)!='*') {
          if (cur.route==i && dist[nxtY][nxtX][i]>cur.cnt) {
            q.offer(new Node(nxtY,nxtX,cur.cnt,i));
            dist[nxtY][nxtX][i]=cur.cnt;
          }

          else if (cur.route!=i && dist[nxtY][nxtX][i]>cur.cnt+1) {
            q.offer(new Node(nxtY,nxtX,cur.cnt+1,i));
            dist[nxtY][nxtX][i]=cur.cnt+1;
          }
        }

      }
    }
  }

}