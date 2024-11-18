# 
import sys
from collections import deque
input = sys.stdin.readline

# optor: ( > */ > +- > ):'('전까지 다 pop : s.top()이 같높-> top.pop
# opand: 바로 출력

notat=input().rstrip(); answ=[]; s=[]

for i in notat:
  if "A"<=i<="Z": #opand
    answ.append(i)

  else: #optor
    if i in ("*", "/"):
      while s and s[len(s)-1] in ("/", "*"): #같높
        answ.append(s.pop())
      s.append(i)

    elif i in ("+", "-"):
      while s and (s[len(s)-1]!="("):
        answ.append(s.pop())
      s.append(i)
      
    elif i=="(":
      s.append(i)
      
    elif i==")": 
      #pop until (
      while s and s[len(s)-1]!="(":
        answ.append(s.pop())
      s.pop()

while s:
  answ.append(s.pop())

print(''.join(answ))