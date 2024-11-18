#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
//전공평점=전공과목별 (학점 × 과목평점)의 합 / 학점의 총합
//3.0*4.5/3.0
//과목명, 학점, 등급(에 따른 과목평점)(과목명, 3.0, A+)
//P는 학점의 총합에서 빼기
float pyeong(char* py)
{
	if (strcmp(py, "A+") == 0)
		return 4.5;
	else if (strcmp(py, "A0") == 0)
		return 4;
	else if (strcmp(py, "B+") == 0)
		return 3.5;
	else if (strcmp(py, "B0") == 0)
		return 3;
	else if (strcmp(py, "C+") == 0)
		return 2.5;
	else if (strcmp(py, "C0") == 0)
		return 2;
	else if (strcmp(py, "D+") == 0)
		return 1.5;
	else if (strcmp(py, "D0") == 0)
		return 1;
	else if (strcmp(py, "F") == 0)
		return 0;
	else if (strcmp(py, "P") == 0)
		return 5;
	else
		return 6;
}

int main()
{
	float hakpysum=0; float haksum=0;
	for (int i = 0; i < 20; i++)
	{
		char name[51]; float hak; char py[3];
		scanf("%s %f %s", name, &hak, py);
		float pye = pyeong(py);
		if (pye == 5)
			continue;
		hakpysum += hak * pye;
		haksum += hak;
	}
	printf("%f", hakpysum / haksum);

}