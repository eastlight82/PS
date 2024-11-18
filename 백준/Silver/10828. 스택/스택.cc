#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#include <array>
using namespace std;

int main()
{
  int N;
  cin >> N; //명령의 개수 받음
  string inst; //명령어(문자열형)
  stack <int> stack1; //담을 스택
  int num_push; // push 연산시 넣을 정수

  for (int i = 0; i < N; i++)
  {
    cin >> inst; //inst 입력받기
    
    if (inst=="push")
    {
      cin >> num_push;
      stack1.push(num_push);
    }

    if (inst == "pop")
    {
      if (stack1.size() == 0)
        cout << -1 << endl;
      else
      {
        cout << stack1.top() << endl;
        stack1.pop();
      }
    }

    if (inst == "size")
    {
      cout << stack1.size() << endl;
    }

    if (inst == "empty")
    {
      cout << stack1.empty() << endl;
    }

    if (inst == "top")
    {
      if (stack1.size() == 0)
        cout << -1 << endl;
      else
      {
        cout << stack1.top() << endl;
      }
    }
  }
}