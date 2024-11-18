import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> dp = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        //a층 b호 거주시: a-1층의 1~b호 사람#만큼 사람 데려와
        //0층 1호: i호 i명
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.valueOf(br.readLine());

        for (int a = 0; a < T; a++) {
            int k = Integer.valueOf(br.readLine());
            int n = Integer.valueOf(br.readLine());
            //k층 n호
            ArrayList<Integer> ls = new ArrayList<>();

            for (int y = 0; y <= k; y++)
                dp.add(new ArrayList<>(Collections.nCopies(n,0)));

            for (int i=0; i<n; i++) //0층 값들 설정
                dp.get(0).set(i,i+1);

            //dp 채우기
            for (int y = 1; y <= k; y++) { //층
                for (int x = 1; x <= n; x++) { //호 나중에 n-1 출력

                    if (x == 1) {
                        dp.get(y).set(0,dp.get(y - 1).get(0));
                    }
                    else {
                        dp.get(y).set(x-1, dp.get(y).get(x - 2) + dp.get(y - 1).get(x - 1));

                    //dp[a][b]= dp[a-1].stream().mapToInt(Integer::intvalue).sum()
                    //dp[1][0]=dp[0][0]
                    //dp[1][1]=dp[1][0]+dp[0][1]
                    //dp[y][x]=dp[y][x-1]+dp[y-1][x]
                    }

                }
            }

            System.out.println(dp.get(k).get(n-1));
            dp.clear();

        }
    }
}