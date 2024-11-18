import sys

T=int(input())

for i in range(T): #cin#
  lst= input() #OOOOXXX
  sumVal=1; answ=0
  for j in range(len(lst)):
    if lst[j]=='O':
      answ+=sumVal; sumVal+=1
    
    else:
      sumVal=1
  print(answ)
    