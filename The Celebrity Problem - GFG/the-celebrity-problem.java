//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	    Stack<Integer> stack = new Stack<>();
// push all the elements in the stack       

for(int i=0;i<n;i++){
            stack.push(i);
        }
       

while(stack.size()>1){
            int a = stack.peek();
            stack.pop();
            int b = stack.peek();
             stack.pop();
        
 //  candiate "a"  , candidate "b" ko jaanta he toh "a" toh celebrity nhi ho skta isliye b ko push krdenge
             if(M[a][b]==1){     
                 stack.push(b);  
             }
             // nhi to candidate "a" ko stack me push krdenge
             else{
                 stack.push(a);  
             }
        }
        
 //jo last me stack me bachega hm use potential candidate maanege aur use "ans" ke ander store kara lenge phir us candidate pe condition check krenge
       

int ans = stack.peek();
         stack.pop();            
         
         for (int i=0;i<n;i++){
             if(i!=ans){
             
   // agar ans , "i" ko janata he to ans celebritity nhi he    , agar "i" , ans ko nhi jaanta toh bhi ans celebrity nhi    
             

if(M[ans][i]==1 || M[i][ans]==0){ 
                 return -1;                    
             }                     
         }
         
         } 
        
     return ans;
    }
}