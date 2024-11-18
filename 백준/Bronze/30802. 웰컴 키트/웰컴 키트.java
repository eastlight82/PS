import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 참가자 수 N 입력
        int N = Integer.valueOf(br.readLine());

        // 티셔츠 사이즈별 신청자 수 입력
        List<String> ls = List.of(br.readLine().split(" "));
        List<Integer> sizeCnt = new ArrayList<>();
        for (String s : ls) {
            sizeCnt.add(Integer.valueOf(s));
        }

        // 티셔츠와 펜의 묶음 수 입력
        ls = List.of(br.readLine().split(" "));
        int T = Integer.valueOf(ls.get(0));
        int P = Integer.valueOf(ls.get(1));

        // 티셔츠 묶음 계산
        int tCnt = 0;
        for (int count : sizeCnt) {
            tCnt += count / T;
            if (count % T != 0) {
                tCnt++;  // 나누어 떨어지지 않으면 묶음을 하나 더 추가
            }
        }

        // 펜 묶음 계산
        int sum = sizeCnt.stream().mapToInt(Integer::intValue).sum();  // 전체 참가자 수 (N과 동일)
        int pBundles = sum / P;  // 펜 묶음 수
        int pSingles = sum % P;  // 나머지 펜의 수

        // 출력
        System.out.println(tCnt);  // 티셔츠 묶음 수 출력
        System.out.println(pBundles + " " + pSingles);  // 펜 묶음 수와 나머지 펜의 수 출력
    }
}
