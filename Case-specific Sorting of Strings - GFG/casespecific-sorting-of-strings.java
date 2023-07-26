//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
    //Function to perform case-specific sorting of strings.
    public static String caseSort(String str)
    {
        // Your code here
        ArrayList<Character> lowerChars = new ArrayList<>();
        ArrayList<Character> upperChars = new ArrayList<>();

        for (char a : str.toCharArray()) {
            if (a >= 'a' && a <= 'z') {
                lowerChars.add(a);
            } else {
                upperChars.add(a);
            }
        }

        Collections.sort(lowerChars);
        Collections.sort(upperChars);

        StringBuilder name = new StringBuilder();
        int lowerIndex = 0;
        int upperIndex = 0;

        for (char a : str.toCharArray()) {
            if (a >= 'a' && a <= 'z') {
                name.append(lowerChars.get(lowerIndex++));
            } else {
                name.append(upperChars.get(upperIndex++));
            }
        }

        return name.toString();
    }
}

//{ Driver Code Starts.

class GFG {
	public static void main (String[] args) {
		
    	try {
    	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	    PrintWriter out=new PrintWriter(System.out);
    	    String[] words = br.readLine().split("\\s+");
    	    int numTestCases = Integer.parseInt(words[0]);
    	    
    	    for (int tIdx = 0; tIdx < numTestCases; tIdx++) {
    	        words = br.readLine().split("\\s+");
    	        int size = Integer.parseInt(words[0]);
    	        String str = br.readLine();
    	        String sortedStr = new Solution().caseSort(str);
    	        out.println(sortedStr);
    	    }
    	    out.close();
    	}
    	catch (IOException e) {
    	    System.out.println(e);
    	}
	}
}
// } Driver Code Ends