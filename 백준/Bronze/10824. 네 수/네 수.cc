#include <bits/stdc++.h>
using namespace std;

int main()
{
  ios_base::sync_with_stdio(false); cin.tie(NULL);

  vector <string> invec(4); //입력배열: a b c d
  for (int i = 0; i < 4; i++)
  {
    cin >> invec[i];//a b c d 입력받기
  }
  invec[0] += invec[1]; //붙이기 1020
  invec[2] += invec[3]; //3040


  //출력: 붙인 값 합
  cout << stol(invec[0]) + stol(invec[2]);
}