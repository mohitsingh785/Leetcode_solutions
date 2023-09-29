//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split("\\s+");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                int k = 0;
                str = read.readLine().trim().split("\\s+");
                for(int j = 0; j < c; j++){
                  matrix[i][j] = Integer.parseInt(str[k]);
                  k++;
                }
            }
            new Solution().booleanMatrix(matrix);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    sb.append(matrix[i][j] + " ");
                }
                sb.append("\n"); 
            }
            System.out.print(sb);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    void booleanMatrix(int matrix[][]) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean rowHasOne = false;
        boolean colHasOne = false;

        // Check if the first row has any ones
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 1) {
                rowHasOne = true;
                break;
            }
        }

        // Check if the first column has any ones
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 1) {
                colHasOne = true;
                break;
            }
        }

        // Mark rows and columns based on the rest of the matrix
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][0] = 1;
                    matrix[0][j] = 1;
                }
            }
        }

        // Update rows based on marked columns
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 1 || matrix[0][j] == 1) {
                    matrix[i][j] = 1;
                }
            }
        }

        // Update the first row and first column if needed
        if (rowHasOne) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 1;
            }
        }

        if (colHasOne) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 1;
            }
        }
    }
}
