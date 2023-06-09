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
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static List<Integer> nextPermutation(int N, int arr[]){
        // code here
        
        int idx=-1;
        
        for(int i=arr.length-1;i>0;i--){
            
            if(arr[i]>arr[i-1]){
                idx=i;
                break;
            }
        }
        
        if(idx==-1){
            Arrays.sort(arr);
            
        }
        else{
        
        int prev=idx;
        
        for(int i=idx+1;i<arr.length;i++){
            
            if(arr[idx-1]<arr[i] && arr[i]<=arr[idx]){
                
                prev=i;
            }
        }
        
         int temp=arr[prev];
            arr[prev]=arr[idx-1];
            arr[idx-1]=temp;
            
             int j=arr.length-1;
            for(int i=idx;i<arr.length;i++){
                if(i>j){
                    break;
                }
                int temp1=arr[j];
                arr[j]=arr[i];
                arr[i]=temp1;
                j--;
                
            }
        }    
            ArrayList<Integer> list=new ArrayList<>();
            
            for(int a:arr){
                list.add(a);
            }
            return list; 
    }
}