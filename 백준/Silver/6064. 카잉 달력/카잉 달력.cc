//answ%N는 0~N-1이고, y는 "1~N". 따라서 y도 %12.
#include <bits/stdc++.h>
using namespace std;

int M, N, x, y, T;
long long answ;

long long gcdCalc(int M, int N){
  if (N==0)
    return M;

  return gcdCalc(N, M%N);
}

int main(){ios::sync_with_stdio(false); cin.tie(NULL);
  cin >> T; 
  while (T--){
    cin >>M >>N >>x >>y; //input완료, <x,y>
    //answ= M*ㅁ+x= N*ㅁ+y
    int a,b; //ㅁ역할
    long long gcd= gcdCalc(M,N);
    long long lcm= M*N/gcd;

    for (answ=x; ; answ+=M){ //항상 answ%M=x
      if (answ%N==y%N){
        cout << answ << "\n";
        break;
      }

      if (answ>lcm){
        cout << -1 << "\n";
        break;
      }
    }

  }

}