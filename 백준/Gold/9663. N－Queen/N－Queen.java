import java.io.*;
import java.util.*;

public class Main {
    static int[] graph;
    static int n;
    static int rslt=0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //n*n에 서로 공격x: 경우#
        //(+2,+1): x와 y의 증가값 달라야
        n= Integer.valueOf(br.readLine());

        graph= new int[n]; //값: 각 row들이 몇번col(값)
        //row0, 1, 2, 3
        dfs(0);
        
        System.out.println(rslt);
    }

    public static void dfs(int rowDepth){
        //rtn 조건: rslt++
        if (rowDepth==n){
            rslt++;
            return;
        }

        //dfs
        for (int i = 0; i < n; i++) { //0~3
            graph[rowDepth]=i; //(1,1)

            if (possible(rowDepth)){
                dfs(rowDepth+1);
            }
        }
    }
    //ex: row5까지
    //row6를 0,1,2,3,4,5까지 박아주고,
    // 모든 (6,col값) 각각 possible검사
    // -> if t: dfs(rowDepth+1)

    //0,1,2,3 확인
    public static boolean possible(int rows){
        //모든게 다 일치해야
        for (int i = 0; i < rows; i++) {
            //row일치: 당연 없음
            //col일치: 이전 graph[rows]중 있는지
            if (graph[i]==graph[rows]) //row번째 값 일치
                return false;

            //diag일치 graph[1]=2경우, 0:1,3/ 2:1,3/ 3:0
            //Math.abs(graph[1]-graph[0])=2-3
            else if (Math.abs(graph[rows]-graph[i])==Math.abs(rows-i))
                return false;
        }

        return true;
    }

}
