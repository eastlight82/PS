#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>


int main()
{
	int N; int* iarr; int M;
	scanf("%d %d", &N, &M);
	iarr = (int*)malloc(sizeof(int) * N);
	for (int i = 0; i < N; i++)
		iarr[i] = 0;

	int i1, j, k;
	for (int i = 0; i < M; i++)
	{
		scanf("%d %d %d", &i1, &j, &k);
		for (int m = i1 - 1; m <= j - 1; m++)
		{
			iarr[m] = k;
		}
	}
		
	for (int i = 0; i < N; i++)
		printf("%d ", iarr[i]);
	free(iarr);
	
}