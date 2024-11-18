import java.io.*;
import java.util.*;


public class Main {



	public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.valueOf(br.readLine());

        for (int i = 0; i < T; i++) {
            int n= Integer.valueOf(br.readLine()); //열 ipt
            int[][] ls= new int[2][n];
            int[][] dp= new int[2][n];

            for (int j = 0; j < 2; j++) { //j*k
                String[] s= br.readLine().split(" "); //열값들 ipt

                for (int k = 0; k < n; k++)
                    ls[j][k]=Integer.valueOf(s[k]); //graph ipt완료

            } //ipt완료
            //2*N, 인접변은 고름x, 고름Sum max
            //1칸앞: 타 행, 2칸앞: 모든 행: max(dp[0&1,막행])
            //막행0, 1일때 max 다 구하기

            dp[0][0]= ls[0][0];
            dp[1][0]= ls[1][0];

            for (int j=1; j<=n-1; j++){
                if (j>=2){
                    dp[0][j]= Math.max(dp[1][j-1]+ls[0][j], dp[1][j-2]+ls[0][j]);
                    dp[1][j]= Math.max(dp[0][j-1]+ls[1][j], dp[0][j-2]+ls[1][j]);
                }

                else if (j==1){
                    dp[0][1]=ls[0][1]+dp[1][0];
                    dp[1][1]=ls[1][1]+dp[0][0];

                }
            }
            System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));

        }

    }
}