//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] cost = new int[N];
            
            for(int i=0 ; i<N ; i++)
                cost[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.minCostClimbingStairs(cost,N));
        }
    }
}
// } Driver Code Ends


//Back-end complete function Template for Java

class Solution {
    static int minCostClimbingStairs(int[] cost , int N) {
        //Write your code here
         if(cost.length==2){

            return Math.min(cost[0],cost[1]);
        }


        // cost[cost.length-2]=Math.min(cost[cost.length-1],cost[cost.length-2]);

        for(int i=cost.length-3;i>=0;i--){


            cost[i]=cost[i]+Math.min(cost[i+1],cost[i+2]);
            
        }


        return Math.min(cost[0],cost[1]);
    }
};