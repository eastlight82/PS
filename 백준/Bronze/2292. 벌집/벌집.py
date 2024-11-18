import sys
#0(2) 1(3) 3 6 10
#1 2~7:2 8~19:3 20~37:4 38~61:5
#(i-1)*(i-2)*3+2<=k<=i*(i-1)*3+1
##(i-1)*(3*i-6)+2<=k<=i*(3*i-3)+1

k=int(sys.stdin.readline().rstrip())

if k==1:
    print(1)
else:
    for i in range(1000000000):
        if (i-1)*(i-2)*3+2<=k<=i*(i-1)*3+1:
            print(i)
            break