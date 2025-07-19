import java.io.*;
import java.util.*;

public class Main {
    static int[] seq;
    static int[][] memo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //pelindrome: n개 자연수 적고, 질문 m번(s,e): s~e까지가 팰린드롬인지
        //m이 100만개: 한 질문마다 O(logn)

        int n= Integer.valueOf(br.readLine()); seq= new int[n+1];
        memo= new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(memo[i], -1);
        }
        StringTokenizer st= new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            seq[i]= Integer.valueOf(st.nextToken());
        }
        int m= Integer.valueOf(br.readLine());
        StringBuilder sb= new StringBuilder();

        for (int i = 0; i < m; i++) {
            int stt, end;
            st= new StringTokenizer(br.readLine());
            stt= Integer.valueOf(st.nextToken()); end= Integer.valueOf(st.nextToken());

            //dp(stt, end)= (stt, end) && (stt+1, end-1) //while stt+i<=end-i
            sb.append(dp(stt, end)+"\n");
        }
        System.out.println(sb);
    }

    static int dp(int stt, int end){
        if (stt > end)
            return 1;

        if (memo[stt][end]!=-1)
            return memo[stt][end];

        if (seq[stt]==seq[end]){
            return memo[stt][end]=dp(stt+1,end-1);
        }
        else{
            return 0;
        }

    }

}
