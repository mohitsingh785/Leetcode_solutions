//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    int longestUniqueSubsttr(String S){
         
        HashMap<Character,Integer> map=new HashMap<>();
        
        int max=1;
        
        for(int i=0;i<S.length();i++){
            
            if(map.containsKey(S.charAt(i))){
                
                
                for(int j=i-1;j>=0;j--){
                    
                    if(S.charAt(j)==S.charAt(i)){
                        
                        
                        map.clear();
                        
                        for(int k=j+1;k<i;k++){
                            
                            map.put(S.charAt(k),1);
                        }
                        
                        
                        break;
                    }
                     
                }
                map.put(S.charAt(i),1);
                
            }else{
                
                 map.put(S.charAt(i),1);
            }
            
            max=Math.max(max,map.size());
        }
        
        
        return max;
    }
}