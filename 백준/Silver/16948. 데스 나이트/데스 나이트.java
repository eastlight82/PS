import java.io.*;
import java.util.*;

public class Main {
    static int[] dy= {-2,-2,0,0,2,2};
    static int[] dx= {-1,1,-2,2,-1,1};
    static int[][] board= new int[200][200];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n= Integer.valueOf(br.readLine());
        int r1,c1,r2,c2;
        String[] brs= br.readLine().split(" ");
        r1= Integer.valueOf(brs[0]);
        c1= Integer.valueOf(brs[1]);
        r2= Integer.valueOf(brs[2]);
        c2= Integer.valueOf(brs[3]);

        Queue<int[]> q= new LinkedList<>();
        //bfs
        q.offer(new int[]{r1,c1}); //array객체기에 new로 추가
        board[r1][c1]=1;
        while (!q.isEmpty()){
            int[] cur= q.poll();

            for (int i = 0; i < 6; i++) {
                int[] nxt= {cur[0]+dy[i], cur[1]+dx[i]};
                if (nxt[0]>=0 && nxt[0]<n && nxt[1]>=0 && nxt[1]<n && board[nxt[0]][nxt[1]]==0){
                    board[nxt[0]][nxt[1]]= board[cur[0]][cur[1]]+1;
//                    System.out.println(nxt[0]+" "+nxt[1]+" "+board[nxt[0]][nxt[1]]);
                    q.offer(nxt);
                }
            }
        }

        System.out.println(board[r2][c2]-1);

    }
}
