import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            List<String> ls = List.of(br.readLine().split(" "));
            List<Double> answ = new ArrayList<>();

            for (int i = 0; i < ls.size(); i++) {
                int a = Integer.valueOf(ls.get(i));
                answ.add(Math.pow(a, 2));
            }
            if (answ.get(0) == 0 && answ.get(1) == 0 && answ.get(2) == 0)
                break;

            if (answ.get(0) + answ.get(1) == answ.get(2))
                System.out.println("right");
            else if (answ.get(0)+ answ.get(2)==answ.get(1))
                System.out.println("right");
            else if (answ.get(1)+ answ.get(2)==answ.get(0))
                System.out.println("right");
            else
                System.out.println("wrong");

            answ.clear();
        }

    }
}