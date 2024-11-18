#1점: 규칙: 추가되면 X, 놓는다로 나누기
import sys
from collections import deque
from math import *
MOD=9901

#목표: 한 행에 하나 (가,세 붙어있게 하면 안됨)
#조건 나누기: 놓기, X

#점화식: 2*DP[-1]+DP[-2]
#X+놓 #윗행 유무
#N=1:3 #1마리:2
# 2:7=3+(2+2) #1마리:2*2 2마리:2
# 3:17=7+(3*2+4)(3개는 무, 4개는 유)  1마리:2*3 2마리:2&2*1+2*2 3마리:2=6+8+2=16
# 4:41=17+(7*2+10)
N=int(input()) #우리: N*2

DP=[0]*(N+1)

DP[0]=1; DP[1]=3
for i in range(2, N+1):
  DP[i]=(DP[i-1]*2+ DP[i-2])%MOD

print(DP[N])