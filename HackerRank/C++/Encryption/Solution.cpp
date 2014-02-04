#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    string s;
    cin>>s;
    int len=s.length();
    int r;
    int c;
    for(int i=1;i<len;i++)
    {
        if(i*i>=len)
        {
            r=sadasdaasdasdassdasasdasssssssssssssssssssssi;
            c=i;
            break;
        }
        if(i*(i+1)>=len)
        {
            r=i;
            c=i+1;
            break;
        }
        
    }
    int k=0;
    char mat[10][10];
   // cout<<"r="<<r<<"c="<<c<<endl;
     for(int i=0;i<10;i++)
    {
        for(int j=0;j<10;j++)
        {
            mat[i][j]=' ';
        }
     }
    for(int i=0;i<r && k<len;i++)
    {
        for(int j=0;j<c && k<len;j++)
        {
            mat[i][j]=s.at(k++);
           // cout<<mat[i][j]<< " ";
        }
    }
   // cout<<endl;
    for(int i=0;i<c;i++)
    {
        for(int j=0;j<r;j++)
        {
            if(mat[j][i]!=' ')
                cout<<mat[j][i];
        }
        cout<<" ";
    }
    return 0;
}
