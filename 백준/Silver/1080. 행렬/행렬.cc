//3점: 문자열 오류 주의하기
//Greedy로 되는 이유: 어차피 초반부(다시 올일 없음)가 불일치시 무조건 rev해야함
#include <bits/stdc++.h>
using namespace std;

int N,M, cnt=0; //N*M
vector <string> A; vector <string> B; //3*3으로 A->B

void reverMat(int y, int x){ //A에서 x,y를 첫값으로 하고, 3*3만큼 rever

  if (y+3<=N && x+3<=M){ //3*3 만족시에만
    for (int i=y; i<y+3; i++){
      for (int j=x; j<x+3; j++)
        A[i][j]= (A[i][j]=='1') ? '0' : '1'; //*문자열 오류 주의
    }
    cnt++;
  }
  
}

int main(){ios::sync_with_stdio(false); cin.tie(NULL);
  cin >> N >> M;
  string str;

  for (int i=0; i<N; i++){
    cin >> str;
    A.push_back(str);
  }
  
  for (int i=0; i<N; i++){
    cin >> str;
    B.push_back(str);
  }//cin:완료

  //어차피 (0,0)~(범위끝)까지 비교해서 바꾸기
  for (int i=0; i<=N-3; i++){
    for (int j=0; j<=M-3; j++){
      if (A[i][j]!=B[i][j])
        reverMat(i,j);
    }
  }

  //chk: 전체 다 해야함
  bool sameChk=true;
  for (int i=0; i<N; i++){
    for (int j=0; j<M; j++){
      if (A[i][j]!=B[i][j]){
        sameChk=false;
        break; //*끝났으니 break
      }
    }
    if (!sameChk) break;
  }

  if (sameChk)
    cout << cnt;
  
  else 
    cout << -1;

}