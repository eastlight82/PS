#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#include <array>
using namespace std;

int main()
//연속내림 수들 출력 || n까지 다 입력받음 -> 내림차순 쭉 출력
{
  int n;
  cin >> n;
  cin.ignore();

  stack <int> stk; //val 넣을 스택
  vector <char> oper; // + - 넣을 벡터
  int seq_val;
  int stk_iputVal = 1; //입력할 값

  //[4, 3, 6, 8, 7, 5, 2, 1]
  for (int i = 0; i < n; i++) //i못씀
  {
    cin >> seq_val; //첫 수열값 입력받음(4)

    while (seq_val >= stk_iputVal) //stk_iputVal가 4될때까지 스택에 넣어
    {
      stk.push(stk_iputVal);
      stk_iputVal++;
      oper.push_back('+'); //연산벡터에 값 push
    }//stk_iputVal=5로 끝, stk={1,2,3,4}

    if (stk.top() == seq_val) //pop해야 할거
    { 
        stk.pop();
        oper.push_back('-'); //pop하고, 연산벡터에 값 push
    }
  }

  if (!stk.empty())
  {
    cout << "NO";
  }

  else
  {
    for (int op_idx = 0; op_idx < oper.size(); op_idx++) //+, - 출력
    {
      cout << oper[op_idx] << "\n";
    }
  }
    
}