import sys

n,m=map(int,sys.stdin.readline().rstrip().split())
arr1=list(map(int,sys.stdin.readline().rstrip().split()))

rst=0

for i in range(n):
  for j in range(i+1,n):
    for k in range(j+1,n):
      if m<arr1[i]+arr1[j]+arr1[k]:
        continue
      else:
        rst=max(rst,arr1[i]+arr1[j]+arr1[k])
        
print(rst)