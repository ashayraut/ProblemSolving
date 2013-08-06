#include<iostream>
using namespace std;

#define max(a,b) ((a > b)? a : b)
/* 0 -> valley
   1 -> increasing
   2 -> decreasing
   3 -> peak
*/
int main()
{
	int n;
	cin>>n;
	int a[n];
	
	int stat[n];
	int ans[n];
	if(n==1)
	{
		cout<<n<<endl;
		return 0;
	}
	for(int i=0;i<n;i++)
	{
		cin>>a[i];
		stat[i]=0;
		ans[i]=0;
	}

	for(int i=1;i<n-1;i++)
	{
		if(a[i]>a[i-1] && a[i] > a[i+1] )
			stat[i]=3;
		else if(a[i]>a[i-1])
			stat[i]=1;
		else if(a[i]>a[i+1]  )
			stat[i]=2;
		else
			stat[i]=0;

	}
	
	if(a[0]<=a[1])
	{
		stat[0]=0;
	}
	if(a[0]>a[1])
	{
		stat[0]=2;

	}

	if(a[n-1]>a[n-2])
	{
		stat[n-1]=1;
	}
	if(a[n-1]<=a[n-2])
	{
		stat[n-1]=0;
	}

	for(int i=0;i<n;i++)
	{
		if(stat[i]==0)
			ans[i]=1;
	}
	for(int i=0;i<n;i++)
	{
		if((stat[i]==1)&&(ans[i-1]!=0))
		{
			ans[i]=ans[i-1]+1;
		}
	}
	for(int i=n-1;i>=0;i--)
	{
		if((stat[i]==2)&&(ans[i+1]!=0))
		{
			ans[i]=ans[i+1]+1;
		}
	}
	
	for(int i=0;i<n;i++)
	{
		if((stat[i]==3)&&(ans[i-1]!=0)&&(ans[i+1]!=0))
		{
			ans[i]=max(ans[i-1],ans[i+1])+1;
		}

	}	

	int res=0;
	for(int i=0;i<n;i++)
	{
//		cout<<ans[i]<<" "<<stat[i]<<" "<<a[i]<<endl;
		res +=ans[i];
	}
	cout<<res<<endl;



	return 0;
}

