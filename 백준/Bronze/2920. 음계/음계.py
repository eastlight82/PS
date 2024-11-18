import sys

v=list(map(int, input().split()))
  
a=[x for x in range(1,9)]


if v==sorted(a):
  print('ascending')

elif v==sorted(a, reverse=True):
  print('descending')

else:
  print('mixed')