import java.io.*;
import java.util.*;

public class Main {
    static int n,max;
    static List<Integer> ws= new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //구슬n개 일렬(i번째 무게 Wi)
        //x번째 구슬 제거(Wx-1* Wx+1 에너지)-> n--, 다시 1~n번

        n= Integer.valueOf(br.readLine());
        st= new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) 
            ws.add(Integer.valueOf(st.nextToken()));

        rec(0);
        System.out.println(max);
    }

    static public void rec(int sum) {
        if (ws.size()==2) {
            if (sum>max) max=sum;
            return;
        }

        for (int i = 1; i < ws.size()-1; i++) {
            int a=ws.remove(i);
            rec(sum+ws.get(i-1)*ws.get(i));
            ws.add(i,a);
        }
    }
}
