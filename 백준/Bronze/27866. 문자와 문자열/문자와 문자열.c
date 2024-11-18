#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>


int main()
{
	char iarr[1001]; int N; char word;
	scanf("%s", iarr);
	scanf("%d", &N);
	//iarr의 N-1번째 word
	word = iarr[N - 1];
	
	printf("%c",word);
}