import sys
from collections import deque
from math import *
import bisect

def bin_search(x):
  idx=bisect.bisect_left(ls,x)
  
  if idx<len(ls) and ls[idx]==x:
    return True
  return False

#목표: M을 가지고 있는가?
N=int(input()) #숫자카드#
ls=sorted(list(map(int, input().split())))
M=int(input()) #찾을 값#
targetLs=list(map(int, input().split()))#ipt완료

dic={}

for i in ls: #d에 cnt 넣기
  if i in dic:
    dic[i]+=1
  else:
    dic[i]=1
    
for i in targetLs:
  if bin_search(i):
    print(dic[i],end=" ")
  else:
    print(0,end=" ")

