//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int lps(String s) {
        // code here
        
        int i=1;
        int j=0;
      int lps[]=new int[s.length()];
        while(i<s.length()){
            
            
           if(s.charAt(i)==s.charAt(j)){
               
               lps[i]=j+1;
               j++;
               i++;
           }
           else{
               
               if(j==0){
                   i++;
               }
               else{
                   j=lps[j-1];
               }
           }
        }
        
        return lps[lps.length-1];
    }
}