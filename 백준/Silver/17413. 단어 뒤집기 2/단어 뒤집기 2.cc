#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
using namespace std;

int main()
{
  string S;
  getline(cin,S); //문자열 받음
  S += ' ';
  
    
  stack <char> st; //중간
  string rslt; //출력용

  int i = 0; //i 시작

  while (i < S.size())
  {
    if (S[i] == '<')//tag
    {
      while (S[i] != '>')
        rslt.push_back(S[i++]);
      rslt.push_back(S[i++]); //<받기
    }

    else //일반문자
    {
      while (S[i] != ' ') //띄쓰,< 전까지 다 출력(baekjoon)
      {
        if (S[i] != '<')
          st.push(S[i++]); //i=띄쓰,포인터
        else
          break;
      }
        

      if ((S[i] == ' ')|| (S[i]=='<'))
      {
        while (!st.empty())
        {
          rslt.push_back(st.top());
          st.pop();
        }
        if (S[i] == ' ')
          rslt.push_back(S[i++]);
      }
    }
  }

   cout << rslt;

}