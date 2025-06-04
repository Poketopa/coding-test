#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <limits.h>

int main() {
	int a[8];
	for (int i = 0;i < 8;i++) {
		scanf(" %d", &a[i]);
	}
	int i;
	if (a[0] == 1) {
		i = 1;
		while (a[i - 1]+1 == a[i]) {
			if (i == 7) {
				printf("ascending");
				return 0;
			}
			i++;
		}
	}
	else if (a[0] == 8) {
		i = 7;
		while (a[i - 1] == a[i]+1) {
			if (i == 1) {
				printf("descending");
				return 0;
			}
			i--;
		}
	}
	printf("mixed");
}