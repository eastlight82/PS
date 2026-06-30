import java.io.*;
import java.util.*;

public class Main {
  static int n,k,m;
  static int[][] graph;
  static boolean[][] vis; 

  static int ans=0; static int[] dy= {-1,1,0,0}; static int[] dx= {0,0,1,-1};

  static List<Node> stones= new ArrayList<>();
  static List<Node> selected= new ArrayList<>();
  static List<Node> starts= new ArrayList<>();

  static class Node {
    int y,x;

    Node(int y, int x){
      this.y=y; this.x=x;
    }
  }

  //순열
  static void comb(int idx, int depth) {
    //5개중 m=2로 가정
    //0,0[0]->1,1[0,1]->2,1[0,2] 4,1[0,4]->1,0[1] 2,1[1,2]

    if (depth==m){ //m개 확정시 graph에 적용후 bfs
      for (Node stone : selected) {
        graph[stone.y][stone.x] = 0;
      }
      ans= Math.max(ans, bfs());
      for (Node stone : selected) {
        graph[stone.y][stone.x] = 1;
      }
      return;
    }

    for (int i=idx; i<stones.size(); i++) {
      selected.add(stones.get(i));
      comb(i+1, depth+1);
      selected.remove(selected.size()-1);
    }
  }

  static int bfs() { //매 bfs마다 가능max값
    vis= new boolean[n][n];
    Queue<Node> q= new ArrayDeque<>();
    for (Node n: starts) {
      if (!vis[n.y][n.x]) {
        q.offer(n); vis[n.y][n.x]=true;
      }
    }

    int cnt=0;
    while (!q.isEmpty()) {
      Node cur= q.poll(); cnt++;

      for (int i=0; i<4; i++) {
        int nY= cur.y+dy[i]; int nX= cur.x+dx[i];

        if (nY>=0 && nY<n && nX>=0 && nX<n && !vis[nY][nX] && graph[nY][nX]==0) {
          q.offer(new Node(nY,nX)); vis[nY][nX]=true;
        }
      }
    }
    return cnt;
  }


  public static void main(String[] args) throws Exception {
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    // StringTokenizer st= new StringTokenizer(br.readLine());

    //n*n, m돌(1)만 치워 k시작점부터 상하좌우 이동
    //돌Cm해서 graph에 짜기
    String[] brs= br.readLine().split(" ");
    n= Integer.valueOf(brs[0]); k= Integer.valueOf(brs[1]); m= Integer.valueOf(brs[2]);
    graph= new int[n][n];
    //k: 몇돌 치웠는지

    for (int i=0; i<n; i++) {
      StringTokenizer st= new StringTokenizer(br.readLine());
      for (int j=0; j<n; j++) {
       graph[i][j]= Integer.valueOf(st.nextToken());

       if (graph[i][j] == 1) {
        stones.add(new Node(i, j));
        }
      }
    }
    for (int i=0; i<k; i++) {
      brs= br.readLine().split(" ");
      int r=Integer.valueOf(brs[0])-1; int c=Integer.valueOf(brs[1])-1;
      starts.add(new Node(r,c));

    }

    comb(0,0); //돌 고르고 bfs
    System.out.println(ans);

  }
  

}
