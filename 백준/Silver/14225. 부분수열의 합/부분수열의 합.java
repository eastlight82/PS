import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] possible;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        // 만들 수 있는 합의 최대는 total (모든 수 다 더한 값)
        possible = new boolean[total + 2]; // +2는 안전하게

        dfs(0, 0);

        int ans = 1;
        while (ans < possible.length && possible[ans]) ans++;
        System.out.println(ans);
    }

    static void dfs(int idx, int sum) {
        if (idx == N) {
            if (sum > 0) possible[sum] = true; // 자연수만 체크
            return;
        }

        // 1) idx 원소 선택 X
        dfs(idx + 1, sum);

        // 2) idx 원소 선택 O
        dfs(idx + 1, sum + arr[idx]);
    }
}
