#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>


int main()
{
	float* iarr; int i = 0; int N; float aver;
	scanf("%d", &N);
	iarr = (float*)malloc(sizeof(float) * N);
	for (i = 0; i < N; i++)
	{
		scanf("%d", iarr + i);
	}
	float max = 0;
	for (i = 0; i < N; i++)
	{

		if (max < iarr[i])
			max = iarr[i];
	}
	for (i = 0; i < N; i++)
	{

		iarr[i] = iarr[i] / max * 100;
	}
	float sum = 0;
	for (i = 0; i < N; i++)
	{
		sum = sum + iarr[i];
	}
	aver = sum / N;
	printf("%f", aver);
	free(iarr);
}