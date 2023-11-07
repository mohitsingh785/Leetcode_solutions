//{ Driver Code Starts
import java.util.*;
class Heap_Sort
{
    void printArray(int arr[],int n)
    {
        //int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc  = new Scanner(System.in);
        Heap_Sort hs = new Heap_Sort();
        int arr[] = new int[1000000];
        int T = sc.nextInt();
        while(T>0)
        {
            int n = sc.nextInt();
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
                
            Solution ob=new Solution();
            ob.heapSort(arr,n);
            hs.printArray(arr,n);
            T--;
        }
    }
    
}



// } Driver Code Ends


// JAVA SOLUTION

class Solution
{
    //Function to build a Heap from array.
    void buildHeap(int arr[], int n)
    {
        // Your code here
        for(int i=(n-2)/2;i>=0;i--)//starting with (n-2)/2 node as for ith node, the parent node is (i-1)/2
        {
            heapify(arr,n,i);//to create a max heap.
        }
    }
 
    //Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i)
    {
        // Your code here
        int temp;temp=0;
        int largest=i,left=2*i+1,right=2*i+2;//index of left and right nodes of the ith node.
        if(left<n && arr[left]>arr[largest])
        {
            largest=left;//storing the index of the largest node.
        }
        if(right<n && arr[right]>arr[largest])
        {
            largest=right;
        }
        if(largest!=i)
        {
            temp=arr[largest];
            arr[largest]=arr[i];
            arr[i]=temp;
            heapify(arr,n,largest);//heapify the node which got swapped.
        }
        
    }
    
    //Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n)
    {
        //code here
        int temp;temp=0;
        buildHeap(arr,n);//to build a max heap
        for(int i=n-1;i>0;i--)// to swap the 1st element with largest element, 2nd with 2nd largest and so on.
        {
            temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify(arr,i,0);// to heapify the root of the heap tree, and also reducing the heap size by 1.
        }
    }
 }