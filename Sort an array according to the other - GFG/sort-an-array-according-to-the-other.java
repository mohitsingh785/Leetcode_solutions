//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

import java.util.HashMap; 
import java.util.Map; 
import java.util.Map.Entry; 


// } Driver Code Ends
//User function Template for Java

class Solution{
    // A1[] : the input array-1
    // N : size of the array A1[]
    // A2[] : the input array-2
    // M : size of the array A2[]
    
    //Function to sort an array according to the other array.
    public static int[] sortA1ByA2(int A1[], int N, int A2[], int M)
    {
        //Your code here
        HashMap<Integer,Integer> map=new HashMap<>();
        
        
        for(int a:A1){
            
            map.put(a,map.getOrDefault(a,0)+1);
            
        }
        
        ArrayList<Integer> list=new ArrayList<>();
        ArrayList<Integer> list1=new ArrayList<>();
        
        for(int a:A2){
            
            
            if(map.containsKey(a)){
            
            for(int i=0;i<map.get(a);i++){
                
                list.add(a);
            }
            map.remove(a);
            }
            
        }
        
        for (Integer key : map.keySet()) {
           
            for(int i=0;i<map.get(key);i++){
                
                list1.add(key);
            }
        }
        Collections.sort(list1);
        
        for(int i=0;i<list1.size();i++){
            list.add(list1.get(i));
        }
        
        int [] arr=new int[list.size()];
        
         for(int i=0;i<list.size();i++){
            arr[i]=list.get(i);
        }
        
        return arr;
        
    }
}



//{ Driver Code Starts.
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int m=sc.nextInt();
		    int a1[]=new int[n];
		    int a2[]=new int[m];
		    
		    for(int i=0;i<n;i++)
		    a1[i]=sc.nextInt();
		    
		    for(int i=0;i<m;i++)
		    a2[i]=sc.nextInt();
		    Solution ob=new Solution();
		    a1 = ob.sortA1ByA2(a1,n,a2,m);
		    for(int x:a1)
		    System.out.print(x+" ");
		    
		    System.out.println();
		}
	}
	

}



// } Driver Code Ends