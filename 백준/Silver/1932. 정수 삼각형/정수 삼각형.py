# 
import sys
from collections import deque
input = sys.stdin.readline

n=int(input()); gph=[]; dp=[[0]*500 for _ in range(500)]
for i in range(n):
  gph.append([int(x) for x in input().split()]) #ipt 완료 #gph=[[7],[3,8],[8,1,0]]

#idx i일때, i&i+1 접근 가능

#고정값
dp[0][0]=gph[0][0]

#점화식(ex)
for i in range(1,n):
  for j in range(i+1):
    if 0<j<i:
      dp[i][j]=max(dp[i-1][j-1],dp[i-1][j])+gph[i][j]
    elif j==0:
      dp[i][j]=dp[i-1][j]+gph[i][j]
    elif j==i:
      dp[i][j]=dp[i-1][j-1]+gph[i][j]
      
print(max(dp[n-1]))

# dp[1][0]=dp[0][0]+gph[1][0]
# dp[1][1]=dp[0][0]+gph[1][1]
# dp[2][0]=dp[1][0]+gph[2][0]
# dp[2][1]=max(dp[1][0],dp[1][1])+...
# dp[2][2]=dp[1][1]+...