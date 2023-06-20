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
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here\\
        
        int b[] =  nums.clone();    
        
        
        Arrays.sort(b);
        
        
        HashMap<Integer,Integer> map=new HashMap<>();
        
        
        for(int i=0;i<b.length;i++){
            
            
            map.put(b[i],i);
        }
        
        
        int i=0;
        int swap=0;
        while(i<nums.length){
            
            if(map.get(nums[i])==i){
                
                i++;
            }
            else{
                int temp=nums[map.get(nums[i])];
                
                nums[map.get(nums[i])]=nums[i];
                nums[i]=temp;
                swap++;
            }
            
        }
        
        return swap;
        
        
    }
}