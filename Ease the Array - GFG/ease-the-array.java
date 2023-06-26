//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    int n = Integer.parseInt(br.readLine());
		    int arr [] = new int[n];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<n;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    obj.modifyAndRearrangeArr(arr, n);
		    for(int i=0; i< n;i++){
		        System.out.print(arr[i] + " ");
		    }
		    System.out.println();
		}
	}
}



// } Driver Code Ends


//User function Template for Java


class Solution{
    void modifyAndRearrangeArr (int arr[], int n) {
        // Complete the function
        
          int j=0;
       int count=0;
       for(int i=0;i<n-1;i++){
           
             if(arr[i]==arr[i+1]){
               
               arr[i]=arr[i]*2;
               arr[i+1]=0;
           }
           if(arr[i]==0){
               count++;
           }
           else{arr[j++]=arr[i];}
       }
       
       if(arr[n-1]>0){
           arr[j++]=arr[n-1];
       }
       
       
          for(int i=0;i<count;i++){
          arr[j++]=0;
       }
    }
}


