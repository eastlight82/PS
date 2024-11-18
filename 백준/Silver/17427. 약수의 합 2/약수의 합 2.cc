#include <bits/stdc++.h>
using namespace std;

int N;

int main(){ios::sync_with_stdio(false); cin.tie(NULL);
  cin >> N; long long answ=0;
  //g(N)= f(1)+...f(N) //f(1)=1 f(2)=1+2 f(3)=1+3 f(4)=1+2+4 f
  //g(N)= 1*7+ 2*3+ 3*2 

  for (int i=1; i<=N; i++){
    answ+=i*(N/i); //값*개수
  }

  cout << answ;
}

