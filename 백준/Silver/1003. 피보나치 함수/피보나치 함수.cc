#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
using namespace std;

long long fib1(int n);

int main()//목표: 0, 1 출력횟수
{
  int T; //test case 수
  scanf("%d", &T);
  int a; //n에 입력되는 값

  for (int i = 0; i < T; i++)
  {
    scanf("%d", &a); //입력: i

    if (a == 0)
    {
      printf("1 0\n"); // i=0이면, 1,0(나머지는 fib 그대로)
    }

    else
    {
      printf("%d %d\n", fib1(a-1), fib1(a)); //값 출력
    }
  }
}
//fib(i) 10 01 11 12 23 35

long long arr1[41] = { 0,1, };//의미: 출력횟수

long long fib1(int n)//fib1: 0 1 1 2 3
{
  if (arr1[n] != 0 || n < 2)//1 arr값 case || 1 이하
    return arr1[n];
  
  arr1[n] = fib1(n - 1) + fib1(n - 2); //못 구한 case: 재귀 돌리기
  
  return arr1[n]; //값 자체를 반환해주기에, 나중에 fib함수가 부분반복되어도 재귀 안돌아감
  
}