#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
using namespace std;

int main()
{
  int an; cin >> an; //수열 크기 입력받기
  vector <int> a(an); //수열 a[3,5,2,7]
  stack <int> stk;//중간 스택
  deque <int> nge(an,-1); //결과값 수열
  

  for (int i=0; i<an; i++)
  {
    cin >> a[i]; //a에 수열 입력받기
  }
  
  //수열 a의 idx-> 스택에 넣기
  for (int i = 0; i < a.size(); i++)
  {
    while (!stk.empty() && a[stk.top()] < a[i]) //stk:0 1 2, top(9 5 4), i: 5,4,8
    {
      nge[stk.top()] = a[i];
      stk.pop();
    }
    stk.push(i);
  }

  while (!nge.empty())
  {
    cout << nge.front() << " ";
    nge.pop_front();
  }
    
}
