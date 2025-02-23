#include <stdio.h>
#include <stdlib.h>

int main()
{
   float A[50][50];
   int n,m;
   int i,j;
   //saisie de donnée 
   float x;
   printf ("nombre de lignes :");
   scanf("%d",&n);
   printf("\n nombre de colonnes :");
   scanf("%d",&m);
   //remplir la matrice
   for (i=0; i<n; i++)
    for (j=0 ; j<m ;j++)
    { printf ("A[%d][%d]= ",i,j);
      scanf("%f",&A[i][j]);
   }
   printf("multiplicateur x :");
   scanf("%f",&x);
   //affichage du matrice A
   printf("Matrice A :\n");
   for (i=0; i<n ; i++){
   for (j=0; j<m ;j++)
    printf("%.0f\t",A[i][j]);
   printf("\n\n");}
   //multiplication de A par x 
   for (i=0; i<n ; i ++)
    for (j=0 ; j<m ; j++)
        A[i][j]= A[i][j]*x ;
    // affichage 2
     printf("\n la matrice after la miltuplication\n\n");
    for (i=0; i<n ; i++){
   for (j=0; j<m ;j++)
    printf("%.0f\t",A[i][j]);
   printf("\n\n");}
       
        return 0;
}