import sys
import math

a,b,v=map(int, sys.stdin.readline().rstrip().split())

rst=1
v-=a #마지막날은 제외
day=a-b #v/day(나머지 있을 경우 올림)

rst+=v/day
print(math.ceil(rst))