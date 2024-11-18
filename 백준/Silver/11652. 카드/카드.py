import sys
from collections import deque
import math


N=int(sys.stdin.readline()); v=dict([])

for i in range(N):
  x=int(sys.stdin.readline().rstrip())
  if x in v:
    v[x]+=1
  else:
    v[x]=1

v2= sorted(v.items(), key=lambda x:(-x[1], x[0]))

print(v2[0][0])