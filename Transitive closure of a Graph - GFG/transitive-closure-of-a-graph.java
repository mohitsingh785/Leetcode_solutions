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
            int N = Integer.parseInt(in.readLine());
            int graph[][] = new int[N][N];
            
            for(int i = 0;i < N;i++)
                {String a[] = in.readLine().trim().split("\\s+");
                for(int j=0;j<N;j++)
                graph[i][j] = Integer.parseInt(a[j]);}
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.transitiveClosure(N, graph);
            for(int i = 0;i < N;i++)
               { for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
            System.out.println();}
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<ArrayList<Integer>> transitiveClosure(int N, int graph[][])
    {
        // code here
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        
        
        
        for(int i=0;i<N;i++){
            
            
            ArrayList<Integer> ans=new ArrayList<>();
            
            boolean[] visited=new boolean[N];
            
            dfs(graph,ans,i,N,visited);
            
            list.add(ans);
        }
        
          // Determine the number of nodes
        int numNodes = list.size();

        // Convert the adjacency list to an adjacency matrix
        ArrayList<ArrayList<Integer>> list1 = new ArrayList<>();
        
        for (int i = 0; i < numNodes; i++) {
            ArrayList<Integer> row = new ArrayList<>(Collections.nCopies(numNodes, 0));
            ArrayList<Integer> neighbors = list.get(i);
            for (int neighbor : neighbors) {
                row.set(neighbor, 1);
            }
            
            list1.add(row);
        }
        return list1;
        
    }
    
    
    
    static void dfs(int graph[][],ArrayList<Integer> ans,int s,int N, boolean[] visited){
        
        ans.add(s); 
        visited[s]=true;
        for(int i=0;i<N;i++){
            
            if(graph[s][i]==1 && !visited[i]){
            dfs(graph,ans,i,N,visited);
            }
        }
        
    }
}