import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//http://www.math.hmc.edu/funfacts/ffiles/30002.4-5.shtml
//http://en.wikipedia.org/wiki/Lucas%27_theorem
public class Solution {

    ArrayList<BigInteger> getBaseDigits(BigInteger n, BigInteger p)
    {
        ArrayList<BigInteger> a  = new ArrayList<BigInteger>();
        BigInteger zero = new BigInteger("0");
        while(n.compareTo(zero)!=0)
        {
      //      System.out.println("r="+n.mod(p));
            a.add(n.mod(p));
            n=n.divide(p);
        }
        return a;
    }
    
    void calc(Scanner sc)
    {
        
        BigInteger n = new BigInteger(sc.next());
        BigInteger p = new BigInteger(sc.next());
        ArrayList<BigInteger> a = getBaseDigits(n,p);
        BigInteger r= new BigInteger("1");
        BigInteger one = new BigInteger("1");
        for(BigInteger x :a)
        {
            r=r.multiply((x.add(one)));
        }
        BigInteger ans = n.subtract(r);
        ans = ans.add(one);
        System.out.println(ans);
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //sc.next();  
        
        while(t!=0)
        {
//            System.out.println(t);
            s.calc(sc);
            t--;
        }
    }
}