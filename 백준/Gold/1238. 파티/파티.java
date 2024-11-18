//3점: dijkstra algo 방식, 객체는 ncopies로 초기x
import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

public class Main{
    //Node n개에 각 학생 1명
    //X번 Node에 모이기
    //Edge m개, i번째 i시간


    static class Edge implements Comparable<Edge>{
        int endN;
        int time;

        Edge(int endN, int time){
            this.endN=endN;
            this.time=time;
        }

        @Override
        public int compareTo(Edge N){
            return this.time- N.time;
        }
    }
    //how to find max
    //dik impl
    static int[] dijkstra(List<List<Edge>> graph, int n, int x){
        int[][] answ= new int[n+1][n+1]; //a->b

        PriorityQueue<Edge> pq= new PriorityQueue<>();
        //1~n까지 전부
        int[] dist= new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] vis= new boolean[n+1];

        dist[x]=0; dist[0]=0; pq.offer(new Edge(x, 0));

        while (!pq.isEmpty()){
            int cur=pq.poll().endN;
            if (vis[cur])
                continue;
            vis[cur]=true;

            for (Edge next: graph.get(cur)){
                if (dist[next.endN]>dist[cur]+next.time){ //기존>나중
                    dist[next.endN]=dist[cur]+next.time;
                    pq.offer(new Edge(next.endN, dist[next.endN]));
                }
            }
        }
//        for (int i = 1; i <=n; i++) {
//            System.out.println(dist[i]);
//        }
        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] brVec= br.readLine().split(" ");
        int n=Integer.valueOf(brVec[0]);
        int m=Integer.valueOf(brVec[1]);
        int x=Integer.valueOf(brVec[2]);

        List<List<Edge>> graph = new ArrayList<>();
        List<List<Edge>> graph2 = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            graph2.add(new ArrayList<>());
        }

        for (int i=1; i<=m; i++){
            brVec= br.readLine().split(" ");
            //Edge의 시,끝,i시간
            int startN=Integer.valueOf(brVec[0]);
            int endN=Integer.valueOf(brVec[1]);
            int time=Integer.valueOf(brVec[2]);

            graph.get(startN).add(new Edge(endN,time));
            graph2.get(endN).add(new Edge(startN,time));
        }

        int[] dist1=dijkstra(graph, n, x);
        int[] dist2=dijkstra(graph2, n, x);

        int maxy=0;
        for (int i = 1; i <= n; i++) {
            maxy=Math.max(maxy, dist1[i]+dist2[i]);
        }
        System.out.println(maxy);

    }
}