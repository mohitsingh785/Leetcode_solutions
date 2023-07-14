//{ Driver Code Starts
//Initial Template for Java




import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().minOperations(arr, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java





class Solution {
    int minOperations(int[] arr, int n, int k) {
        // code here
        
        
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        
        for(int a:arr){
            pq.add(a);
        }
        
        int count=0;
        while(!pq.isEmpty() && pq.size()>=2){
            
            
            int val1=pq.poll();
            int val2=pq.poll();
            
            if(val1>=k && val2>=k){
                return count;
            }
            
            // System.out.println(val1+" "+val2);
            pq.add(val1+val2);
            count++;
        }
        
        if(pq.size()==1){
            
            int val=pq.poll();
            if(val<k){
                return -1;
            }
        }
        return count;
    }
}
