//1점: n바꿀때<-n+1 누르기로 greedy 적용/ *변수는 첫switch(마지막 switch x)
#include <bits/stdc++.h>
using namespace std;

int N, cnt, answ=INT_MAX; //스위치, 전구#
//i번 스위치-> i-1, i, i+1 바뀜
string A, B;

void swClick(int swNum, string &val){  //*&val로 줘야 원본이 감
  cnt++;
  val[swNum]= (val[swNum]=='0')? '1': '0'; //중간 저장값
  
  if (swNum==1)
    val[swNum+1]=(val[swNum+1]=='0')? '1': '0';
  
  else if (swNum==N)
    val[swNum-1]=(val[swNum-1]=='0')? '1': '0'; 
  
  else {
    val[swNum-1]=(val[swNum-1]=='0')? '1': '0'; 
    val[swNum+1]=(val[swNum+1]=='0')? '1': '0';
  }
}

void clickFirst(bool click){ //exe+test함수
  string tmp= A; cnt=0;

  if (click)
    swClick(1,tmp);

  for (int i=1; i<=N-1; i++){ //*First Click했으니, 첫idx부터 고려
    if (tmp[i]!=B[i])
      swClick(i+1, tmp);
  }

  if (tmp==B) answ=min(answ,cnt);
}

int main(){ios::sync_with_stdio(false); cin.tie(NULL);
  cin >> N >> A >> B;
  A="0"+A; B="0"+B; //cin:완료

  //Greedy: 맨앞부터 동일하게 만들어주기
  //1: n번째 변경<-n+1번째 누르기
  //2: 맨 첫번째 누를지말지
  
  clickFirst(true); clickFirst(false);

  if (answ==INT_MAX) //* ==주의
    cout << -1;

  else
    cout << answ; 
}