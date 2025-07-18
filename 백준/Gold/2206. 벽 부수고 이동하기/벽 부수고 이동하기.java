import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder[] graph;
    static int n, m;
    static int[][] dXY= {{0,1},{0,-1},{1,0},{-1,0}};
    static int minDist= Integer.MAX_VALUE;

    static class Coordinate{
        int x, y, dist;
        boolean broke;

        Coordinate(int x, int y, int dist, boolean broke){
            this.x=x; this.y=y; this.dist=dist; this.broke=broke;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //graph n*m(0:이동o, 1:x) //1,1->n,m을 min로
        //1개까지 부수기o
        StringTokenizer st= new StringTokenizer(br.readLine());
        n= Integer.valueOf(st.nextToken()); m= Integer.valueOf(st.nextToken());
        graph= new StringBuilder[n];

        for (int i = 0; i < n; i++){
            String brs= br.readLine();
            graph[i]= new StringBuilder(brs);
        }

        bfs();
    }

    static void bfs(){
        Queue<Coordinate> q= new LinkedList<>();
        boolean[][][] vis= new boolean[n][m][2]; //0: xbroke, 1: broke
        q.offer(new Coordinate(0,0, 1, false));

        while (!q.isEmpty()){
            Coordinate cur= q.poll(); //cur.x cur.y
            if (cur.x==(n-1) && cur.y==(m-1)){
                System.out.println(cur.dist); //vis여부 저장해서 바로 출력
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nX= cur.x+dXY[i][0]; int nY= cur.y+dXY[i][1]; int nxtDist= cur.dist+1;

                if (nX>=0 && nX<n && nY>=0 && nY<m){
                    if (graph[nX].charAt(nY)=='0'){
                        if (!cur.broke && !vis[nX][nY][0]){
                            q.offer(new Coordinate(nX,nY,nxtDist,false));
                            vis[nX][nY][0]=true;
                        }
                        else if (cur.broke && !vis[nX][nY][1]){
                            q.offer(new Coordinate(nX,nY,nxtDist,true));
                            vis[nX][nY][1]=true;
                        }
                    }
                    else {
                        if (!cur.broke){
                            q.offer(new Coordinate(nX,nY,nxtDist,true));
//                            vis[nX][nY][1]=true;
                        }

                    }
                }
            }

        }
        System.out.println(-1);
    }


}
