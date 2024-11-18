#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

int main()
{
	int num, i, j, k, J, K, iarr[101][101], cnt=0;
	for (j = 0; j < 101; j++)//각 칸마다 0 부여
		for (k = 0; k < 101; k++)
			iarr[j][k] = 0;

	scanf("%d", &num);
	for (i = 0; i < num; i++)
	{//2차원 배열 만든 후 각 칸마다 +1, 겹칠때마다 -1
		scanf("%d %d", &J, &K);//가로(j), 세로(k) 시작점
		for (j=1; j<=100; j++)
			for (k = 1; k <= 100; k++)
			{
				if (j == J && k == K)//가로 세로 일치할때
					for (int m = 0; m < 10; m++)
						for (int n = 0; n < 10; n++)
						{
							iarr[j + m][k + n] += 1;
						}
							
			}
	}
	for (j = 0; j < 101; j++)//각 칸의 총합
		for (k = 0; k < 101; k++)
		{
			if (iarr[j][k] != 1 && iarr[j][k] != 0)
				iarr[j][k] = 1;

			cnt += iarr[j][k];
		}
	printf("%d", cnt);

}