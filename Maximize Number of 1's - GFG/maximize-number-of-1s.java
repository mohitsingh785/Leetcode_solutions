//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            int m = Integer.parseInt(br.readLine().trim());

            int ans = new Solve().findZeroes(arr, n, m);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    // m is maximum of number zeroes allowed to flip
    int findZeroes(int arr[], int N, int M) {
        // code here
        	
		
		
		
		int max=Integer.MIN_VALUE;
//		int [] arr= {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
		int i=0;
		int j=0;
		int count=0;
		int K=M;
		while(i<N) {
			
			if(arr[i]==1) {
				++count;
				i++;
			}
			else if(K>0) {
				K--;
				++count;
				i++;
			}
			else {
				// System.out.print(i+" "+ count+" |");
				max=Math.max(max, count);
				
				if(arr[j]==1) {
					count--;
				}
				else {
					
					K++;
					count--;
				}
				
				j++;
				
				
			}
			
			
		}
// 		System.out.print(i+" "+ count+" |");
		max=Math.max(max, count);
// 		System.out.println();
		
		return max;
    }
}