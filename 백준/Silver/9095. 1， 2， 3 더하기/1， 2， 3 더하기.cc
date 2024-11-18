#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
using namespace std;

int arr[12] = {1,1,2,4,7};
int recur(const int &t);

int main()
{
  int t; cin >> t;
  int n;
  while (t--)
  {
    cin >> n;
    cout << recur(n) << '\n';
  }
}

int recur(const int &t)
{
  if (arr[t] != 0)
    ;
  else
    arr[t] = recur(t - 1) + recur(t - 2) + recur(t - 3);

  return arr[t];
}