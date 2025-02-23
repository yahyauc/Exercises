#include<stdio.h>
void lecture(int V,int N){
    for(int i=0; <N; i++){
        printf("entrer la taille de ce vecteur :");
        scanf("%d",&N);
    }
}
void affichage(int V){
    for(i=0; i<N; i++){
        printf("%d,",i);
    }
}
int main(){
    printf("---------------------------------\n");
    printf("Menu\n");
    printf("---------------------------------\n");
    printf("---------------------------------\n1- Lecture\n2- Affichage\n3 - Somme\n4 - Produit\n5 - Scalaire\n6- Distance\n7- Quitter\n-------------\n");
    printf("entrer le type de ce operation :");
    scanf("%d",&N);
    if(int N=1){
        lecture(V,N);
    }else if(N=2){
        affichage(V);
    }

    return 0;
}
