import sys
input = sys.stdin.readline

#1~N중 M개 선택(오름차순)=NCM

N,M= map(int,input().split()); v=[]

def back_t(len, st):
  if len==M:
    print(' '.join(map(str,v)))
    return 
  
  for i in range(st,N+1): #st를 설정해주기
    if i not in v:
      v.append(i)
      back_t(len+1, i+1)
      v.pop()
    
back_t(0,1)