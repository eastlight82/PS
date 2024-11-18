#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main()
{
	int N, i, j;
	scanf("%d", &N);
	for (i = 1; i < N+1; i++)
	{//(i<=5) i번째 줄 빈칸 5-i개, (6<=i<=9)i번째 줄 빈칸 i-5개
	 //(i<=5) i번째 줄 * 2*i-1개, (6<=i<=9)i번째 줄 * 2*(10-i)-1개
		for (j = 0; j < N - i; j++)
			printf(" ");
		for (j = 0; j < 2 * i - 1; j++)
			printf("*");
			printf(" ");
		printf("\n");
	}
	for (i = N+1; i < 2*N; i++)
	{//(i<=5) i번째 줄 빈칸 5-i개, (6<=i<=9)i번째 줄 빈칸 i-5개
	 //(i<=5) i번째 줄 * 2*i-1개, (6<=i<=9)i번째 줄 * 2*(10-i)-1개
		for (j = 0; j < i - N; j++)
			printf(" ");
		for (j = 0; j < 2 * (2*N - i) - 1; j++)
			printf("*");
			printf(" ");
		if (i != 2 * N - 1)
			printf("\n");
	}
}
