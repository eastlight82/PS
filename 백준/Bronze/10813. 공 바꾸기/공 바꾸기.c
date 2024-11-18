#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>


int main()
{
	int N; int* iarr; int M;
	scanf("%d %d", &N, &M);
	iarr = (int*)malloc(sizeof(int) * (N+1));
	for (int i = 0; i <= N; i++)
		iarr[i] = i;

	int i1, j1;
	for (int i = 0; i < M; i++)
	{
		scanf("%d %d", &i1, &j1);
		int a = iarr[i1]; int b= iarr[j1];
		iarr[i1] = b; iarr[j1] = a;
	}


	for (int i = 1; i <= N; i++)
		printf("%d ", iarr[i]);
	free(iarr);
	
}