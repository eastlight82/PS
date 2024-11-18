import sys

#124%25=24 24

t=int(sys.stdin.readline().rstrip())



for i in range(t):
    
    a=int(sys.stdin.readline().rstrip())
    print(a//25, end=' ')
    a%=25
    print(a//10, end=' ')
    a%=10
    print(a//5, end=' ')
    a%=5
    print(a//1)