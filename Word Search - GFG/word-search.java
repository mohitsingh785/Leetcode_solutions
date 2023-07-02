//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isWordExist(char[][] board, String word)
    {
        // Code here
        
         char[] w = word.toCharArray(); 
// simply creating boolean array of visited cells 
        boolean[][] visi = new boolean[board.length][board[0].length];
        for(int row=0; row<board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                if(found(board,row,col,w,0,visi)) return true;
            }
        }
        return false;
    }
    
      public boolean found(char[][] board,int row,int col,char[] w ,int i ,boolean[][] visi){
        if(i == w.length) return true; // you reached at the destinations
        if(row<0 || row>=board.length || col<0 || col>=board[row].length || board[row][col]!=w[i] || visi[row][col] == true) return false; 
        visi[row][col] = true; // mark the particular row and col you visited as a true(reason--not to get trap in infinite loop)
// choose any directions accordingly , like i choose right,down,left,up
        if(found(board,row,col+1,w,i+1,visi)) return true;  
        else if (found(board,row+1,col,w,i+1,visi)) return true; 
        else if (found(board,row,col-1,w,i+1,visi)) return true; 
        else if(found(board,row-1,col,w,i+1,visi)) return true; 
        visi[row][col] = false; // mark false if char at i doesn't match
         
        return false;
    }
}