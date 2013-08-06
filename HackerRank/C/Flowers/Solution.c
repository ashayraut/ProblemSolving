/* Sample program illustrating input/output methods */
#include<stdio.h>
#include<stdlib.h>

int cmp(const void *a,const void *b)
{
    const int *a1 = (const int*)a;
    const int *b1 = (const int*)b;
    return *b1-*a1;
}

int main(){

//Helpers for input/output
   int i, N, K;
   int C[102];
   
   scanf("%d %d", &N, &K);
   for(i=0; i<N; i++){
      scanf("%d", &(C[i]));
   }
   
   int result=0;
   qsort(&C,N,sizeof(int),cmp);
   int j,x;
    x=0;
    //for(i=0;i<N;i++)
   //{
     //  printf("%d ",C[i]);
   // }
   for(i=0;i<N;i++)
   {
       
       result+=(C[i]*(x+1));
       if((i+1)%K==0)
           x++;
   }
   printf("%d\n", result);

}