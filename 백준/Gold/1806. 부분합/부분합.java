import com.sun.source.tree.IdentifierTree;

import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        //n짜리 nums, sum으로 targ값이 나오는 최소#
        String[] brs= br.readLine().split(" ");
        int numsLen= Integer.parseInt(brs[0]);
        int targ= Integer.parseInt(brs[1]);

        brs= br.readLine().split(" ");
        List<Integer> nums= new ArrayList<>();
        for (String i: brs){
            nums.add(Integer.parseInt(i));
        }
//        [15,16,17] 5
        //15(0,1)-> 0(1,1)-> 16(1,2)-> 0(2,2)-> 17(2,3)-> 0(3,3)
//        [0,1,3] 3
        //0(0,1)-> 1(0,2)-> 4(0,3)-> 4(1,3)-> 3(2,3)-> 0(3,3)
        int ptr1=0, ptr2=1; //끝: ptr2-1
        int ptrSum= nums.get(ptr1); //5로 sum 시작

        int minLen=Integer.MAX_VALUE;

        while (ptr2<=nums.size() && ptr1<nums.size()){ //종료조건: ptr2가 끝값까지
            // 고려case: 끝이 크,같, 시작이 작
//            System.out.print(ptrSum+" "+ptr1+" "+ptr2+" "); //debug

            if (ptrSum<targ){ //커져야: p2++
                if (ptr2==nums.size())
                    break;
                ptrSum+=nums.get(ptr2++);
            }
            else if (ptrSum>=targ){ //작아져야: p1++ //자연수: 0 x-> 작아지면 작, 커지면 커(같을 일x)
                minLen= Math.min(minLen, ptr2-ptr1);
                ptrSum-=nums.get(ptr1++);
            }

//            System.out.println(minLen);
        }

        if (minLen==Integer.MAX_VALUE)
            System.out.println(0);

        else
            System.out.println(minLen);

    }
}
