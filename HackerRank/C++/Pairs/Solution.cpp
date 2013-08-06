#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include<stdlib.h>
using namespace std;

int cmp(const void *a,const void *b)
{
    const int *a1=(const int*)a;
    const int *b1=(const int*)b;
    return (*a1-*b1);
}
bool myfunction (int i,int j) { return (i<j); }
int main() {
    int n,k;
    cin>>n>>k;
    int a[n];
    for(int i=0;i<n;i++)
        cin>>a[i];
    qsort(&a,n,sizeof(int),cmp);
    //for(int i=0;i<n;i++)
     //   cout<<a[i]<<endl;
    int pairs=0;
    int x=0,j=0;
    for(int i=0;i<n;i++)
    {
        x = k + a[i];
        j=i+1;
        while(j<n && a[j]<=x)
        {
            if(a[j]==x)
            {
                pairs++;
                break;
            }
            j++;
        }
        
    }
    cout<<pairs<<endl;
    return 0;
}
