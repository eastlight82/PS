#5점: case찾고, 예시->점화식
import sys
from collections import deque
from math import *
MOD=10007

#목표: len N인 오르막수(조건: digit 오름차순(== 포함))
N=int(input())
dp=[[1]*10 for _ in range(N+1)] #cnt for #dp[2][1]-> 2자리수인데 1로끝

#case: 마지막 digit의 값: last[i]=10-i

for i in range(2,N+1):
  dp[i][0]=dp[i-1][0]
  for j in range(1,10):
    dp[i][j]=(dp[i][j-1]+dp[i-1][j])%MOD

print(sum(dp[N])%MOD)

#ex->점화식
  # dp[2][0]=dp[1][0]
  # dp[2][1]=dp[1][0]+dp[1][1]
  # dp[2][2]=dp[1][0~2]=dp[2][1]+dp[1][2]