import java.io.*;
import java.util.*;

public class Main {
    static int n, max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
    static List<Integer> nums= new ArrayList<>();
    static StringBuilder operators= new StringBuilder();
    static boolean vis[];

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 

        //수열(n수, n-1연산자), 연산자 순열: 5!/동일2!
        n= Integer.valueOf(br.readLine());
        vis= new boolean[n-1];

        st= new StringTokenizer(br.readLine());
        while (st.hasMoreTokens())
            nums.add(Integer.valueOf(st.nextToken()));
        
        String[] brs= br.readLine().split(" ");
        operators.append("+".repeat(Integer.valueOf(brs[0])));
        operators.append("-".repeat(Integer.valueOf(brs[1])));
        operators.append("*".repeat(Integer.valueOf(brs[2])));
        operators.append("/".repeat(Integer.valueOf(brs[3])));
        
        rec(nums.get(0), 0);
        
        System.out.println(max+"\n"+min);
    }  
    
    static void rec(int sum, int depth) {
        if (depth==n-1) {
            // System.out.println(sum);
            if (sum>max) max=sum;
            if (sum<min) min=sum;
        }
        
        //++--*, 1 2 3 4 5 6
        for (int i = 0; i < n-1; i++) {
            if (vis[i]) continue;

            vis[i]=true;
            switch (operators.charAt(i)) {
                case '+': rec(sum+nums.get(depth+1),depth+1); 
                break;
                case '-': rec(sum-nums.get(depth+1),depth+1); 
                break;
                case '*': rec(sum*nums.get(depth+1),depth+1); 
                break;
                case '/': rec(sum/nums.get(depth+1),depth+1);
            }
            vis[i]=false;
        }
    }
}