#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
using namespace std;

int main()
{
  string N, comm;
  int M;
  cin >> N; //문자열, abcd
  cin >> M; //명령어 개수

  stack <char> left;
  stack <char> right; //커서 왼쪽, 오른쪽

  char tmp; //중간값 받을거

  for (int i = 0; i < N.size(); i++)
  {
    left.push(N[i]);
  }//pop순: dcba


  while (M--)
  {
    cin >> comm;

    if (comm == "L") //커서가 왼쪽으로 한 칸 가면, left에 있는거 left으로
    {
      if (!left.empty())
      {
        tmp = left.top();
        left.pop();
        right.push(tmp);
      }
      
    }

    if (comm == "D")//커서가 오른쪽으로 한 칸 가면, right에 있던거 left로
    {
      if (!right.empty())
      {
        tmp = right.top();
        right.pop();
        left.push(tmp);
      }
      
    }

    if (comm == "B")
    {
      if (!left.empty())
      {
        left.pop();
      }
    }

    if (comm == "P")
    {
      char a;
      cin >> a;

      left.push(a);
    }
  }

  int tmp_size = left.size();

  for (int i = 0; i < tmp_size; i++)
  {
    tmp = left.top();
    right.push(tmp);
    left.pop();
  }

  tmp_size = right.size();

  for (int i=0; i<tmp_size; i++)
  {
    cout << right.top();
    right.pop();
  }
}