#include <stdio.h>
#include <stdlib.h>

int main()
{
	int N; int *arr; int X;
	scanf("%d %d", &N, &X);
	arr = (int*)malloc(sizeof(int) * N);
	int i = 0;
	while (i < N)
	{
		scanf("%d", arr + i);
		if (arr[i] < X)
			printf("%d ", arr[i]);
		i++;
	}
	free(arr);
}
