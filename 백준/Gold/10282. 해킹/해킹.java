import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
    int dest; //java.lang의 interf: 원래 pub
    int w;

    public Edge(int dest, int w) {
        this.dest = dest;
        this.w = w;
    }


    @Override //compareTo (interf의 mthd)
    public int compareTo(Edge o) { //두 obj의 비교 기준
        return Integer.compare(this.w, o.w);
    }
}

public class Main {

    //노드의 크기, 출발지
    public static void Dijkstra(int n, int start, ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while(!pq.isEmpty()) {
            int nowVertex = pq.poll().dest;

            if(vis[nowVertex]) continue;
            vis[nowVertex] = true;

            //dest의 연결된 정점 비교
            for(Edge next : graph[nowVertex]) {//mat의 모든V
                if(dist[next.dest] > dist[nowVertex]+ next.w) {
                    dist[next.dest] = dist[nowVertex] + next.w;

                    pq.offer(new Edge(next.dest, dist[next.dest])); //가는 총 E
                }
            }
        }
        int cnt=0;
        int maxy=0;
        //최소거리 출력
        for(int i : dist) {
            if(i == Integer.MAX_VALUE) continue; //0, !vis 제외

            cnt++;
            maxy=Math.max(maxy, i);
        }
        System.out.println(cnt+" "+maxy);
    }
    //a->b에 dep
    //b가 감염, a도 감염
    public static void main(String[] args) throws IOException {

        //그래프 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //정점의 개수, 간선의 개수
        int t = Integer.parseInt(br.readLine());

        for (int i=0; i<t; i++) {
            String[] brLs = br.readLine().split(" ");
            int n = Integer.parseInt(brLs[0]);
            int d = Integer.parseInt(brLs[1]);
            int c = Integer.parseInt(brLs[2]);

            ArrayList<Edge>[] graph = new ArrayList[n + 1]; //나눠서 obj c
            for (int j = 0; j < n + 1; j++) graph[j] = new ArrayList<>();

            for (int j = 0; j < d; j++) {
                brLs = br.readLine().split(" ");
                int dest = Integer.parseInt(brLs[0]);
                int src = Integer.parseInt(brLs[1]);
                int w = Integer.parseInt(brLs[2]);

                graph[src].add(new Edge(dest, w));
            }
            Dijkstra(n, c, graph);
        }



        //다익스트라 알고리즘 수행

    }
}
