#3점: idx 잘 설정해주고, min 안쓸거면 dflt=0, 0일때만 pass(Greedy)
import sys
from collections import deque
import math
MAX=100001

# 숨꼭: 수빈(N), 동생(K) # 이동종류: 걷기: x-1, x+1/ 순간: 2*x
# 목표: 수빈이가 동생 찾는 "가장 빠른 시간"
q=deque([]); point=[MAX]*MAX #*0이 dflt면, 어차피 값 설정하면 Greedy해지는걸 고려(min x)

def bfs(x, bV):
  q.append(x); point[x]=0
  
  while q:
    cur=q.popleft()
    if cur==bV: break #K나오면 brk
    
    for dx in [cur-1, cur+1, cur*2]: #ls로 묶어서 쓰기
      if 0<=dx<=MAX-1 and point[cur]+1< point[dx]: #*허용 idx는 MAX-1까지
        point[dx]=point[cur]+1; q.append(dx)
    

N,K=map(int, input().split())
bfs(N, K)

print(point[K])