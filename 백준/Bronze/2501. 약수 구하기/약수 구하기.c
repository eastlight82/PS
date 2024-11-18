#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

int main()
{
	int N,K,i, cnt=0, a=0;
	scanf("%d %d", &N, &K);
	for (i = 1; i <= N; i++)
	{
		if (N % i == 0)
		{
			cnt += 1;
			if (cnt == K)
				a = i;
		}
	}
	printf("%d", a);

}