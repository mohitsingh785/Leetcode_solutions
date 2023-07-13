//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String inline[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inline[0]);
            int m = Integer.parseInt(inline[1]);
            String inline1[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][m];
            for(int i = 0;i < n*m;i++){
                M[i/m][i%m] = Integer.parseInt(inline1[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.maxGold(n, m, M));
        }
    }
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxGold(int n, int m, int M[][])
    {
         int[][] dp = new int[n][m];

        // Initialize the last column of dp with the values from M
        for (int i = 0; i < n; i++) {
            dp[i][m - 1] = M[i][m - 1];
        }

        // Iterate column-wise from right to left
        for (int j = m - 2; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                int right = dp[i][j + 1]; // Move to the right
                int upRight = (i > 0) ? dp[i - 1][j + 1] : 0; // Move diagonally up towards the right
                int downRight = (i < n - 1) ? dp[i + 1][j + 1] : 0; // Move diagonally down towards the right

                // Calculate the maximum amount of gold that can be collected from the current cell
                dp[i][j] = M[i][j] + Math.max(right, Math.max(upRight, downRight));
            }
        }

        // Find the maximum value in the first column
        int maxGold = dp[0][0];
        for (int i = 1; i < n; i++) {
            maxGold = Math.max(maxGold, dp[i][0]);
        }

        return maxGold;
    }
}