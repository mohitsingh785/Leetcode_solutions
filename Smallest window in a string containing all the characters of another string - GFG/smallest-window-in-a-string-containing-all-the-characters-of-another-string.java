//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String t)
    {
        // Your code here
        
         HashMap<Character, Integer> reqFreq = new HashMap<>();
        int reqMatch = t.length();
        for (char c : t.toCharArray()) reqFreq.put(c, reqFreq.getOrDefault(c, 0) + 1);

        String ans = "";

        HashMap<Character, Integer> workFreq = new HashMap<>();

        int i = -1, j = -1, currMatch = 0;
        while (i <= j && i < s.length() - 1) {
            if (currMatch == reqMatch) {
                String alpha = s.substring(i + 1, j + 1);
                if (ans.equals("") || alpha.length() < ans.length()) {
                    ans = alpha;
                }
            }
            if (currMatch < reqMatch && j < s.length() - 1) {
                j++;
                char c = s.charAt(j);
                workFreq.put(c, workFreq.getOrDefault(c, 0) + 1);
                if (reqFreq.containsKey(c) && workFreq.get(c) <= reqFreq.get(c)) {
                    currMatch++;
                }
            } else {
                i++;
                char c = s.charAt(i);
                workFreq.put(c, workFreq.get(c) - 1);
                if (reqFreq.containsKey(c) && workFreq.get(c) < reqFreq.get(c)) {
                    currMatch--;
                }
            }
        }
        
        if(ans.length()==0){
            return "-1";
        }
        return ans;
    }
}