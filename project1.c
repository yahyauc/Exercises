#include <stdio.h>

int main() {
    int a, b, c, max;
    printf("Entrez trois entiers : ");
    scanf("%d %d %d", &a, &b, &c);
    max = a;
    if (b > max) {
        max = b;
    }
    if (c > max) {
        max = c;
        printf("Le maximum est : %d\n", max);
    }
    else 
        printf(" les nombre sont égaux !!!");
  
    return 0;
}
