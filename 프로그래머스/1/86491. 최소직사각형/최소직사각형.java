import java.io.*;
import java.util.*;

class Solution {
    //큰값을 한쪽으로 몰기
    public int solution(int[][] sizes) {
        int answer = 0;
        //[60, 80]
        int x=0, y=0;
        
        for (int[] s: sizes){
            int x_q=Math.max(s[0],s[1]);
            int y_q=Math.min(s[0],s[1]);
            
            x= Math.max(x_q, x);
            y= Math.max(y_q, y);
        }
        answer= x*y;
        
        return answer;
    }
}