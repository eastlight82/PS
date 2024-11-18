import java.io.*;
import java.util.*;

public class Main {
    static int answ=0;

    static class Node{
        int n;
        int adj;
        int w;

        Node (int n,int adj, int w){
            this.n=n;
            this.adj=adj;
            this.w=w;
        }
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA < rootB) {
            parent.set(rootB, rootA);
        }
        else
            parent.set(rootA,rootB);
    }

    static int find(int a){
        if (parent.get(a)==a) return a;
        else return find(parent.get(a));
    }

    static void kruskal(ArrayList<Node> ls){
        //두개 찝어서 find 비교: 다르면 union
        for (Node i:ls){
            if (find(i.n)!=find(i.adj)){ //cycle 아님;
                answ+=i.w;
                union(i.n, i.adj);
            }
        }
    }

    static ArrayList<Node> ls= new ArrayList<>();
    static ArrayList<Integer> parent= new ArrayList<>();
    //parent[0]=0

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.valueOf(br.readLine());
        int m=Integer.valueOf(br.readLine());

        for (int i=0; i<m; i++){
            String[] a= br.readLine().split(" ");
            ls.add(new Node(Integer.valueOf(a[0]), Integer.valueOf(a[1]),
                    Integer.valueOf(a[2])));
        }

        for (int i = 0; i <= n; i++) {
            parent.add(i);
        }

        Collections.sort(ls, (n1,n2)-> n1.w-n2.w);
        

        kruskal(ls);

        System.out.println(answ);
    }

}