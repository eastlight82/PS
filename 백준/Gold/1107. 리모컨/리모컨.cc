//1점, BruteForce는 과감하게
#include <bits/stdc++.h>
using namespace std;

int N, M, ch=100; //Chnl값, BrokeBtn#, dfltChnl
int broke[10];

bool chPosb(int x){

  string val=to_string(x);

  for (int i=0; i<val.size(); i++){
    if (broke[val[i]-'0']==1)
      return false;
  }

  return true;
}



int main(){ios::sync_with_stdio(false); cin.tie(NULL);
  cin >>N >>M;

  int brokeVal;
  for (int i=0; i<M; i++){
    cin >> brokeVal;
    broke[brokeVal]=1; //brokeBtn은 다 1로 저장함
  }//BrokeBtn input완료

  //방법1: 100+-, 방법2: 초기 ch 설정 후 +-

  //방법1
  int answ= abs(N-ch); //+-할 횟수

  //방법2: 100만까지 BruForce

  for (int i=0; i<=1000000; i++){ //ch가 50만까지니, 초기 input ch는 100만
    if (chPosb(i)){//brokeBtn 없음
      int iCnt= abs(N-i)+to_string(i).size(); //+-횟수 + 길이

      answ=min(answ, iCnt);
    }
  }

  cout << answ;

}