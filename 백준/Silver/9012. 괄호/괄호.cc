#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#include <array>
using namespace std;

int main()
//VPS 아닌 조건: 1. )가 -1이하(stk이 -1이하) 2. 끝날때 stk이 0 아니면
//stk: (면 +1
{
  int T;
  cin >> T;
  cin.ignore();

  string PS;

  while (T--) //테스트 데이터
  {
    int stk = 0;
    cin >> PS;
    for (int i = 0; i < PS.size(); i++)
    {
      if (PS[i] == '(') //stk 연산
        stk += 1;
      else if (PS[i] == ')')
        stk -= 1;

      if (stk < 0) //stk -1이하
      {
        cout << "NO" << endl;
        break;
      }
    }

    if (stk == 0)
      cout << "YES" << endl;
    else if (stk < 0)
      continue;
    else
      cout << "NO" << endl;

  }

}
