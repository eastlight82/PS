import java.io.*;
import java.util.*;

public class Main {
    static boolean vis[][]= new boolean[2001][2001];
    static int S;

    static Queue<Ect> q= new LinkedList<Ect>();
    static class Ect{
        int total;
        int clipboard;
        int t;

        public Ect(int total, int clipboard, int t) {
            this.total = total;
            this.clipboard = clipboard; //[3,4]-> 붙[3+4,4] 복[3,4->3] //until S=total
            this.t= t;
        }

        //>S여도 가능한것 아닌가
        void addPaste(Ect ect){
            if (ect.total+ect.clipboard<=S && !vis[ect.total+ect.clipboard][ect.clipboard]){
                q.offer(new Ect(ect.total+ect.clipboard, ect.clipboard, ect.t+1));
                vis[ect.total][ect.clipboard]=true;
            }
        }

        void addCopy(Ect ect){
            if (!vis[ect.total][ect.total]) {
                q.offer(new Ect(ect.total, ect.total, ect.t + 1));
                vis[ect.total][ect.clipboard] = true;
            }
        }

        //-되는 경우 처리
        void addDelete(Ect ect){
            if (ect.total>=1 && !vis[ect.total-1][ect.clipboard]){
                q.offer(new Ect(ect.total-1, ect.clipboard, ect.t+1));
                vis[ect.total][ect.clipboard] = true;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        //goal: 스마일_emoji 5개 최솟값
        //given: emoji 1개, 3가지 연산당 1초(emoji모두 복사, 붙여넣기/ 하나 삭제)
        //var: total, copy_val, 소모t

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        S= Integer.valueOf(br.readLine());

        q.offer(new Ect(1,0, 0));
        vis[1][0]=true;

        while (!q.isEmpty()){
            Ect cur= q.poll();
            //nxt 넣기: 복, 붙
            if (cur.total<S){
                cur.addPaste(cur);
                cur.addCopy(cur);
                cur.addDelete(cur);

                continue;
            }
            else if (cur.total==S){
                System.out.println(cur.t);
                return;
            }
            else
                cur.addDelete(cur);

        }

    }

}
