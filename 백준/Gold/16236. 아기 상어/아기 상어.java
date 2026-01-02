import java.io.*;
import java.util.*;

public class Main {
    static class Shark {
        int y, x, size, time;

        Shark(int y, int x, int size, int time){
            this.y=y; this.x=x; this.size=size; this.time=time;
        }
    }
    static class Fish implements Comparable<Fish> {
        int y, x, dist;

        Fish(int y, int x, int dist){
            this.y=y; this.x=x; this.dist=dist;
        }

        @Override //거리: 상->좌
        public int compareTo(Fish o){
            int diff= this.dist-o.dist; //거리 가까운거
            if (diff==0) diff=this.y-o.y; //상->좌 (더 작은값)
            return diff==0 ? this.x-o.x : diff;
        }
    }
    static int[][] board;
    static int n;
    static Shark curPosShark;
    static int eatenSize; //먹힌 물고기 크기
    static int[] dy= {-1,0,1,0};
    static int[] dx= {0,-1,0,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //n*n에 물고기m, 아기상어9(크기:2(+1), 자기보다 큰 고기x, 같 먹기만)
        //가장 가까운 고기 먹으러감, 거리: 상->좌
        //물고기 먹을수있는 시간

        n= Integer.valueOf(br.readLine());
        board= new int[n][n];

        //input(y,x)
        for (int i = 0; i < n; i++) {
            st= new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j]= Integer.valueOf(st.nextToken());

                if (board[i][j]==9) curPosShark= new Shark(i,j,2,0);
            }
        }

        //bfs(물고기 먹방):
        while (true) {
            if (!bfs()) break; //먹을수 있는 물고기 있는지 여부

            if (++eatenSize == curPosShark.size) {
                curPosShark.size++;
                eatenSize=0; //reset
            }
        }

        //결과 출력
        System.out.println(curPosShark.time);

    }

    static boolean bfs(){
        List<Fish> fList= new ArrayList<>();
        PriorityQueue<Shark> q= new PriorityQueue<>(new Comparator<Shark>() {
            @Override
            public int compare(Shark o1, Shark o2) {
                int diff= o1.time-o2.time; //더 가까운거
                if (diff == 0) diff= o1.y - o2.y; //상->좌
                return diff== 0 ? o1.x - o2.x : diff;
            }
        });
        q.offer(curPosShark);
        boolean[][] visit= new boolean[n][n];

        while (!q.isEmpty()) {
            Shark s= q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = s.y + dy[i];
                int nx = s.x + dx[i];

                if (0 <= ny && ny < n && 0 <= nx && nx < n && board[ny][nx] <= s.size && !visit[ny][nx]) {
                    //모든 먹o fish 추가, 거기로 간 shark 추가
                    if (board[ny][nx] != 0 && board[ny][nx] != 9 && board[ny][nx] < s.size) {
                        fList.add(new Fish(ny, nx, s.time + 1));
                    }
                    q.offer(new Shark(ny, nx, s.size, s.time + 1));
                    visit[ny][nx] = true;
                }
            }
        }
        if (fList.isEmpty()) { //fish없으면 먹을거 없는거
            return false;
        } else {
            Collections.sort(fList); //가장 가까운 기준 sort
            Fish f = fList.get(0);
            board[curPosShark.y][curPosShark.x] = 0;
            board[f.y][f.x] = 9;
            curPosShark = new Shark(f.y, f.x, curPosShark.size, f.dist);
            return true;
        }
    }
}