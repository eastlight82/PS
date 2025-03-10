import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        //세집 n*n 격자판, 파이프 옮길때 (1,2)는 겹침
        //파이프 남, 남동(3칸), 동/ 최대 45도
        //크기 n, 집상태(벽1), (n,n) 이동법

        List<String[]> graph= new ArrayList<>();

        //input
        int n= Integer.valueOf(br.readLine());
        for (int i = 0; i < n; i++) { //00, 01, 02
            graph.add(br.readLine().split(" "));
        }
        int[][] dp= new int[n*n][3];

        //dp: 각 graph의 이동# 저장
        //dp[1~9][0,1,2]: 0가로, 1대각, 2세로
        //9=5+6(3)+8(7)
        //x*n+y= [(x-1)*n+y-1]+[(x-1)*n+y][2]+[(x)*n+y-1][0]

        dp[1][0]=1; //n=6
        //012345
        //678901
        //234567
        for (int i = 1; i < n*n; i++) {
            if ((i + 1 < n * n) && graph.get((i+1)/n)[(i+1)%n].equals("0")) {
                if ((i+1)%n!=0)
                    dp[i+1][0]=dp[i][0]+dp[i][1];
            }

            if ((n+i<n*n) && graph.get((n+i)/n)[(n+i)%n].equals("0")){
                if ((i+n)%n!=0)
                    dp[n+i][2]=dp[i][1]+dp[i][2];
            }

            if ((n+i+1<n*n) && ((n+i+1)%n-1)>=0 && graph.get((n+i+1)/n)[(n+i+1)%n-1].equals("0") &&
             graph.get((n+i+1)/n-1)[(n+i+1)%n].equals("0") && graph.get((n+i+1)/n)[(n+i+1)%n].equals("0")){
                if ((n+i+1)%n!=0)
                    dp[n+i+1][1]=dp[i][0]+dp[i][1]+dp[i][2];
            }

        }

        System.out.println(dp[n*n-1][0]+dp[n*n-1][1]+dp[n*n-1][2]);

    }


}
