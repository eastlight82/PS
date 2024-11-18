import sys
from collections import deque
import math


N=int(sys.stdin.readline()); v=[]

for i in range(N):
  x,y=sys.stdin.readline().rstrip().split()
  x=int(x)
  v.append([x,y])
  
v.sort(key= lambda x:(x[0]))
for i in v:
  print(f"{i[0]} {i[1]}")