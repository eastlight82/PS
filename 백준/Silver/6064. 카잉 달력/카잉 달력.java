import java.io.*;
import java.util.*;

public class Main {
    static String[] graph;

    static int gcd(int a, int b){
        if (b==0)
            return a;

        return gcd(b, a%b);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //<x:y>: 1,1/ 2,2/ 10,10/ 1,11/ 2,12/ 3,1: 총 m&n의 최소공배수

        int T= Integer.valueOf(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] brs= br.readLine().split(" ");
            int[] mnxy= new int[4];
            for (int j = 0; j < brs.length; j++) {
                mnxy[j]= Integer.valueOf(brs[j]);
            }

            int gcd= gcd(mnxy[0],mnxy[1]);
            int lcd= mnxy[0]*mnxy[1]/gcd;

            //am+x, bn+y/ 최소
            //10, 12: 10*0~6
            boolean chk=false;
            for (int j = 0; j < lcd/mnxy[0]; j++) {
                int day= mnxy[0]*j+mnxy[2];

                if ((day-mnxy[3])%mnxy[1]==0){
                    System.out.println(day);
                    chk=true;
                    break;
                }
            }

            if (!chk)
                System.out.println(-1);

        }



    }
}
