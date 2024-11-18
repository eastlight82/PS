#include <stdio.h>
#include <string.h>

int main(){
	char ar[1000002];
	int count = 0;
	fgets(ar, 1000002, stdin);
	int a = strlen(ar);
	//printf("%d\n", a);
	for(int i = 0; ar[i] != '\0'; i++){
		
		if (ar[i] == ' ' && i != 0) count += 1;
	}
	
	if(ar[a-2] == ' ')printf("%d", count);
	else printf("%d", count+1);
	return 0;
}