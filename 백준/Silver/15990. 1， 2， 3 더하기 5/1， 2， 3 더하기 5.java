import java.io.*;
import java.util.*;

public class Main {
    static long[][] memo;
    static long div= 1000000009;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1,2,3/ 연속 같은거 x
        int T= Integer.valueOf(br.readLine()); //4
        memo= new long[100001][4];

        memo[1][1]=1; memo[2][2]=1;
        memo[3][1]=1; memo[3][2]=1; memo[3][3]=1;
        for (int i = 4; i < 100001; i++) {
            memo[i][1]=(memo[i-1][2]+memo[i-1][3])%div;
            memo[i][2]=(memo[i-2][1]+memo[i-2][3])%div;
            memo[i][3]=(memo[i-3][1]+memo[i-3][2])%div;
        }

        for (int i = 0; i < T; i++) {
            int n= Integer.valueOf(br.readLine());
            System.out.println((memo[n][1]+memo[n][2]+memo[n][3])%div);
        }
    }
}
