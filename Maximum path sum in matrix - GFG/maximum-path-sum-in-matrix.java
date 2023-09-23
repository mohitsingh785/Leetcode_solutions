//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maximumPath(int N, int grid[][])
    {
        // code here
          if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int [][]dp=new int[m][n];


        for(int i=m-1;i>=0;i--){

            for(int j=n-1;j>=0;j--){


                if(i==m-1 && j==n-1){
                    dp[i][j]=grid[i][j];
                }
                else if(i==m-1){
                   dp[i][j]= grid[i][j];
                }
                 else if(j==n-1){
                   dp[i][j]= Math.max(dp[i+1][j],dp[i+1][j-1])+grid[i][j];
                }
                else if(j==0){
                    dp[i][j]= Math.max(dp[i+1][j],dp[i+1][j+1])+grid[i][j];
                }
                else{
                      dp[i][j]= Math.max(Math.max(dp[i+1][j],dp[i+1][j+1]),dp[i+1][j-1])+grid[i][j];
                }
            }
        }


     int max=-1;
     
     for(int i=0;i<n;i++){
         
         
         max=Math.max(max,dp[0][i]);
     }
        return max;
    }
}