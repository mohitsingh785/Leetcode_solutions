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
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
        
        
        for(int i=0;i<a[0].length;i++){
            
            dfs1(a,0,i);
            dfs1(a,a.length-1,i);
        }
        
        
         for(int i=0;i<a.length;i++){
            
            dfs1(a,i,0);
            dfs1(a,i,a[0].length-1);
        }
        
        
        
        for(int i=0;i<a.length;i++){
            
            
            for(int j=0;j<a[0].length;j++){
                
                
                if(a[i][j]=='O'){
                    dfs(a,i,j);
                }
            }
        }
        
          for(int i=0;i<a[0].length;i++){
            
            dfs2(a,0,i);
            dfs2(a,a.length-1,i);
        }
        
        
         for(int i=0;i<a.length;i++){
            
            dfs2(a,i,0);
            dfs2(a,i,a[0].length-1);
        }
        
    
        return a;
    }
    
    
    static void dfs1(char [][]a,int i,int j){
        
        if(i<0 || i>=a.length || j<0 || j>=a[0].length || a[i][j]!='O'){
            
            return;
        }
        
        a[i][j]='P';
        
        dfs1(a,i+1,j);
        dfs1(a,i-1,j);
        dfs1(a,i,j+1);
        dfs1(a,i,j-1);
        
        
    }
    static void dfs(char [][]a,int i,int j){
        
        if(i<0 || i>=a.length || j<0 || j>=a[0].length || a[i][j]!='O'){
            
            return;
        }
        
        a[i][j]='X';
        
        dfs(a,i+1,j);
        dfs(a,i-1,j);
        dfs(a,i,j+1);
        dfs(a,i,j-1);
        
        
    }
    
     static void dfs2(char [][]a,int i,int j){
        
        if(i<0 || i>=a.length || j<0 || j>=a[0].length || a[i][j]!='P'){
            
            return;
        }
        
        a[i][j]='O';
        
        dfs2(a,i+1,j);
        dfs2(a,i-1,j);
        dfs2(a,i,j+1);
        dfs2(a,i,j-1);
        
        
    }
}