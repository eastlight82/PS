#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#include <array>
using namespace std;

int main()
{
  int T; //test case cnt
  cin >> T;
  cin.ignore();
  string snt;
  stack <char> stk;

  while (T--)
  {
    getline(cin, snt); //snt 받음(한 줄 통으로)
    snt += ' ';

    for (int i = 0; i < snt.size(); i++) //한 word씩(snt[i])
    {

      if (snt[i] == ' ') //띄쓰 나오면 word 역순 출력 시작(다 떨어질때까지)
      {
        while (!stk.empty())
        {
          cout << stk.top();
          stk.pop(); //출력 후 빼주기
        }cout << ' ';
      }//문제: 띄쓰 두번

      else //띄쓰는 출력하면 안되지
        stk.push(snt[i]); //stk에 담아

    }cout << endl;

  }

 }