//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
    		System.out.println (new Sol().countRev (s));
        }
        
    }
}
// Contributed By: Pranay Bansal

// } Driver Code Ends


//User function Template for Java

class Sol
{
    int countRev (String s)
    {
        // your code here    
        
        
        Stack<Character> st=new Stack<>();
        
        int ans=0;
        
        
        for(int i=0;i<s.length();i++){
            char a=s.charAt(i);
            if(st.isEmpty() && a=='}'){
                ans++;
                st.add('{');
            }
            else if(st.isEmpty()){
                st.add(a);
            }
            else if(a=='{'){
                st.add(a);
            }
            else{
                
                st.pop();
            }
        }
        
        
        return st.size()%2==0?(st.size()/2)+ans:-1;
    }
}