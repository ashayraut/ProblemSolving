#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include<stdlib.h>
 
using namespace std;
 
int cmp(const void*a,const void *b)
{
    return (*(const int*)a - *(const int *)b);
}
 
 
 
long long eligibleNos( std::vector<int> v,int n,int picked,int start)
{

 
  std::vector<int>::iterator low,up;
  up= std::upper_bound (v.begin()+start, v.end(), picked); //                   ^
  return up-(v.begin()+start);
}

void calcAns(int n,int *a)
{
  
/*  long long ans=1;
 for(int i = n - 1;i >= 0;i--)
 {
  int low = -1,high = n ;
  while(low + 1 < high)
  {
   int mid = low + (high - low) / 2 ;
   if(a[mid] <= i) low = mid ;
   else high = mid ;
  }
  int ct = low + 1 ;
  if(ct <= i) ans = 0 ;
  else ans = 1LL * (ct - i) * ans % 1000000007 ;
 }*/
    long long ans=1;
 for(int i = 0;i < n;i++)
 {
  int low = -1,high = n ;
  while(low + 1 < high)
  {
   int mid = low + (high - low) / 2 ;
   if(a[mid] <= i) low = mid ;
   else high = mid ;
  }
  int ct = low + 1 ;
  if(ct <= i) ans = 0 ;
  else ans = 1LL * (ct - i) * ans % 1000000007 ;
 }
    cout<<ans<<endl;
 
}
int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    int t;
    cin>>t;
    int n;
    while(t)
    {
        cin>>n;
        int a[n];
        for(int i=0;i<n;i++)
            cin>>a[i];
        qsort(a,n,sizeof(int),cmp);
        calcAns(n,a);   
        t--;
    }
}

