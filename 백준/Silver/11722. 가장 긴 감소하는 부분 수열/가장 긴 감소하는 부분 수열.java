import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        //수열A의 증가부분 수열중 합이 가장 큰거
        int N= Integer.valueOf(br.readLine()); //크기
        String[] Ais= br.readLine().split(" ");
        int[] Ai= Arrays.stream(Ais)
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] dp= new int[N];
        //dp의 각 idx: 해당Ai값으로 끝나는 값/ 1 3 1 2 2 1
        dp[0]=1;
        for (int i = 1; i < N; i++) {
            dp[i]=1;
            for (int j = 0; j < i; j++) {
                if (Ai[j]>Ai[i])
                    dp[i]=Math.max(dp[j]+1, dp[i]);
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());

    }
}
