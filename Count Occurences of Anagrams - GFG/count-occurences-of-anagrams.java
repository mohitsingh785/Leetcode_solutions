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
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        // code here
        
       HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map1 = new HashMap<>();
         
        for (int i = 0; i < pat.length(); i++) {
            char a = pat.charAt(i);
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
         
        int i = 0;
        int j = 0;
         
        int ans = 0;
         int count=0;
        while (i < txt.length()) {
            char a = txt.charAt(i);
              
            
                map1.put(a, map1.getOrDefault(a, 0) + 1);
            
             
            if (((i - j) + 1) == pat.length()) {
                
               
                
                
                if(map1.equals(map)){
                    ans++;
                    
                    
                }
               
                
                char a1=txt.charAt(j);
                
               
                map1.put(a1,map1.get(a1)-1);
                
                if(map1.get(a1)==0){
                    map1.remove(a1);
                }
                j++;
            }
             
            i++;
        }
        return ans;
    }
}