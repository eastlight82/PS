import sys

v=[0]*3 

for i in range(0,3):
  a=int(input())
  v[i]=a


answStr= int(str(v[0])+str(v[1]))-v[2]
answInt= v[0]+v[1]-v[2]

print(answInt, answStr, sep="\n")