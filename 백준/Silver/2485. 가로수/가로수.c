#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int gcd(int a, int b) 
{
    if (b == 0)
        return a;
    else
        return gcd(b, a % b);
}

int main()
{
    int N, i, nowgcd;
    scanf("%d", &N);
    int garo[100000];
    int dist[100000];
    for (i = 1; i <= N; i++)
    {
        scanf("%d", &garo[i]);//가로수 위치 받기
    }
    for (i = 1; i <= N; i++)
    {
        dist[i] = garo[i+1] - garo[i];//가로수 간 거리 받기
    }
            //거리끼리 최소공배수 구하기
    nowgcd = dist[1];
    for (int i = 1; i < N; i++)
    {
        nowgcd = gcd(nowgcd, dist[i]);
    }
    int count = 0;
    for (int i = 1; i < N; i++)
    {
        count = count + (dist[i] / nowgcd) - 1;
    }

    printf("%d", count);
    return 0;

}
