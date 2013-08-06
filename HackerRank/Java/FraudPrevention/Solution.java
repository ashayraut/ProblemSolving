import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Fraud
{
    public String credit;
    public String addr;
    public String zip;
    public String city;
    public String state;
    public String email;
    public Fraud(String e,String c,String a, String z,String ct, String st)
    {
        credit = c;
        addr=a;
        zip=z;
        city=ct;
        state=st;
        email = e;
    }
}
public class Solution {

    String filterEmail(String email)
    {
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<email.length();i++)
        {
            if((email.charAt(i)=='.')||(email.charAt(i)=='@'))
                continue;
            if(email.charAt(i)=='+')
            {
               int j=i+1;
               for(;j<email.length();j++)
               {
                   if(email.charAt(j)=='@')
                       break;
               }
                i=j;
                continue;
                //break;
            }
            sb.append(email.charAt(i));
        }
        return sb.toString();
    }
    String filterStreetAddr(String addr)
    {
       // System.out.println("Prev:"+addr);
        addr = addr.replaceAll("st[.]","street");
        addr = addr.replaceAll("rd[.]","road");
       // System.out.println(addr);
        return addr;
    }
    String filterState(String addr)
    {
         
       if(addr.equals("illinois"))
       {
           
            return "il";
       }
        
        if(addr.equals("california"))
            return "ca";
        
        if(addr.equals("new york"))
            return "ny";
         
       /* addr=addr.replace("il","illinois");
        addr=addr.replace("ca","california");
        addr=addr.replace("ny","new york");*/
        //System.out.println("Prev:"+addr);
        return addr;
    }
    void calc()
    {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        String deal;
        HashSet<Integer> dealSet = new HashSet<Integer>();
        HashMap<Integer,HashSet<String> > emailSetMap = new HashMap<Integer,HashSet<String> >();
        HashMap<Integer,HashSet<String> > addrSetMap = new HashMap<Integer,HashSet<String> >();
        HashMap<Integer,HashSet<String> > citySetMap = new HashMap<Integer,HashSet<String> >();
        HashMap<Integer,HashSet<String> > stateSetMap = new HashMap<Integer,HashSet<String> >();
        HashMap<Integer,HashSet<String> > zipSetMap = new HashMap<Integer,HashSet<String> >();
        HashMap<Integer,HashSet<String> > creditSetMap = new HashMap<Integer,HashSet<String> >();
        
        HashMap<Integer,ArrayList<Integer>> dealOrderMap = new HashMap<Integer,ArrayList<Integer>>();
        HashMap<Integer,String> orderAddrMap = new HashMap<Integer,String>();
         HashMap<Integer,String> orderEmailMap = new HashMap<Integer,String>();
        int dealId=0,orderId=0;
        String email,zip,addr,state,city,credit;
        ArrayList<Integer> orderIdList;
        SortedSet<Integer> ansSet = new TreeSet<Integer>(); 
        SortedSet<Integer> noSet = new TreeSet<Integer>();
        deal = sc.nextLine();
        for(int i=0;i<n;i++)
        {
            deal = sc.nextLine();
            
          //  System.out.println("Deal:"+deal+ " n="+n);
            deal = deal.toLowerCase();
            String [] tokens = deal.split(",");
            //System.out.println("Deal:"+deal + " len:"+tokens[0]);
            orderId = Integer.parseInt(tokens[0]);
            dealId = Integer.parseInt(tokens[1]);
            email = filterEmail(tokens[2]);
            addr = filterStreetAddr(tokens[3]);
            city = filterState(tokens[4]);
            state = filterState(tokens[5]);
            //zip = Integer.parseInt(tokens[6]);
            zip=tokens[6];
            credit = tokens[7];
        
            
            boolean valid = true;
            boolean emailMatched=false;
            boolean addrMatched=false;
            if(dealSet.contains(dealId))
            {
                                        
               if(!((creditSetMap.get(dealId)).contains(credit)))
               {
                /*   if( ((addrSetMap.get(dealId)).contains(addr))||
                        ((zipSetMap.get(dealId)).contains(zip))||
                      ((stateSetMap.get(dealId)).contains(state))||
                      ((citySetMap.get(dealId)).contains(city)))
                   {valid = false;}*/
                   if(addrSetMap.get(dealId).contains(addr + city + state + zip))
                   {
                           valid = false;
                           addrMatched = true;
                   }
                   if((emailSetMap.get(dealId)).contains(email))
                   {
                       emailMatched = true;
                       valid =false;
                   }
               }
                
                    
            }
            orderIdList = dealOrderMap.get(dealId); 
            if(orderIdList==null)
            {
                orderIdList = new ArrayList<Integer>();
            }
             orderEmailMap.put(orderId,new String(email));
            orderAddrMap.put(orderId,new String(addr + city + state + zip));
            orderIdList.add(orderId);
      //    System.out.println("DealId:" + dealId + " email:" + email + " orderid:" + orderId + " Addr:"+addr + " State:"+state + " City:" + city + " zip" + zip);
            if(!valid)
            {

                for(Integer o : orderIdList)
                {
              //     System.out.println("o="+o);
                    if(emailMatched)
                    {
                        if(orderEmailMap.get(o).equals(email))
                            ansSet.add(o);
                    }
                    else if(addrMatched)
                    {
                        if(orderAddrMap.get(o).equals(addr + city + state + zip))
                            ansSet.add(o);
                    }
                    
                }
                
            }
           
           
            dealOrderMap.put(dealId,orderIdList);
            dealSet.add(dealId);
            /*emailSet.add(email);
            citySet.add(city);
            stateSet.add(state);
            zipSet.add(zip);
            addrSet.add(addr);
            creditSet.add(credit);*/
            add(dealId,credit,creditSetMap);
            add(dealId,email,emailSetMap);
           /*add(dealId,addr,addrSetMap);
            add(dealId,city,citySetMap);
            add(dealId,state,stateSetMap);
            add(dealId,zip,zipSetMap);*/
           
            add(dealId,addr + city + state + zip,addrSetMap);
            
        }
        int i=0;
        Iterator<Integer> it = ansSet.iterator();
        while(it.hasNext())
        {
            i++;
            it.next();
        }
        it = ansSet.iterator();
        while(it.hasNext() && i>1)
        {
            i--;
            System.out.print(it.next()+",");
        }
        if(i==1)
            System.out.println(it.next());
    }
    void add(int dealId,String value,Map<Integer,HashSet<String>> m)
    {
        HashSet<String> hset = m.get(dealId);
        if(hset==null)
        {
            hset = new HashSet<String>();
        }
        hset.add(value);
        m.put(dealId,hset);
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.calc();
    }
}