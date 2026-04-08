import java.io.*;
import java.util.*;

public class Main {
  static int n,m,ans;
  static int[][] graph;
  static int[] dx= {0,0,1,-1}; static int[] dy= {1,-1,0,0};
  static class Node {
    int y, x;

    Node(int y, int x){
      this.y=y; this.x=x;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

    //n*m(1벽2바), 벽3개, 0최대
    //O(n): 64*63*62(12만)* 8*8
    StringTokenizer st= new StringTokenizer(br.readLine());
    n= Integer.valueOf(st.nextToken());
    m= Integer.valueOf(st.nextToken());
    graph= new int[n][m];

    for (int i = 0; i < n; i++) {
      st= new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        graph[i][j]= Integer.valueOf(st.nextToken());
      }
    }
    
    Btrck(3);
    System.out.println(ans);
  }

  //2 퍼뜨리고, 0# 세기
  static void bfsSafeChk() {
    Queue<Node> q= new LinkedList<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (graph[i][j]==2) { //2퍼뜨리기
          q.offer(new Node(i,j));
        }
      }
    }

    //얕은 복사: 2차에 clone
    int[][] copyGraph= new int[n][m];
    for (int i = 0; i < n; i++) {
      copyGraph[i]= graph[i].clone();
    }

    while (!q.isEmpty()) {
      Node cur= q.poll();

      for (int i = 0; i < 4; i++) {
        int nxtY= cur.y+dy[i];
        int nxtX= cur.x+dx[i];
      
        if (nxtY>=0 && nxtY<n && nxtX>=0 && nxtX<m && copyGraph[nxtY][nxtX]==0) {
          q.offer(new Node(nxtY,nxtX));
          copyGraph[nxtY][nxtX]=2;
        }
      }
    }

    //0# 세기
    int cnt=0;
    // System.out.println();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        // System.out.print(copyGraph[i][j]+" ");
        if (copyGraph[i][j]==0) cnt++;
      }
      // System.out.println();
    }

    if (ans<cnt) ans=cnt;
  }

  //벽 설정
  static void Btrck(int chk) {
    if (chk==0) {
      bfsSafeChk();
      return; //return 넣기
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (graph[i][j]==0) {
          graph[i][j]=1;
          Btrck(chk-1);
          graph[i][j]=0;
        }
      }
    }

  }
}