//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int target) {
        // code here
      ArrayList<ArrayList<Integer>> quadruplets = new ArrayList<>();
        if (arr == null || arr.length < 4) {
            return quadruplets;
        }

        Arrays.sort(arr);

        int n = arr.length;

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue; // Skip duplicates
            }
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) {
                    continue; // Skip duplicates
                }
                int left = j + 1;
                int right = n - 1;
                int remainingTarget = target - arr[i] - arr[j];

                while (left < right) {
                    int sum = arr[left] + arr[right];
                    if (sum == remainingTarget) {
                        ArrayList<Integer> quadruplet = new ArrayList<>();
                        quadruplet.add(arr[i]);
                        quadruplet.add(arr[j]);
                        quadruplet.add(arr[left]);
                        quadruplet.add(arr[right]);
                        quadruplets.add(quadruplet);

                        left++;
                        right--;

                        while (left < right && arr[left] == arr[left - 1]) {
                            left++; // Skip duplicates
                        }
                        while (left < right && arr[right] == arr[right + 1]) {
                            right--; // Skip duplicates
                        }
                    } else if (sum < remainingTarget) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return quadruplets;
    }
}