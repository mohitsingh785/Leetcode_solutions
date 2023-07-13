//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] nums = IntArray.input(br, n);
            
            
            int k;
            k = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.longestOnes(n, nums, k);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int longestOnes(int N, int[] arr, int M) {
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
        
