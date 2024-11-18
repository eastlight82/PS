//중요점: 맨처음 dp에 값 기입할때, dp[1]=1, dp[2]=2... 이렇게 기본값 세팅해주기

#include <bits/stdc++.h>
using namespace std;
#define MAX 100001

int N; //자연수(제곱으로 표현해야함)
int memoCnt[MAX];

int main(){ios::sync_with_stdio(false); cin.tie(NULL);
  cin >> N;

  for (int i=0; i<=N; i++)
    memoCnt[i]=i;

  for (int i=0; i<=N; i++){ //i=32: 최대가 25, 16, 9 다 계산
    for (int j=1; j*j<=i; j++){
      memoCnt[i]= min(memoCnt[i], memoCnt[i-j*j]+1); //memoCnt[j*j]=1;
    }
  }
  
  cout << memoCnt[N];
}