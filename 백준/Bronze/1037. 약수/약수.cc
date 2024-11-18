#include <bits/stdc++.h>
using namespace std;

int main(){ios_base::sync_with_stdio(false); cin.tie(NULL);

//진짜 약수 개수: a^x*b^y->(x+1*y+1)-2
//진짜 약수: a^1*b^0, a^2*b^0, a^0*b^1: 가장 큰, 작은거 두 개 찾기

int divNumCnt;
int a, maxs=1, mins=1000000;

cin >> divNumCnt; //개수, 약수들 입력받기
while (divNumCnt--){
  cin >> a;

  maxs=max(maxs,a);
  mins=min(mins,a);
} 

cout << maxs*mins;


}