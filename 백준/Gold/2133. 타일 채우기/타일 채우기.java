import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //이해: 3*N을 2*1, 1*2로 채움
        //needs: N->dp[N][0b111]
        //해결: dp[N][0b111 (3개 bitmask)]: N-1까진 다 full
        //N=2: 111, =1, 1=: 3개
        //rec_rel: N짝수시 dp[N][111]= dp[N-1][110]+dp[N-1][011]+dp[N-1][000]

        StringTokenizer st= new StringTokenizer(br.readLine());
        int N= Integer.valueOf(st.nextToken());

        int[][] dp= new int[N+1][0b1000];
        for (int i = 0; i < N+1; i++) {
            for (int j = 0; j < 0b1000; j++) {
                dp[i][j]= 1;
            }
        }
        //ex
//        dp[1][0b011]=1; dp[1][0b110]=1; dp[1][0b000]=1;
//        dp[2][0b111]=3; dp[2][0b100]=1; dp[2][0b001]=1;

        for (int i = 2; i <= N; i++) {
            if (i%2!=0){ //odd: 새로 시작
                dp[i][0b011]=dp[i-1][0b111]+dp[i-1][0b100];
                dp[i][0b110]=dp[i-1][0b111]+dp[i-1][0b001];
                dp[i][0b000]=dp[i-1][0b111];
            }

            else { //even: full해야
                dp[i][0b111]=dp[i-1][0b000]+dp[i-1][0b011]+dp[i-1][0b110];
                dp[i][0b100]=dp[i-1][0b011];
                dp[i][0b001]=dp[i-1][0b110];
            }
        }

        if (N%2==0)
            System.out.println(dp[N][0b111]);
        else
            System.out.println(0);
    }
}
