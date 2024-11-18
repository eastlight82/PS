
int main()
{
	int N, i, iarr[10000];
	
	for (int a = 0; 1; a++)
	{
		int sum = 0, cnt = 0;
		for (int a = 0; a < 10000; a++)
			iarr[a] = 0;
		scanf("%d", &N);
		if (N == -1)
			break;
		int m = 0;
		for (i = 1; i < N; i++)
		{
			
			if (N % i == 0)
			{
				sum += i;
				cnt += 1;
				iarr[m] = i;
				m++;
			}
		}

		if (sum == N)
		{
			printf("%d = ", N);
			for (i = 0; 1; i++)
			{
				if (iarr[i + 1] != 0)
					printf("%d + ", iarr[i]);
				else
				{
					printf("%d", iarr[i]);
					break;
				}
			}
		}
		else
			printf("%d is NOT perfect.", N);
		printf("\n");
	}
}