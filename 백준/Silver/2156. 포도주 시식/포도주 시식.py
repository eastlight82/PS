n=int(input())
array=[0]*10000
for i in range(n):
  array[i]=int(input())

#d: 다음d에 쉰다 가정하고 max
d=[0]*10000
d[0]=array[0]
d[1]=array[0]+array[1]
d[2]=max(array[2]+array[0], array[2]+array[1], d[1])
for i in range(3,n):
    #어차피 쉬는건 현i, i-1, i-2중 하나
  d[i]=max(array[i]+d[i-2], array[i]+array[i-1]+d[i-3], d[i-1])

print(max(d))