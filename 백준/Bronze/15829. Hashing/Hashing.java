import java.io.*;
import java.util.*;

public class Main {

    static long MOD= 1234567891;

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int L= Integer.valueOf(br.readLine()); //5
        String s= br.readLine(); //abcde

        long answ=0, pow=1;

        for (char i:s.toCharArray()){
            answ+=((long) i-96)* pow;
            pow=(pow*31)%MOD;
        }
        System.out.println(answ%MOD);
    }
}