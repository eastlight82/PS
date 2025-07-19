import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[][] dXY= {{1,0}, {0,1}, {1,1}};
    static int[][] graph;
    static int[][] memo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //n*m 미로(1,1시작), max사탕
        StringTokenizer st= new StringTokenizer(br.readLine());
        n= Integer.valueOf(st.nextToken()); m= Integer.valueOf(st.nextToken());
        graph= new int[n+1][m+1]; memo= new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            st= new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                graph[i][j]= Integer.valueOf(st.nextToken());
            }
        }

        dp();
        System.out.println(memo[n][m]);
    }

    static void dp(){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i==1 && j==1)
                    memo[i][j]= graph[i][j];

                else if (i>=2 && j>=2)
                    memo[i][j]= graph[i][j]+ Math.max(memo[i-1][j], memo[i][j-1]);
                else if (i==1)
                    memo[i][j]=graph[i][j]+memo[i][j-1];
                else if (j==1)
                    memo[i][j]=graph[i][j]+memo[i-1][j];
            }
        }
    }


}
