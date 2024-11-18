#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
int k[1000000];
int main() {
	int n;
	int max = -1000000;
	int min = 1000000;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &k[i]);
		if (k[i] < min) {
			min = k[i];
		}
		if (k[i] > max) {
			max = k[i];
		}
	}
	printf("%d %d", min, max);
	return 0;
}