//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int t=0;t<testCases;t++){
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    for(int i=0;i<n;i++){
		        arr[i] = sc.nextInt();
		    }
		    Arrays.sort(arr);
		    ArrayList <ArrayList<Integer>> res = new solve().AllSubsets(arr,n);
		    for (int i = 0; i < res.size (); i++)
		    {
		        System.out.print ("(");
		        for (int j = 0; j < res.get(i).size (); j++)
		        {
		            if (j != res.get(i).size()-1)
		                System.out.print ((res.get(i)).get(j) + " ");
		            else
		                System.out.print ((res.get(i)).get(j));
		        }
		        System.out.print (")");
		      
		    }
		    System.out.println();
		}
	}
}
// } Driver Code Ends


class solve{

    public static ArrayList <ArrayList <Integer>> AllSubsets(int arr[], int n){

      // Arrays.sort(arr);

        LinkedHashSet <ArrayList <Integer>> res = new LinkedHashSet<>();

        ArrayList<Integer> set = new ArrayList<>();

      res.add(set);

        store(res,set,arr,0);

        return new ArrayList<>(res);

    }

    static void store(LinkedHashSet<ArrayList <Integer>> res,  ArrayList<Integer> set,int arr[], int index){

        if(index == arr.length) {
            return ;
        }
        

           set.add(arr[index]);

           res.add(new ArrayList<>(set));

           store(res,set,arr,index+1);

           set.remove(set.size()-1);

           store(res,set,arr,index+1);

    }}