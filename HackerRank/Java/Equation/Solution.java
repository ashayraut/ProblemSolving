import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    void ans()
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean []prime =  new boolean[n+1];
	
    int x = n+1;//(int)Math.sqrt(n)+10;
	for(int i=0;i<x;i++)
	{
		prime[i]=true;
		
	}
    int j;
        boolean cut=false;
	for(int p=2;p<x && !cut;p++)
	{
		if(prime[p])
		{
            
			for(j=p*p;j<x && !cut;j=j+p)
			{
                if(j<0)
                {
                    cut=true;
                    break;
                }
				prime[j]=false;
                
                    
			}
		}
	}	

	int tmp = n;
	int mcount=0;
	int cnt=0;
	long res=1;
	for(int i=2;i<x;i++)
	{
		tmp = n;
		cnt=0;
		if(prime[i])
		{
			while(tmp!=0)
			{
				cnt = cnt + tmp/i;
				tmp = tmp/i;
			}
		}

		res = res * (2*cnt+1);
		res = res %1000007;
    }
        
        System.out.println(res);
   }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.ans();
    }
}

