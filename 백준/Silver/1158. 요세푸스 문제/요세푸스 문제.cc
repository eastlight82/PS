#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
using namespace std;

int main()
{
  int N, K;
  cin >> N; cin >> K;

  queue <int> q1; //시작큐
  vector <int> v1; //담을 벡터

  for (int i = 1; i <= N; i++)
  {
    q1.push(i); //1,2,3,4,5,6,7
  }

  int tmp;
  
  while (!q1.empty())
  {
    for (int i=0; i<K-1; i++)
    {
      q1.push(q1.front()); q1.pop(); //2,3,4,5,6,7,1
    }
    tmp = q1.front();
    v1.push_back(tmp);
    q1.pop(); //4, 5, 6, 7, 1, 2
  }
  cout << "<";
  for (int i = 0; i < v1.size()-1; i++)
  {
    cout << v1[i] << ", ";

  }
  cout << v1[v1.size() - 1] << ">";
}