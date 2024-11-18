#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
using namespace std;


int main()
{
  string par; cin >> par; //입력: 괄호
  //레이저: 인접한(), //쇠막대기: ( )
  stack <char> stk; //괄호->스택에 담기
  int sum = 0;//구해야할값: 잘려진 조각 개수

  for (int i = 0; i < par.size(); i++) //stk에 담는 loop문
  {
    if (par[i] == ')')//레이저 끝 or 쇠막 끝
    {
      stk.pop();
      
      if (par[i - 1] == '(') //레이저 끝
        sum += stk.size();
      else //쇠막 끝
        sum += 1;
    }

    else //레이저, 쇠막 시작
      stk.push(par[i]);

  }
  cout << sum;


}
