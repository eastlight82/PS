#include <bits/stdc++.h>
using namespace std;

vector <long> rslt_arr;
long fact(long n)
{
  if (n==1)
    return 0;

  for (int i=2; i<=sqrt(n); i++)
  {
    if (n%i==0) //소수가 아닐 때: loop break
      return 0; //함수종료
  }
  rslt_arr.push_back(n);//소수면: arr에 n push
  return 0; //d.c
}


int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
  
  int m,n; cin >>m; cin >>n; //m~n

  for (int i=m; i<=n; i++)
  {
    fact(i);
  }

  for (int i=0; i<rslt_arr.size(); i++)
  {
    cout << rslt_arr[i] << '\n';
  }

}