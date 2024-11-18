#include <bits/stdc++.h>
using namespace std;

long long arr[91]={1,1,2};

int main(){ios_base::sync_with_stdio(false); cin.tie(NULL);
  //이친수: 0or1, 0시작x, 11x
  //*구할거: n자리 이친수#

  //0끝: 2개, 1끝: 1개
  //1끝: 다음에 2*, 0끝: 2* 1개 1* 1개
  //1자리: 1 2자리: 1+0=1*1 3자리: 10+1,0 =2*1 4자리: 101+0 100+0,1 =2*1+1*1
  //5자리: 1010+0,1 1000+0,1 1001+0 =2*2+1*1 6자리: 2*3+1*2 7자리: 2*5+1*3

  int n; cin >> n;

  for (int i=2; i<90; i++){
    arr[i]=arr[i-1]+arr[i-2];
  }

  cout << arr[n-1];
}
