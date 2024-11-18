import java.io.*;
import java.util.*;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int N = Integer.valueOf(s[0]); //크기, 합#
        int M = Integer.valueOf(s[1]);

        long[][] graph= new long[N][N];
        long[][] dp= new long[N][N];

        for (int i = 0; i < N; i++) { //ipt받기
            String[] ipt = br.readLine().split(" ");
            for (int j = 0; j < N; j++)
                graph[i][j]= Long.valueOf(ipt[j]);
        }
        for (int i = 0; i < N; i++) { //ipt받기
            for (int j = 0; j < N; j++)
                if (j!=0)
                    dp[i][j]= graph[i][j]+dp[i][j-1];
                else
                    dp[i][j]= graph[i][j];

        }

        for (int i = 0; i < M; i++) {
            String[] answLs = br.readLine().split(" ");
            Map.Entry<Integer, Integer> x= new AbstractMap.SimpleEntry<>(
                    Integer.valueOf(answLs[0])-1, Integer.valueOf(answLs[1])-1);
            Map.Entry<Integer, Integer> y= new AbstractMap.SimpleEntry<>(
                    Integer.valueOf(answLs[2])-1, Integer.valueOf(answLs[3])-1); //x,y 담음

            long sum=0L;

            for (int j=x.getKey(); j<=y.getKey(); j++){ //2 3 2 4
                if (x.getValue()>=1)
                    sum+= dp[j][y.getValue()]-dp[j][x.getValue()-1];
                else
                    sum+= dp[j][y.getValue()];
            }
            System.out.println(sum);
        }

    }
}