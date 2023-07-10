//{ Driver Code Starts
import java.util.Arrays;
import java.util.Scanner;
class FindFourElements
{
	
    public static void main(String[] args) 
    {
		Scanner sc=new Scanner (System.in);
		int t=sc.nextInt();
		while(t-->0){
			FindFourElements findfour = new FindFourElements();
			int n=sc.nextInt();
			int[] A=new int[n];
			for(int i=0;i<n;i++)
				A[i]=sc.nextInt();
			int X =sc.nextInt();
			
			Compute ob = new Compute();
		    System.out.println(ob.find4Numbers(A, n, X)?1:0);
		}
    }
}


// } Driver Code Ends


class Compute
{
    boolean find4Numbers(int arr[], int n, int target) 
    {
         Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){

            for(int j=i+1;j<arr.length;j++){
             
                int l=j+1;
                int h=arr.length-1;

                while(l<h){


                    if(arr[i]+arr[j]+arr[l]+arr[h]==target){

                         return true;
                    }
                    else if(arr[i]+arr[j]+arr[l]+arr[h]<target){

                        l++;
                    }
                    else{
                        h--;
                    }
                }
              
            }
        }
        return false;
    }
}