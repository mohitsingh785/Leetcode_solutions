//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.math.*;

class Multiply{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String a=sc.next();
            String b=sc.next();
            Solution g=new Solution();
            System.out.println(g.multiplyStrings(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String multiplyStrings(String s1,String s2)
    {
        //code here.
         //code here.
        BigInteger val=new BigInteger(s1);
         BigInteger val2=new BigInteger(s2);
          BigInteger ans1=new BigInteger(s2);
        ans1 =val.multiply(val2);
        String ans=ans1.toString();
        
        return ans;
    }
}