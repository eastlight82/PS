import java.io.*;
import java.util.*;

public class Main {
    static int[] memo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine()); //2*n
        memo = new int[1001];

        memo[1] = 1; memo[2] = 2;
        for (int i = 3; i <= n; i++) {
            memo[i] = (memo[i - 1] + memo[i - 2]) % 10007; // memo[i-2]의 ㅣㅣㅣ은 memo[i-1]
        }
        System.out.println(memo[n]);
    }
}
