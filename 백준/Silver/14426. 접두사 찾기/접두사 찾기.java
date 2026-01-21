import java.io.*;
import java.util.*;

public class Main {
    static List<String> S= new ArrayList<>();
    static int cnt=0;

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        //n(10000)*m(10000)*startsWith(500)
        String[] brs= br.readLine().split(" ");
        int n=Integer.valueOf(brs[0]);
        int m=Integer.valueOf(brs[1]);

        for (int i = 0; i < n; i++) 
            S.add(br.readLine());
        Collections.sort(S);


        for (int i = 0; i < m; i++) {
            String br_s= br.readLine();
            int idx= Collections.binarySearch(S,br_s);
            if (idx<0) idx=-idx-1; //없을 경우 들어갈 자리
            
            if (idx<S.size() && S.get(idx).startsWith(br_s)) cnt++;
        }

        System.out.println(cnt);

    }
}
