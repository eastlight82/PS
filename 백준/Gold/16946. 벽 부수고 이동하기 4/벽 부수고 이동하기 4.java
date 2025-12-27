import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static char[][] board;
    static int[] dx= {1,0,0,-1};
    static int[] dy= {0,1,-1,0};

    static int[][] group;
    static HashMap<Integer, Integer> hm= new HashMap<>(); //
    static class coor{
        int y, x;

        coor(int y, int x){
            this.y=y; this.x=x;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //n*m행렬, 0은 o, 1은 벽, 다른 칸 가려면 인접
        //벽 부수고 이동 가능한 칸
        //sol: 0그룹끼리 뭉치고 bfs

        String[] brs= br.readLine().split(" ");
        n=Integer.valueOf(brs[0]); //r값
        m=Integer.valueOf(brs[1]); //c값
        board= new char[n][m];
        group= new int[n][m];

        //input값 저장
        for (int i = 0; i < n; i++) {
            board[i]= br.readLine().toCharArray(); //char 자동ls화
        }

        int idx=1;
        //0그룹 뭉치기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j]=='0' && group[i][j]==0){
                    hm.put(idx, bfs(i,j,idx));
                    idx++;
                }
            }
        }

        //결과 print
        StringBuffer sb= new StringBuffer();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(mapCnt(i,j));
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    //결과 print
    static int mapCnt(int Y, int X){
        int sum=1;
        HashSet<Integer> hs= new HashSet<>();

        if (board[Y][X]=='0'){
            return 0;
        }

        for (int i = 0; i < 4; i++) {
            coor nxt= new coor(Y+dy[i],X+dx[i]);

            if (nxt.y>=0 && nxt.y<n && nxt.x>=0 && nxt.x<m && group[nxt.y][nxt.x]!=0 && board[nxt.y][nxt.x]=='0')
                hs.add(group[nxt.y][nxt.x]);
        }

        for (Integer h : hs) {
            sum+= hm.get(h);
        }

        return sum%10;
    }

    //0 그룹화하기
    static int bfs(int b, int a, int groupNum){
        int cnt=1;
        Queue<coor> q= new LinkedList<>();
        q.offer(new coor(b,a));
        group[b][a]= groupNum;

        while (!q.isEmpty()){
            coor cur= q.poll();

            for (int k = 0; k < 4; k++) {
                coor nxt= new coor(cur.y+dy[k],cur.x+dx[k]);
                if (nxt.y>=0 && nxt.y<n && nxt.x>=0 && nxt.x<m && board[nxt.y][nxt.x]=='0' && group[nxt.y][nxt.x]==0) {
                    q.offer(new coor(nxt.y,nxt.x));
                    group[nxt.y][nxt.x]=groupNum;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}


