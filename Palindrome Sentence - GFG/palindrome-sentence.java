//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
       public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while(t > 0){
            String str = sc.nextLine();
            Solution ob = new Solution();
            if(ob.sentencePalindrome(str))
                System.out.println(1);
            else
                System.out.println(0);
            t--;
        }
    } 
} 
// } Driver Code Ends


class Solution { 

    static boolean sentencePalindrome(String s) { 
        // code here
        
    StringBuilder ans = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isLetter(c)) {
                ans.append(Character.toLowerCase(c));
            }
        }
        
        return ans.toString().equals(ans.reverse().toString());
    }
}