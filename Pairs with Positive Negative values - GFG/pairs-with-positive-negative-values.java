//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            List<Long> answer = obj.PosNegPair(a, n);
            int sz = answer.size();
            
            if(sz==0)
            System.out.println(0);
            
            else{
                StringBuilder output = new StringBuilder();
                for(long x : answer)
                output.append(x+" ");
                System.out.println(output);
            }
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public List<Long> PosNegPair(long a[], long n)
    {
        
        
        HashMap<Long,Integer> map=new HashMap<>();
        
        ArrayList<Long> ans=new ArrayList<>();
        
        for(long a1:a){
            
            map.put(a1,map.getOrDefault(a1,0)+1);
            
            if(a1>0){
                ans.add(a1);
            }
        }
        
        
        ArrayList<Long> list=new ArrayList<>();
        
        Collections.sort(ans);
        // Arrays.sort(a);
        
        for(int i=0;i<ans.size();i++){
            
            
            long val=ans.get(i);
            
            if(map.containsKey(val)){
             map.put(val,map.get(val)-1);
             
             if(map.get(val)==0){
                 map.remove(val);
             }
             
                 long val1=0-val;
                //  System.out.println(val1);
                if(map.containsKey(val1)){
                     map.put(val1,map.get(val1)-1);
             
             if(map.get(val1)==0){
                 map.remove(val1);
             }
             
             list.add(val1);
             list.add(val);
                }
            }
           
        }
        
        
        
        return list;
    }
}