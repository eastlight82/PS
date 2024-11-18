#include <bits/stdc++.h>
using namespace std;

int main()
{

  string s; cin >> s; //문자열
  vector <int> rslt(26); //결과 담을 vec

  for (int i = 0; i < s.size(); i++)
  {
    rslt[s[i] - 97]++; // rslt[문자열 idx]

  }

  for (int i = 0; i < 26; i++)
  {
    cout << rslt[i] << ' ';
  }

}