//{ Driver Code Starts
import java.util.*;

class ArrPathSum1
{
	// Driver Code
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(T>0)
		{
			int m = sc.nextInt();
			int n = sc.nextInt();
			int ar1[] = new int[m];
			int ar2[] = new int[n];
			for(int i=0; i<m; i++)
				ar1[i] = sc.nextInt();
			for(int i=0; i<n; i++)
				ar2[i] = sc.nextInt();
		
		Solution g = new Solution();
		System.out.println(g.maxPathSum(ar1,ar2));
		T--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    /*You are required to complete this method
    * ar1 : 1st array
    * ar2 : 2nd array
    */
    int maxPathSum(int arr1[], int arr2[])
    {
        // Your code here
        
      int ptr1 = 0, ptr2 = 0;
        int sum1 = 0, sum2 = 0;
        int maxSum = 0;
        
        while (ptr1 < arr1.length && ptr2 < arr2.length) {
            if (arr1[ptr1] == arr2[ptr2]) {
                maxSum += Math.max(sum1, sum2) + arr1[ptr1];
                sum1 = 0;
                sum2 = 0;
                ptr1++;
                ptr2++;
            } else if (arr1[ptr1] < arr2[ptr2]) {
                sum1 += arr1[ptr1];
                ptr1++;
            } else {
                sum2 += arr2[ptr2];
                ptr2++;
            }
        }
        
        while (ptr1 < arr1.length) {
            sum1 += arr1[ptr1];
            ptr1++;
        }
        
        while (ptr2 < arr2.length) {
            sum2 += arr2[ptr2];
            ptr2++;
        }
        
        maxSum += Math.max(sum1, sum2);
        
        return maxSum;
    }
}