//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		while(t-->0)
		{
		    //taking dimensions of the matrix
		    int a=sc.nextInt();
		    int b=sc.nextInt();
		    Solution ob = new Solution();
		    //calling method NumberOfPath()
		    System.out.println(ob.NumberOfPath(a,b));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find total number of unique paths.
    public static int NumberOfPath(int m, int n) 
    {
        //Your code here
          int [][]dp=new int[m][n];



        for(int i=m-1;i>=0;i--){

            for(int j=n-1;j>=0;j--){


                if(i==m-1 || j==n-1){

                    dp[i][j]=1;
                }
                else{
                   
                   dp[i][j]+=dp[i+1][j]+dp[i][j+1];
                }

               
            }
        }
        return dp[0][0];
    }
}