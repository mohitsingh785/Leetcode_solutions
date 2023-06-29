//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    public int findSubString( String s) {
        // Your code goes here
        
       int n = s.length();
        int distinctCount = getDistinctCount(s);

        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0;
        int minWindowLength = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            window.put(currentChar, window.getOrDefault(currentChar, 0) + 1);

            while (window.size() == distinctCount) {
                minWindowLength = Math.min(minWindowLength, right - left + 1);

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if (window.get(leftChar) == 0) {
                    window.remove(leftChar);
                }

                left++;
            }
        }

        return minWindowLength;
    }
     public int getDistinctCount(String s) {
        int count = 0;
        HashMap<Character, Integer> charCount = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!charCount.containsKey(c)) {
                count++;
                charCount.put(c, 1);
            }
        }

        return count;
    }
}