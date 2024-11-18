#include <bits/stdc++.h>
using namespace std;
#define MAX 100001

int N; //정수 개수
int seq[MAX]; //수열
int memoVal[MAX];

int main(){ios::sync_with_stdio(false); cin.tie(NULL);
  cin >> N;
  for (int i=0; i<N; i++){
    cin >> seq[i];
  } //input 완료

  //"수열값을 마지막"으로 하는 연속합들중 "max": memoVal
  // 그 memoVal들의 Max: MaxVal

  int MaxVal= seq[0]; memoVal[0]=seq[0];
  for (int i=1; i<N; i++){
    //memoVal[i-1](앞의 연속합)이 +-?
    if (memoVal[i-1]>=0){
      memoVal[i]= memoVal[i-1]+seq[i];
    }
    else
      memoVal[i]=seq[i];

    MaxVal= max(MaxVal, memoVal[i]);
  }

  cout << MaxVal;

}