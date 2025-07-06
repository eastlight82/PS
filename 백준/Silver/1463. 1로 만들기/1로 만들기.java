import java.io.*;
import java.util.*;

public class Main {
    static int[] memo;

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        //x/3, /2, -1=> 1
        int x= Integer.valueOf(br.readLine());
        memo= new int[x+1];

        //각 수마다 memo[x]값 저장
        memo[1]=0;
        for (int i = 2; i <= x; i++) {
            if (i%6==0){
                memo[i]=Math.min(memo[i-1],Math.min(memo[i/2],memo[i/3]))+1;
            }
            else if (i%3==0){
                memo[i]=Math.min(memo[i-1],memo[i/3])+1;
            }
            else if (i%2==0){
                memo[i]=Math.min(memo[i-1],memo[i/2])+1;
            }
            else
                memo[i]=memo[i-1]+1;
        }

        System.out.println(memo[x]);
    }
}
