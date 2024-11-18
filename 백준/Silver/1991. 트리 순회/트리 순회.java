import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    static TreeMap<String, List<String>> tree= new TreeMap<>();
    static TreeMap<String, Boolean> vis= new TreeMap<>();

    static void dfs(String cur){

        vis.put(cur, true);
        System.out.print(cur);


        for (int i=0; i<2; i++){
            String nxt= tree.get(cur).get(i);
            if (!nxt.equals(".") && !vis.get(nxt))
                dfs(nxt); //V
        }
    }

    static void in(String cur){

        vis.put(cur, true);

        String nxt= tree.get(cur).get(0);
        if (!nxt.equals(".") && !vis.get(nxt))
            in(nxt); //V

        System.out.print(cur);

        nxt= tree.get(cur).get(1);
        if (!nxt.equals(".") && !vis.get(nxt))
            in(nxt); //V

    }

    static void post(String cur){

        vis.put(cur, true);

        for (int i=0; i<2; i++){
            String nxt= tree.get(cur).get(i);
            if (!nxt.equals(".") && !vis.get(nxt))
                post(nxt); //V
        }
        System.out.print(cur);
    }


	public static void main(String[] args) throws IOException{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int N= Integer.valueOf(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] input= br.readLine().split(" "); //ipt완료(A,B,C)

            tree.put(input[0], List.of(input[1],input[2])); //tree에 push완료
        }

        for (String i: tree.keySet()){ //7
            vis.put(i, false);
        }
        dfs("A");
        System.out.println();

        for (String i: tree.keySet()){ //7
            vis.put(i, false);
        }
        in("A");
        System.out.println();

        for (String i: tree.keySet()){ //7
            vis.put(i, false);
        }
        post("A");
        System.out.println();

        //VLR: DFS
        //LVR
        //LRV
        //print(l) print(r) dfs(v)

    }
}