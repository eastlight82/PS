#include <bits/stdc++.h>
using namespace std;

#define MOD 1000000009

long long dp[100001][4]; //값, 끝값

// 1/ 2/ 1+2 2+1 3/ 1+2+1 3+1 1+3
//4: 1들+3 2들+2 3들+1 (끝 같은건 빼기)

int main(){ios_base::sync_with_stdio(false); cin.tie(NULL);
  //목표: n을 1,2,3으로 나타내는 방법# (같은 수 연속x)
  int T, n; cin >> T; 

  dp[1][1]=dp[2][2]=1; dp[3][1]=dp[3][2]=dp[3][3]=1;

  for (int i=4; i<100001; i++){
    dp[i][1]= (dp[i-1][2]+dp[i-1][3])%MOD;
    dp[i][2]= (dp[i-2][1]+dp[i-2][3])%MOD;
    dp[i][3]= (dp[i-3][1]+dp[i-3][2])%MOD;
  }

  while (T--){
    cin >> n; //n<=100,000

    cout << (dp[n][1]+dp[n][2]+dp[n][3])% MOD << "\n";
  }

}