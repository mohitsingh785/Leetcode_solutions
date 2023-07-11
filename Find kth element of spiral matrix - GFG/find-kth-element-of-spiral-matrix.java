//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[1000][1000];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    /*You are required to complete this method*/
    int findK(int a[][], int m ,int n, int p)
    {
	// Your code here	
	 int i, k = 0, l = 0;
 
        /*  k - starting row index
        m - ending row index
        l - starting column index
        n - ending column index
        i - iterator
        */
        
 
        while (k < m && l < n && p>0) {
            // Print the first row from the remaining rows
           
            
            for (i = l; i < n; ++i) {
             p--;
             
             if(p==0){
                 return a[k][i];
             }
            }
            k++;
 
            // Print the last column from the remaining
            // columns
            for (i = k; i < m; ++i) {
                // System.out.print(a[i][n - 1] + " ");
                p--;
                 if(p==0){
                 return a[i][n-1];
             }
            }
            n--;
 
            // Print the last row from the remaining rows */
            if (k < m) {
                for (i = n - 1; i >= l; --i) {
                    // System.out.print(a[m - 1][i] + " ");
                    p--;
                     if(p==0){
                 return a[m-1][i];
             }
                }
                m--;
            }
 
            // Print the first column from the remaining
            // columns */
            if (l < n) {
                for (i = m - 1; i >= k; --i) {
                    // System.out.print(a[i][l] + " ");
                    p--;
                     if(p==0){
                 return a[i][l];
             }
                }
                l++;
            }
        }
        return -1;
    }
}