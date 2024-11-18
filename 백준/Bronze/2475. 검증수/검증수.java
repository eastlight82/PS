import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        List<String> ls= List.of(br.readLine().split(" "));
        int answ=0;

        for (int i = 0; i < ls.size(); i++) {
            int a= Integer.valueOf(ls.get(i));
            answ+=Math.pow(a,2);
//            System.out.println(answ);
        }
        System.out.println(answ%10);
    }
}