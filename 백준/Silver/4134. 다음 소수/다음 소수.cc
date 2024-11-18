#include <bits/stdc++.h>
using namespace std;

long long prime(long long n)
{//지금값부터 계산

  if (n==0 || n==1)
    return 2;

  for (long long i=2; i<=sqrt(n); i++) //매 수마다 나눠보기
  {
    if (n%i==0)
    {
      n++;
      return prime(n);  //소수가 아니면-> 다음 수로 넘어가기(return prime(n);)
    }
  }
  
  return n;//소수면: return n
}


int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
  
  long num_cnt; cin >> num_cnt; //입력횟수

  while (num_cnt--)
  {
    long long n; cin >> n; //입력받는 값
    cout << prime(n) << '\n';
  }
}