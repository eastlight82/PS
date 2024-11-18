import sys
from collections import deque
input = sys.stdin.readline
  
N,M=[int(x) for x in input().split()]
s1=set(); s2=set()
for i in range(N):
  s1.add(input().rstrip())

for i in range(M):
  s2.add(input().rstrip())
  
s3=s1&s2

print(len(s3))
s3=list(s3); s3.sort()
for i in s3:
  print(i)