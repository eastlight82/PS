import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int r;
    int c;
    int w;

    public Edge(int r, int c, int w) {
        this.r = r;
        this.c = c;
        this.w = w;
    }

    @Override //compareTo (interf의 mthd)
    public int compareTo(Edge o) { //두 obj의 비교 기준
        return Integer.compare(this.w, o.w);
    }
}

public class Main {
    static int[] dR = {1, -1, 0, 0};
    static int[] dC = {0, 0, 1, -1};
    static int grphCnt=1;

    //노드의 크기, 출발지
    static void Dijkstra(int n, int[][] graph) {
        boolean[][] vis = new boolean[n][n];
        int[][] memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }

        memo[0][0] = graph[0][0];

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(0, 0, memo[0][0]));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int curR = cur.r;
            int curC = cur.c;
            int curW = cur.w;

            if (vis[curR][curC]) continue;
            vis[curR][curC] = true;

            //dest의 연결된 정점 비교
            for (int i = 0; i < 4; i++) {
                int nextR = curR + dR[i];
                int nextC = curC + dC[i];

                if (!(nextR >= 0 && nextR < n && nextC >= 0 && nextC < n)) continue;

                if (memo[nextR][nextC] > memo[curR][curC] + graph[nextR][nextC]){
                    memo[nextR][nextC] = memo[curR][curC] + graph[nextR][nextC];

                    pq.offer(new Edge(nextR, nextC, memo[nextR][nextC]));
                }

            }
        }

        System.out.println("Problem "+grphCnt+": " + memo[n - 1][n - 1]);
        grphCnt++;
    }

    //a->b에 dep
    //b가 감염, a도 감염
    public static void main(String[] args) throws IOException {

        //그래프 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //정점의 개수, 간선의 개수
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int[][] graph = new int[n][n]; //나눠서 obj c

            for (int r = 0; r < n; r++) {
                String[] brLs= br.readLine().split(" ");
                for (int c = 0; c < n; c++) {
                    graph[r][c] = Integer.parseInt(brLs[c]);
                }
            }
            Dijkstra(n, graph);
        }

    }

}

