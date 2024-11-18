import sys
from collections import deque
import math


N=int(sys.stdin.readline()); v=[]

for i in range(N):
  x,y=map(int, sys.stdin.readline().rstrip().split())
  v.append([x,y])
  
for i in sorted(v):
  print(i[0], i[1])