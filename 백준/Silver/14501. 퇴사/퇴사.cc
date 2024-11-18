#include <bits/stdc++.h>
using namespace std;
#define NMAX 16

//Ti=기간, Pi=금액
int N, Ti, Pi; //Ti는 당일부터 포함
int memoAnsw[NMAX]; //그 일차의 MAX 돈
int memoT[NMAX]; //몇일차(val)에 일 끝?
int memoP[NMAX]; //그 일로 버는 돈?

int main(){ios::sync_with_stdio(false); cin.tie(NULL);
  cin >> N;

  for (int i=1; i<=N; i++){ //input Ti, Pi
    cin >> memoT[i]; memoT[i]+=i-1; //(2일, Ti=5)이면, 6일차에 일 완료
    cin >> memoP[i];
  }

  //Find Max Money=memoAnsw[i] for Day i, 1, 2, 3
  for (int i=1; i<=N; i++){ //i=일차 //input memoAnsw
    memoAnsw[i]=memoAnsw[i-1];
    for (int j=1; j<=N; j++){
      if (memoT[j]==i){ //i일차에 j일의 일 완료 가능시 //6일차에 2일의 일 완료가능할때
         memoAnsw[i]=max(memoAnsw[i], memoAnsw[j-1]+memoP[j]); //6일차: 기존값과 Answ[1]+memoP[2] 비교
      }
    }
  }

  cout << memoAnsw[N];

}