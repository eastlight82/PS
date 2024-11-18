# 
import sys
from collections import deque
import math
input = sys.stdin.readline

#1~N중 M개 선택(오름차순)=NCM

N,M= map(int,input().split()); v=[]

def back_t(a):
  if a==M:
    print(' '.join(map(str,v)))
    return 
  
  for i in range(1,N+1):
    if i not in v:
      v.append(i)
      back_t(a+1)
      v.pop()
    
back_t(0)