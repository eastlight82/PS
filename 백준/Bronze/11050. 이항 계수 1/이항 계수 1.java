import java.io.*;
import java.util.*;

public class Main {

    static int n, k;
    static HashSet<ArrayList<Integer>> ls= new HashSet<>();
    static ArrayList<Integer> tmp= new ArrayList<>();

    static void combi(int start, ArrayList<Integer> tmp){

        if (tmp.size()==k) {
            ls.add(tmp);
            return;
        }

        for (int i=start; i<=n; i++){
            tmp.add(i);
            combi(i+1, tmp);
            tmp.remove(tmp.size()-1);

        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        List<String> ls2= List.of(br.readLine().split(" "));

        n= Integer.valueOf(ls2.get(0)); k= Integer.valueOf(ls2.get(1));

        //n!/(n-k)!k!

        combi(1, tmp);

        System.out.println(ls.size());


    }
}