import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> broken= new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //버튼: 0~9, +, -/ 현재 100-> N가는 수
        int N= Integer.valueOf(br.readLine());
        int M= Integer.valueOf(br.readLine());

        if (M!=0){
            StringTokenizer st= new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int broke= Integer.valueOf(st.nextToken());
                broken.add(broke);
            }
        }

        //가장 가까운 값: N에서 1씩 +-하며 cnt세기 -> 100+-와 비교
        int ansP= N, ansM=N;
        double cnt=0; int ans2= Math.abs(100-N);

        boolean flagM=true, flagP=true; int tmp_ansM=ansM, tmp_ansP=ansP;
        //자릿수 계산(/10=0일때)
        while (true){//계속 +-하기
            flagM=true; flagP=true; tmp_ansM=ansM; tmp_ansP=ansP;
            //거르는 조건: 각_자릿수 비교
            while (tmp_ansM>0) {
                if (broken.contains(tmp_ansM%10)){
                    flagM=false; //조건 불만족
                    break;
                }
                tmp_ansM/=10;
            }
            //if 만족
            if (flagM){
                if ((ansM==0 && broken.contains(0)) || (ansM<0)) {
                }
                else break;
            }

            while (tmp_ansP!=0) {
                if (broken.contains(tmp_ansP%10)){
                    flagP=false; //조건 불만족
                    break;
                }
                tmp_ansP/=10;
            }
            if (flagP){
                if ((ansP==0 && broken.contains(0)) || (ansP<0)) {
                }
                else break;
            }

            ansP++; ansM--; cnt++;
            if (cnt>=ans2)
                break;
        }

        int digits=0;
        if (flagM){
            for (int i = 10; i <= 1000000; i*=10) {
                digits++;
                if (ansM/i==0)
                    break;
            }
        }
        else {
            for (int i = 10; i <= 1000000; i*=10) {
                digits++;
                if (ansP/i==0)
                    break;
            }
        }

        int ans1= (int)(cnt+digits);


        System.out.println((Math.min(ans1, ans2)));


    }
}
