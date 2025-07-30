import java.io.*;
import java.util.*;

public class Main {
    static int[] volume;
    static int[][] DP;
    static int N,S,M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        //n개 노래 연주(시작 전 볼륨v[i]:+-로 바꾸기) / vol: 0~m까지만
        StringTokenizer st= new StringTokenizer(br.readLine());
        N= Integer.valueOf(st.nextToken()); S= Integer.valueOf(st.nextToken());
        M= Integer.valueOf(st.nextToken());
        volume= new int[N+1]; DP= new int[N+1][M+1];

        for (int i = 1; i < N+1; i++) {
            Arrays.fill(DP[i],Integer.MIN_VALUE);
        }

        st=new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            volume[i]= Integer.valueOf(st.nextToken());
        }

        System.out.println(search(1, S));	//N개의 볼륨의 차이 조절 후 최대값 저장
        br.close();
    }
    //재귀를 통해서 각 볼륨의 차이를 +, -를 진행하여 모두 조절하였을 때 가장 큰 값을 구하는 함수
    static int search(int index, int value){
        //볼륨의 범위를 벗어난 경우
        if(value > M || value < 0)
            return -1;

        if(index==N+1)	//모든 조절이 끝날 때
            return value;

        if(DP[index][value]!=Integer.MIN_VALUE)	//이미 방문한 볼륨의 크기일 때
            return DP[index][value];

        //DP[][]의 볼륨의 크기를 조절하면서 최대값을 저장
        DP[index][value] = Math.max(DP[index][value],
                Math.max(search(index+1, value + volume[index]), 
                        search(index+1, value-volume[index])));

        return DP[index][value];	//최대값 반환
    }



}
