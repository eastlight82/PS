# 
import sys
input = sys.stdin.readline

#1~N중 M개 선택(오름차순)=NCM

N,M= map(int,input().split()) 
a=list(map(int, input().split())) #A: 숫자 목록
a.sort()
v=[]

def back_t(len, st): #조건:len
  if len==M:
    print(' '.join(map(str,v)))#rtn값
    return 
  
  for i in range(0,N): 
    if a[i] not in v: #미중복
      v.append(a[i]) #반복 작업
      back_t(len+1, st) #다음 반복: 그대로
      v.pop()
    
back_t(0,0)