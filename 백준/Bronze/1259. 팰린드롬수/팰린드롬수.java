import java.io.*;
import java.util.*;

public class Main {

    static boolean Felindrome(String s){
        int len= s.length();

        for (int i=0; i<len/2; i++) { //짝, 홀 같음
            if (s.charAt(i) == s.charAt((len - 1) - i)) {
            } 
            else return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        //Felindrome: 거꾸로 뒤집어드 이효리~

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String n= br.readLine(); //ipt
            if (n.equals("0")) break;

            if (Felindrome(n)) System.out.println("yes");
            else System.out.println("no");
        }

    }
}