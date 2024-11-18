import com.sun.source.tree.IdentifierTree;

import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        //용액: 산성, 알칼리- 각 용액별 int(1~10억, -1~-10억)
        //두 용액 +(산, 알 같이 써도 됨): "목표: 0에 가깝게"

        int n= Integer.parseInt(br.readLine());
        //용액값
        String[] brs= br.readLine().split(" ");
        List<Integer> vals= new ArrayList<>();
        for (String i : brs)
            vals.add(Integer.valueOf(i));

        Collections.sort(vals);

        int ptr1=0, ptr2=vals.size()-1;
        int answSum=Integer.MAX_VALUE; //답: min
        int answ1=0, answ2=0;
        while (ptr1<ptr2){
            int ptrSum= vals.get(ptr1)+vals.get(ptr2);
            //ptrSum이 양수면 2--, 음수면 1++

            int valDiff= Math.abs(0-ptrSum);
            if (answSum>valDiff){
                answ1=vals.get(ptr1); answ2=vals.get(ptr2);
                answSum= valDiff;
            }

            if (ptrSum<0)
                ptr1++;
            else if (ptrSum>0)
                ptr2--;
            else
                break;
        }

        System.out.println(answ1+" "+answ2);
    }
}
