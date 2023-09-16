//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG implements Runnable {
    public void run() {
        try {
            BufferedReader in;
            PrintWriter out;
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int t = Integer.parseInt(in.readLine());

            while (t-- > 0) {
                int n = Integer.parseInt(in.readLine().trim());

                Solution g = new Solution();
                out.println(g.countWays(n));
            }
            out.close();
        } catch (Exception e) {
            ;
        }
    }

    public static void main(String args[]) throws IOException {
        new Thread(null, new GFG(), "whatever", 1 << 26).start();
    }
}
// } Driver Code Ends




//User function Template for Java


class Solution
{
    
    static long mod=1000000007;
    //Function to count the number of ways in which frog can reach the top.
    static long countWays(int n)
    {
        // add your code here
        
        long dp[]=new long[n+1];
        
        
        // for(int i=0;i<n+1;i++){
            
        //     dp[n]=-1;
        // }
        
        
        return sol(n,dp);
        
        
    }
    
     static long sol(int n,long dp[]){
         
         if(n==0){
             return 1;
         }
         
         else if(n<0){
             return 0;
         }
         
         if(dp[n]>0){
             return dp[n];
         }
         
         
         dp[n]=(sol(n-1,dp)+sol(n-2,dp)+sol(n-3,dp))%mod;
         return dp[n];
     }
    
    
    
    
}

