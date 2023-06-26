//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public void permutation(String s,List<String> list,String ans){
        
        if(s.length()==0){
            if(!list.contains(ans))
            list.add(ans);
            
            return;
        }
        
        
        for(int i=0;i<s.length();i++){
            
            char s1=s.charAt(i);
            
            String str=s.substring(0,i)+s.substring(i+1);
            
            permutation(str,list,ans+s1);
        }
        
        
    }
    public List<String> find_permutation(String S) {
        // Code here
        
        
        List<String> list=new ArrayList<>();
        permutation(S,list,"");
        Collections.sort(list);
        return list;
    }
}