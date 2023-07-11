//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxLength(String s){
        // code here
        Stack<Integer> sa=new Stack<>();
          if(s==null ||s.length()<2) return 0;
          int max=0;
          sa.push(-1);
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                sa.push(i);
            }
            else if(ch==')'){
                sa.pop();
                if(sa.empty()){
                    sa.push(i);
                }
                else
                {
                  max=Math.max(max,i-sa.peek());
                }
            }
           
                
            }
        
      
        return max;
    }
}