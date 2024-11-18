import sys

x=int(sys.stdin.readline().rstrip())

#2:1 3:2~3 4:4~6 5:7~10 6:11~15 (n-1)*(n-2)/2+1~n*(n-1)/2
#홀: 작은거먼저 짝: 큰거먼저

for n in range(10000000):
    if (n-1)*(n-2)/2+1<=x<=n*(n-1)/2:
        if (n%2==0): #짝: 큰거먼저
            son=n*(n-1)/2+1-x #4면 합7, 6이면 합16/ 4이면 3/1, 5이면 2/2
            mom=n-(n*(n-1)/2+1-x)
        else: #홀: 작은거먼저, x-son=(n-1)*(n-2)/2
            son=x-(n-1)*(n-2)/2
            mom=n-(x-(n-1)*(n-2)/2)
        print('{}/{}'.format(int(son),int(mom)))
        break