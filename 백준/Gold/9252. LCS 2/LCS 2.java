import java.io.*;
import java.util.*;


public class Main
{
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        String s1= br.readLine();
        String s2= br.readLine();
        dp= new int[s1.length()+1][s2.length()+1]; //len: max 1000

        lcs(s1, s2, s1.length(), s2.length());
        calcLCSStr(s1, s2, s1.length(), s2.length());
        //given: 2str
        //needs: 2str's lcs: #, str
        //solve: dp: make matr for until [s1][s2]'s lcs
        //compare each matr val
        //rec_relat: dp[j][i]= dp[j-1] i==j
    }
    static void lcs(String s1, String s2, int len, int len2){
        for (int j=1; j<len+1; j++){
            for (int i=1; i<len2+1; i++){
                if (s1.charAt(j-1)==s2.charAt(i-1)){
                    //dpStr: 기존값+ 해당값(charAt,max) 넣기
                    dp[j][i]= dp[j-1][i-1]+1;
//                    System.out.println(dpStr[j][i]);
                }

                else
                    dp[j][i]= Math.max(dp[j-1][i],dp[j][i-1]);
            }
        }

        System.out.println(dp[len][len2]);
    }
    //ACAYKP CAPCAK
    /*
      ACAYKP
     0000000
    C0011111
    A0112222
    P0112223
    C0122223
    A0123333
    K0123344
     */ //66, 65, 54, 53, 42, 31
    static void calcLCSStr(String s1, String s2, int len, int len2){
        StringBuilder sb= new StringBuilder();
        while (len>0 && len2>0){
            if (s1.charAt(len-1)==s2.charAt(len2-1)){
                sb.append(s1.charAt(len-1));
                len--; len2--;
            }
            else {
                if(dp[len-1][len2]>=dp[len][len2-1]){
                    len--;
                }
                else{
                    len2--;
                }
            }
        }
        System.out.println(sb.reverse());
    }
}
