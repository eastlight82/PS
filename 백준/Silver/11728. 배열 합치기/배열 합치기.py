import sys
from collections import deque
from math import *
import bisect
  
N,M= map(int, input().split()) # ls#

A=list(map(int, input().split())) #ls A,B: 값 10**9
B=list(map(int, input().split())) #ipt 완료

#목표: 두 ls 합치고 정렬
M=sorted(A+B)

print(' '.join(map(str,M)))