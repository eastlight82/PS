import java.io.*;
import java.util.*;

public class Main {
    //1
    //1+1,2
    //1+1+1, 1+2, 3
    //1+3, 1+1+2, 2+2, 1+1+1+1
    static int[][] memo= new int[10001][4];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1,2,3(조합으로): i번째 수<= i+1번째 수(오름차순)
        int t= Integer.valueOf(br.readLine());
        memo[1][1]=1; memo[2][1]=1; memo[2][2]=1; memo[3][1]=1; memo[3][2]=1; memo[3][3]=1;
        for (int j = 4; j < 10001; j++) {
            memo[j][1]= memo[j-1][1];
            memo[j][2]= memo[j-2][2]+ memo[j-2][1];
            memo[j][3]= memo[j-3][3]+ memo[j-3][2]+ memo[j-3][1];
        }

        for (int i = 0; i < t; i++) {
            int n= Integer.valueOf(br.readLine());

            System.out.println(Arrays.stream(memo[n]).sum());
        }
    }

}
