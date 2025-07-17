import java.io.*;
import java.util.*;

public class Main {
    static class Stone{
        int a,b,c;

        Stone(int a, int b, int c){
            this.a=a; this.b=b; this.c=c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //돌: 3group(a,b,c개): 돌# 같게 //x(적), y(많): x+x, y-x
        //그냥 다 해보기
        String[] brs= br.readLine().split(" ");
        int a= Integer.valueOf(brs[0]); int b= Integer.valueOf(brs[1]); int c= Integer.valueOf(brs[2]);

        System.out.println(bfs(a,b,c) ? 1 : 0);
    }

    static boolean bfs(int a, int b, int c){
        if ((a+b+c)%3!=0)
            return false;

        Queue<Stone> q= new LinkedList<>();
        boolean[][] ab= new boolean[1501][1501];
        q.add(new Stone(a,b,c));

        while (!q.isEmpty()){
            Stone s= q.poll();
            ab[s.a][s.b]=true;

            if (s.a==s.b && s.b==s.c)
                return true;

            if (s.a<s.b && !ab[2*s.a][s.b-s.a]){
                q.add(new Stone(2*s.a, s.b-s.a, s.c));
                ab[2*s.a][s.b-s.a]=true; //matroid전 vis방지
            }

            else if (s.a>s.b && !ab[s.a-s.b][2*s.b]){
                q.add(new Stone(s.a-s.b, 2*s.b, s.c));
                ab[s.a-s.b][2*s.b]=true;
            }

            if (s.b>s.c && !ab[s.a][s.b-s.c]){
                q.add(new Stone(s.a, s.b-s.c, 2*s.c));
                ab[s.a][s.b-s.c]=true;
            }

            else if (s.b<s.c && !ab[s.a][2*s.b]){
                q.add(new Stone(s.a, 2*s.b, s.c-s.b));
                ab[s.a][2*s.b]=true;
            }

            if (s.c>s.a && !ab[2*s.a][s.b]){
                q.add(new Stone(2*s.a, s.b, s.c-s.a));
                ab[2*s.a][s.b]=true;
            }

            else if (s.c<s.a && !ab[s.a-s.c][s.b]){
                q.add(new Stone(s.a-s.c, s.b, 2*s.c));
                ab[s.a-s.c][s.b]=true;
            }
        }
        return false;
    }
}
