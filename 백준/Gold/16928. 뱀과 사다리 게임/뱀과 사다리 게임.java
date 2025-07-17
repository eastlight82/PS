import java.io.*;
import java.util.*;

public class Main {
    static int[] graph= new int[101];
    static int[] cnt= new int[101];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //주사위, board(10*10에 1~100) //100번 넘어가면 이동x
        //최소#(bfs)
        String[] brs= br.readLine().split(" ");
        int N= Integer.valueOf(brs[0]); int M= Integer.valueOf(brs[1]);

        for (int i = 0; i < 101; i++) {
            graph[i]=i;
        }

        for (int i = 0; i < N; i++) {
            brs= br.readLine().split(" ");
            int a= Integer.valueOf(brs[0]); int b= Integer.valueOf(brs[1]);
            graph[a]=b;
        }
        for (int i = 0; i < M; i++) {
            brs= br.readLine().split(" ");
            int a= Integer.valueOf(brs[0]); int b= Integer.valueOf(brs[1]);
            graph[a]=b;
        }

        Queue<Integer> q= new LinkedList<>();
        q.offer(1);
        while (!q.isEmpty()){
            int cur= q.poll();
            if (cur==100) break;

            for (int i = 1; i <= 6; i++) {
                if ((cur+i<=100) && cnt[graph[cur+i]]==0){ //0=!vis
                    q.offer(graph[cur+i]);
                    cnt[graph[cur+i]]=cnt[cur]+1;
                }
            }
        }

        System.out.println(cnt[100]);

    }
}
