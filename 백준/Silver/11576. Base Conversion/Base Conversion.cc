#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
using namespace std;

int main()
{
  int a, b; cin >> a >> b;

  int m; cin >> m;

  int jari; int sum=0;
  while (m--)
  {
    cin >> jari;
    sum += jari*pow(a, m);
  }

  //b진수 값들 담을 stk 50 ->62
  stack <int> stk;
  while (sum / b != 0)
  {
    stk.push(sum % b);
    sum /= b;
  }stk.push(sum % b);
  
  while (!stk.empty())
  {
    cout << stk.top() << ' ';
    stk.pop();
  }
}