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

class NVal implements Comparable<NVal>{
    int w;
    int src;

    NVal(int w, int src){
        this.w=w;
        this.src=src;
    }

    public int compareTo(NVal n){
        return this.w-n.w;
    }
}

class sd{
    int src;
    int dest;

    sd(int src, int dest){
        this.src=src;
        this.dest=dest;
    }
}

public class Main {
    static List<Edge>[] graph;
    static List<sd> SD=new ArrayList<>();
    static int isFirst=0;

    //모든 1~n가는 dest-src E 수집
    //dp[n]=3-> dp]3]=2-> dp[2]=1-> 1
    static void getSD(int n, NVal[] dp){
        if (n==1) return; //~1

        int nSrc=dp[n].src;
        SD.add(new sd(nSrc,n));
        getSD(nSrc,dp);
    }

    static int Dijkstra(int n, int start, int n1, int n2) {
        boolean[] vis = new boolean[n + 1]; 
        NVal[] dp = new NVal[n + 1]; //=dist
        for (int i = 0; i < n+1; i++)
            dp[i]=new NVal(Integer.MAX_VALUE, -1);
        dp[start] = new NVal(0, 0);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while(!pq.isEmpty()) {
            int cur = pq.poll().dest; //dp min인거 matr 포함

            if(vis[cur]) continue;
            vis[cur] = true;

            //dest의 연결된 정점 비교
            for(Edge next : graph[cur]) {//mat의 모든V
                if (cur==n1 && next.dest==n2) continue;
                if (cur==n2 && next.dest==n1) continue;

                if(dp[next.dest].w > dp[cur].w+ next.w) {
                    dp[next.dest].w = dp[cur].w + next.w;
                    dp[next.dest].src= cur;

                    pq.offer(new Edge(next.dest, dp[next.dest].w)); //가는 총 E
                }
            }
        }
        if (isFirst==0){ //처음에 SD 확인 목적
            getSD(n,dp);
            isFirst++;
        }
        return dp[n].w;

    }
    //dp에 w,src 받기-> n의 src부터 차례대로

    public static void main(String[] args) throws IOException {

        //그래프 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] brLs=br.readLine().split(" ");
        int n= Integer.valueOf(brLs[0]);
        int m= Integer.valueOf(brLs[1]);

        graph= new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            graph[i]= new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            brLs=br.readLine().split(" ");
            int src= Integer.valueOf(brLs[0]);
            int dest= Integer.valueOf(brLs[1]);
            int w= Integer.valueOf(brLs[2]);

            graph[src].add(new Edge(dest,w));
            graph[dest].add(new Edge(src,w));
        }

        int firstAnsw=Dijkstra(n, 1,0,0);
        int secondAnsw=0;
        //SD:
        for (int i = 0; i < SD.size(); i++) {
            int src=SD.get(i).src;
            int dest=SD.get(i).dest;

            secondAnsw=Math.max(secondAnsw, Dijkstra(n,1,src,dest));
            if (secondAnsw==Integer.MAX_VALUE) break;
        }
        if (secondAnsw==Integer.MAX_VALUE)
            System.out.println(-1);

        else System.out.println(secondAnsw-firstAnsw);
    }
}
