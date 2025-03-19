#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>


int main() {
	int a,b,c;
	scanf(" %d", &a);
	for (int i = 0;i < a;i++) {
		for (int k = i;k < a-1;k++) {
			printf(" ");
		}
		for (int j = -1;j < i;j++) {
			printf("*");
		}
		printf("\n");
	}
}