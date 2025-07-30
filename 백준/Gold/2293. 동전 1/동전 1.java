import java.io.*;
import java.util.*;

public class Main {
    static int n,k;
    static int[] coin;
    static int[] memo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //n가지 동전: 합 k원인 경우의 수
        StringTokenizer st= new StringTokenizer(br.readLine());
        n= Integer.valueOf(st.nextToken()); k=Integer.valueOf(st.nextToken());
        coin= new int[n]; memo= new int[k+1];

        for (int i = 0; i < n; i++) {
            coin[i]= Integer.valueOf(br.readLine());
        }

        //2,3,5
        //2: 2,4,6:1
        //3: 3:memo[3]

        //기존 풀이법: 왜 memo[0]=1로 시작하는지 모르겠음
        for (int i : coin) {
            if (i<k+1) //첫 coin배수는 1
                memo[i]+=1;

            for (int j = i; j < k+1; j++)
                memo[j]+= memo[j-i]; //memo[9]=기존 2로+memo[6]

        }
        System.out.println(memo[k]);
    }

}
