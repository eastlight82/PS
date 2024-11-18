#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#include <array>
using namespace std;

int main()
{
  int N;
  cin >> N;
  queue <int> que;

  while (N--)
  {
    string inst;
    cin >> inst;

    if (inst == "push")
    {
      int push_n;
      cin >> push_n;

      que.push(push_n);
    }

    if (inst == "pop")
    {
      if (que.empty())
        cout << -1 << '\n';

      else
      {
        cout << que.front() << '\n';
        que.pop();
      }
      
    }

    if (inst == "size")
    {
      cout << que.size() << '\n';
    }

    if (inst == "empty")
    {
      if (que.empty())
        cout << 1 << '\n';
      else
        cout << 0 << '\n';
    }

    if (inst == "front")
    {
      if (que.empty())
        cout << -1 << '\n';

      else
        cout << que.front() << '\n';
    }

    if (inst == "back")
    {
      if (que.empty())
        cout << -1 << '\n';

      else
        cout << que.back() << '\n';
    }

  }
  

}