//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[])
    {
        // code here
          int totalSum = 0;

        for (int num : arr) {
            totalSum += num;
        }

        // If the total sum is odd, it's impossible to divide the array into two equal parts.
        if (totalSum % 2 != 0) {
            return 0;
        }

        int targetSum = totalSum / 2;
        int n = arr.length;

        // Initialize a 2D DP table with dimensions (n+1) x (targetSum+1)
        boolean[][] dp = new boolean[n + 1][targetSum + 1];

        // Base case: If the target sum is 0, it's always possible to achieve.
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= targetSum; j++) {
                // If the current element is greater than the target sum, we can't include it.
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Either include the current element or exclude it.
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        // The value at dp[n][targetSum] will be true if it's possible to partition the array.
        return dp[n][targetSum]?1:0;
    }
}