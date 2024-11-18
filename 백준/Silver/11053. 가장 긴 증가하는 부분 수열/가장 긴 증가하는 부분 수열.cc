#include <bits/stdc++.h>
using namespace std;
#define MAX 1001

int N, maxVal=1; //Seq A's #
vector <int> A; //Seq
vector <int> maxCnt;

int main(){ios::sync_with_stdio(false); cin.tie(NULL);
  cin >> N;
  //1. 1번끝, 2번끝의 MAX_CNT 저장
  //2. 어떤 번이 가장 큰지
  for (int i=0; i<N; i++){
    A.push_back(0);
    cin >> A[i];
  }

  for (int i=0; i<N; i++){
    maxCnt.push_back(1);
  }

  for (int curr=1; curr<N; curr++){
    for (int bef=0; bef<curr; bef++){

      if (A[curr]>A[bef]){ //증가하면 maxCnt[curr]값 바꿔야
        maxCnt[curr]=max(maxCnt[curr],maxCnt[bef]+1); //curr=10:[3], bef=7:[3]
      }
    }
    maxVal=max(maxVal, maxCnt[curr]);
  }
  cout << maxVal;
}