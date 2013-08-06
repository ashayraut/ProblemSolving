/* Sample program illustrating input/output */
using System;
using System.Collections.Generic;
using System.IO;
class Solution
{

    static void Main(String[] args)
    {
        int N;
        N = Convert.ToInt32(Console.ReadLine());
        int[] x = new int[N];
        string[] s = new string[N];

        for (int i = 0; i < N; i++)
        {

            string tmp = Console.ReadLine();
            string[] split = tmp.Split(new Char[] { ' ', '\t', '\n' });

            s[i] = split[0].Trim();
            x[i] = Convert.ToInt32(split[1].Trim());

        }
        List<int> alist = new List<int>();
        int tot = 0;
        int index;

        for (int i = 0; i < N; i++)
        {
            //Console.WriteLine(s[i]+ " " + x[i]);
            index = -1;
            if (s[i].Equals("r"))
            {
                if (tot == 0)
                {
                    Console.WriteLine("Wrong!");
                    continue;
                }

                //  index = FindElem(alist,0,tot-1,x[i]);
                index = alist.BinarySearch(x[i]);
                if (index < 0)
                {
                    Console.WriteLine("Wrong!");
                    continue;
                }
                alist.RemoveAt(index);
                tot--;
                GetMedian(alist, tot);
            }
            else
            {
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
                    alist.Insert(index, x[i]);
                }
                tot++;
                GetMedian(alist, tot);
            }

        }
    }

    static int GetPosition(List<int> alist, int start, int end, int val)
    {
        int mid;
        while (start <= end)
        {
            mid = start + (end - start) / 2;
            if (alist[mid] == val)
                return mid;
            if (alist[mid] < val)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return start;
    }


    static void GetMedian(List<int> alist, int tot)
    {
        // Console.WriteLine("Tot :" + tot);
        if (tot == 0)
        {
            Console.WriteLine("Wrong!");
            return;
        }
        if (tot == 1)
        {
            Console.WriteLine(alist[tot - 1]);
            return;
        }
        long median;
        if (tot % 2 == 0)
        {

            median = (long)((long)alist[tot / 2] + (long)alist[tot / 2 - 1]);
            Console.WriteLine(((double)median) / 2);
            return;
        }
        else
        {
            median = alist[tot / 2];
        }
        Console.WriteLine(median);

    }
}