from collections import deque

#N: chess판 크기, r1, c1-> r2, c2
graph=[] #graph[N][N]: cnt 기록
d=[]

def bfs(y,x):
  q=deque([])
  q.append((y,x)); graph[y][x]+=1
  
  while q:
    currY, currX= q.popleft()
    for dy,dx in d:
      nextY=currY+dy; nextX=currX+dx
      if 0<=nextY<N and 0<=nextX<N and graph[nextY][nextX]==-1: #Greedy: 순차+1, 이미 최적해: 볼 필요x
        q.append((nextY,nextX)); graph[nextY][nextX]=graph[currY][currX]+1
    

#main함수
N= int(input()) #
r1, c1, r2, c2= map(int, input().split()) 

graph=[[-1]*N for _ in range(N)]
d=[(-2,-1), (-2,1), (0,-2), (0,2), (2,-1), (2,1)] #input 완료

bfs(r1,c1)

print(graph[r2][c2]) #횟수 출력

