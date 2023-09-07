//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.reverse(s));                        
        }
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String reverse(String str)
    {
        //complete the function here
        
        Stack<Character> st=new Stack<>();
        
        for(int i=0;i<str.length();i++){
            
            char a=str.charAt(i);
            if((a>='a'  && a<='z' ) ||(a>='A'  && a<='Z' )  ){
                st.add(a);
            }
        }
        StringBuilder  ans=new StringBuilder();
         for(int i=0;i<str.length();i++){
            
            char a=str.charAt(i);
            if((a>='a'  && a<='z' ) ||(a>='A'  && a<='Z' )  ){
                ans.append(st.pop()+"");
            }
            else{
                
                ans.append(a);
                
            }
        }
        
        return ans.toString();
    }
}