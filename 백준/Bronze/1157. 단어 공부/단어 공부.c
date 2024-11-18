#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <ctype.h>

int main()
{
	int i; char str[1000001]; int str2[26];
	scanf("%s", str);
	int b = strlen(str);
	for (i = 0; i < 26; i++)//각 알파벳 별 개수값 0으로 설정
		str2[i] = 0;
	for (i = 0; i < b; i++)
	{
		if (islower(str[i]))//소->대문자로 변환
			str[i] = toupper(str[i]);
		str2[str[i] - 65] += 1;//각 글자마다 알파벳배열에 카운트 추가
	}
	int max = 0; int maxcnt = 0; int a;
	for (i = 0; i < 26; i++)//알파벳배열에 접근해 알파벳 양 최댓값 구함
		if (max < str2[i])
			max = str2[i];
	for (i = 0; i < 26; i++)//최댓값인 알파벳의 개수, 그 알파벳 값 구함
		if (max == str2[i])
		{
			maxcnt += 1;
			a = i;
		}

	if (maxcnt == 1)
		printf("%c", a + 65);
	else
		printf("?");

}