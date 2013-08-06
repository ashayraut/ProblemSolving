using System;
using System.Collections.Generic;
using System.IO;
class Solution
{
    static void Main(String[] args)
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution */
        int t;
        t = Convert.ToInt32(Console.ReadLine());
        int n;
        long shifts;
        int index = 0;
        while (t != 0)
        {
            //            Console.WriteLine("t="+t);
            n = Convert.ToInt32(Console.ReadLine());
            int[] x = new int[n];
            List<int> alist = new List<int>();
            int tot = 0;
            shifts = 0;
            String tmp = Console.ReadLine();
            String[] tokens = tmp.Trim().Split(new Char[] { ' ' });
            for (int i = 0; i < n; i++)
            {


                x[i] = Convert.ToInt32(tokens[i]);

                if (tot == 0)
                {
                    alist.Add(x[i]);
                }
                else if (alist[tot - 1] <= x[i])
                {
                    alist.Add(x[i]);
                }
                else
                {
                    index = GetPosition(alist, 0, tot - 1, x[i]);
                    //Console.WriteLine("index="+index +  " for " + x[i]);
                    shifts += (long)(tot - index);
                    alist.Insert(index, x[i]);
                }

                tot++;
            }
            t--;
            Console.WriteLine(shifts);
        }
    }
    static int GetPosition(List<int> alist, int start, int end, int val)
    {
        int mid;
        while (start <= end)
        {
            mid = start + (end - start) / 2;
            if (alist[mid] == val)
            {
                int tmp = mid;
                while (tmp <= end && alist[tmp] == val)
                    tmp++;
                return tmp;
            }
            if (alist[mid] < val)
                start = mid + 1;
            else
                end = mid - 1;
        }
        while (start <= end && alist[start] <= val)
            start++;
        return start;
    }
}