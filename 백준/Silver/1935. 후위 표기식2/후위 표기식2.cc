#include <bits/stdc++.h>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
  

  int n; cin >> n; //피연산자 개수
  string postfix; cin >> postfix; //후위표기식
  vector <int> opand_vec(n); //피연산자(A,B,C,D) 담을 vec
  int op_tmp; //피연산자

  for (int i=0; i<n; i++)
  {
    cin >> op_tmp; //피연산자 값 입력받음
    opand_vec[i]=op_tmp;
  }//i 재사용 가능

  stack <double> opand_stk; //연산용 stack(피연산자 담아두기)

  for (int i=0; i<postfix.size(); i++)//postfix 연산
  {
    if (postfix[i]>='A' && postfix[i]<='Z') //식 값이 operand
    {
      int tmp= postfix[i]-65;
      opand_stk.push(opand_vec[tmp]);
    }

    else //식 값이 operator: stk의 top1, top2로 연산
    {
      double opand_2nd=opand_stk.top();
      opand_stk.pop();
      double opand_1st=opand_stk.top(); 
      opand_stk.pop();

      switch (postfix[i]) 
      {
        case '+':
        {
          double rslt=opand_1st + opand_2nd;
          opand_stk.push(rslt);
          break;
        }
        case '-':
        {
          double rslt=opand_1st - opand_2nd;
          opand_stk.push(rslt);
          break;
        }
        case '*':
        {
          double rslt=opand_1st * opand_2nd;
          opand_stk.push(rslt);
          break;
        }
        case '/':
        {
          double rslt=opand_1st / opand_2nd;
          opand_stk.push(rslt);
          break;
        }

      }
      
    }
    
  }
  cout << fixed;
  cout.precision(2);

  cout << opand_stk.top();

}