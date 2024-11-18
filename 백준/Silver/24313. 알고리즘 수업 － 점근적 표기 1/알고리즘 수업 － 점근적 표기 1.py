import sys

a1,a0=map(int,sys.stdin.readline().rstrip().split())
c=int(sys.stdin.readline().rstrip())
n0=int(sys.stdin.readline().rstrip())

if (a1*n0+a0<=c*n0) and a1<=c:
  print(1)
else:
  print(0)