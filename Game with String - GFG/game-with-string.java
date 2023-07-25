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
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minValue(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int minValue(String s, int k){
        // code here
        
        HashMap<Character,Integer> map=new HashMap<>();
        
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<s.length();i++){
            char a=s.charAt(i);
            
            map.put(a,map.getOrDefault(a,0)+1);
        }
        
        for(int a:map.values()){
            
            pq.add(a);
        }
        
        for(int i=0;i<k;i++){
            
            int val=pq.poll();
            val--;
            pq.add(val);
        }
        
        int ans=0;
        
        
        while(!pq.isEmpty()){
            
            ans+=Math.pow(pq.poll(),2);
            // System.out.println(ans);
        }
        
        
        
        return ans;
    }
}