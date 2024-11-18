import com.sun.source.tree.IdentifierTree;

import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        //소수의 연속합
        //int를 연속prime의 Sum으로 나타내기(같은건 1번)
        //에라체: 4백만: 2000까지 계산

        int targ= Integer.valueOf(br.readLine());
        List<Integer> primes= new ArrayList<>(List.of(2));
        for (int i = 3; i < 4000000; i=i+2) { //4백만까지 prime계산
            boolean isPrime=true;
            for (int j = 3; j <= 2000; j=j+2) { //약수chk
                if (i<=j) break;

                if (i%j==0){
                    isPrime=false;
                    break;
                }
            }

            if (isPrime) primes.add(i);
        }

        int p1=0, p2=1;
        int sum=primes.get(p1);
        int answCnt=0;
        //{2,3,5,7,11,13,17}

        while (p2<=primes.size() && p1<primes.size()){
            if (primes.get(p1)>targ) break;

            if (sum>targ){ //보다 큼
                sum-=primes.get(p1++);
            }
            else if (sum==targ) { //보다 ==
                answCnt++;
                sum-=primes.get(p1++);
            }
            else {
                if (p2==primes.size()) break;
                sum+=primes.get(p2++);
            }
        }
        System.out.println(answCnt);

    }
}
