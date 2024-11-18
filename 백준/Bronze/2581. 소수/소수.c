#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int prime(int a)
{
	int i;
	if (a == 1)//1은 소수 아님
		return 0;
	for (i = 2; i < a; i++)
	{
		if (a % i == 0)//소수가 아니면
		{
			return 0;
		}
	}
	return a;//소수면 a 반환
}

int main()
{
	int M, N, sum=0, first=0;
	scanf("%d %d", &M, &N);
	for (int i = M; i <= N; i++)
	{
		if (prime(i) != 0)
		{
			sum += i;
			if (first == 0)
				first = i;
		}
	}
	if (sum == 0)
		printf("-1");
	else
		printf("%d\n%d", sum, first);

}