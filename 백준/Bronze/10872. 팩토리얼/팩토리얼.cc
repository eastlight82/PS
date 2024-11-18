#include <bits/stdc++.h>
using namespace std;

int factorial(const long &a, long total=1)
{
  if (a==1 || a==0)
  {
    return total;
  }

  return factorial(a-1, total*a);
}

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
  
  int n; cin >> n;

  cout << factorial(n);
}