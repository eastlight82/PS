import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        //n개의 수열, ai+j= x만족하는 쌍의 수

        int n= Integer.valueOf(br.readLine());

        String[] brs= br.readLine().split(" ");
        List<Integer> nums= new ArrayList<>();
        for (String i: brs)
            nums.add(Integer.valueOf(i));
        Collections.sort(nums);

        int x= Integer.valueOf(br.readLine());

        int ptr1= 0, ptr2= nums.size()-1;
        int answCnt=0;
//        [1,2,3,5,7,9,10,11,12]

        while (ptr1<ptr2){
            int ptrSum= nums.get(ptr1)+nums.get(ptr2);
            if (ptrSum==x){
                answCnt++;
                ptr1++; //서로 다른 nums, 아무거나 더해도 상관x
            }
            else if (ptrSum<x) //작은값 늘리기
                ptr1++;

            else {
                ptr2--;
            }
        }
        System.out.println(answCnt);


    }
}
