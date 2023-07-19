//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            
            int n=Integer.parseInt(in.readLine().trim());
            int a[]=new int[n];
            String s[]=in.readLine().trim().split(" ");
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(s[i]);
            }
            s=in.readLine().trim().split(" ");
            int penalty[]=new int[n];
            for(int i=0;i<n;i++){
                penalty[i]=Integer.parseInt(s[i]);
            }
            Solution ob=new Solution();
            long ans=ob.totalTime(n,a,penalty);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static long totalTime(int n,int arr[],int penalty[])
    {
        
        int count=-1;
        
        HashSet<Integer> set=new HashSet<>();
        
        
        
        for(int i=0;i<n;i++){
            
            if(!set.contains(arr[i])){
                
                count++;
                set.add(arr[i]);
            }
            else{
                
                
                count+=penalty[arr[i]-1];
                // System.out.println(penalty[arr[i]-1]);
                
                
            }
            
        }
        
        return count;
    }
}