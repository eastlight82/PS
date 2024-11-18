#include <bits/stdc++.h>
using namespace std;

int sum=0;

int cnt_5(int n)
{
  if (n==0)
    return sum;
  
  int a=n;

  while (a%5==0)
  {
    a/=5; //5로 계속 나누기
    sum+=1;
  }
  return cnt_5(n-1);
}

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
  
  int n; cin >> n; //입력값 n

  cout << cnt_5(n);
}