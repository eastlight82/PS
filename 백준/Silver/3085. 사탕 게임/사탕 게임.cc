#include <bits/stdc++.h>
using namespace std;
#define MAX 51

int N, maxCnt=0; //크기, candyMAX#
string s[MAX]; //보드

//2. maxCnt 계산
void calcSameRow(){
  for (int i=0; i<N; i++){
    int cnt=1;

    for (int j=0; j<N; j++){//가로
      if (s[i][j]==s[i][j+1])
        cnt++;

      else {
        maxCnt = max(maxCnt, cnt);
        cnt=1; //!=면 cnt=1로 초기화
      }
    }
  }
}

void calcSameCol(){
  for (int i=0; i<N; i++){
    int cnt=1;

    for (int j=0; j<N; j++){//가로
      if (s[j][i]==s[j+1][i])
        cnt++;

      else {
        maxCnt = max(maxCnt, cnt);
        cnt=1; //!=면 cnt=1로 초기화
      }   
    }
  }
}


int main(){ios::sync_with_stdio(false); cin.tie(NULL);
  cin >> N;
  for (int i=0; i<N; i++) //보드 입력
    cin >> s[i];
  

  //한가지 swap-> maxCnt 계산
  for (int i=0; i<N; i++){
    for (int j=0; j<N-1; j++){//가로
    //swap->복구, swap->복구
      swap(s[i][j], s[i][j+1]); //: 다른 열끼리 swap
      calcSameRow(); calcSameCol();
      swap(s[i][j], s[i][j+1]); 

      swap(s[j][i], s[j+1][i]); //: 다른 행끼리 swap
      calcSameRow(); calcSameCol();
      swap(s[j][i], s[j+1][i]);
    }
  }

  cout << maxCnt;
}