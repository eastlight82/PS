import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        String[] ipt= br.readLine().split(" ");

        long A=Integer.valueOf(ipt[0]);
        long B=Integer.valueOf(ipt[1]);
        long C=Integer.valueOf(ipt[2]);

        //A^B mod C 1. 매번 나누기X, 2. B=n*m
        //2^100->50,25,12,6,3,1

        System.out.println(pow(A,B,C,1L));

    }

    static long pow(long a, long b, long c, long e){
//        System.out.println(a+" "+b+" "+e+" ");
        if (b==1){
            return a*e%c;
        }

        if (b%2==0){
            return pow((a*a)%c, b/2, c, e);
        }

        else{
            return pow((a*a)%c, b/2, c, e*a%c);
        }
    }
}