import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

    int n= Integer.valueOf(br.readLine()); 
    int[] ls= new int[n]; int[] dp= new int[n]; //0:최대 1:마지막꺼 포함 최대
    StringTokenizer st= new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      ls[i]= Integer.valueOf(st.nextToken());
      dp[i]=1;
    }
      
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (ls[j]<ls[i]) {
          if (dp[j]+1>dp[i]) dp[i]=dp[j]+1;
        }
      }
    }

    int max=0;;
    for (int i = 0; i < n; i++) {
      max= Math.max(max, dp[i]);
    }
    
    System.out.println(max);
  }
}