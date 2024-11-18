import sys
import math

n=int(sys.stdin.readline().rstrip())

for i in range(1,1000001):
  sang, ans=i, i
  val=0
  while i:
    sang+=i%10
    i//=10
  if sang==n:
    val=1
    break

if val==0:
  print(0)
else:
  print(ans)