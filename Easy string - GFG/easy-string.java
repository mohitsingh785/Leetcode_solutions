//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String s = read.readLine();
            Solution ob = new Solution();
            String ans = ob.transform(s);
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    String transform(String S) 
    {
        // code here
         int count = 1;
        StringBuilder sb = new StringBuilder();
        
        S = S.toLowerCase();
        
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i - 1) == S.charAt(i)) {
                count++;
            } else {
                sb.append(count).append(S.charAt(i - 1));
                count = 1;
            }
        }
        
        sb.append(count).append(S.charAt(S.length() - 1));
        
        return sb.toString();
    }
} 