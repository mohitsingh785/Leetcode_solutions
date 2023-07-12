//{ Driver Code Starts
import java.util.*;

class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i=0; i<n; i++)
				a[i] = sc.nextInt();
			Solution ob = new Solution();
			System.out.println(ob.findMaxDiff(a,n));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    int findMaxDiff(int a[], int n)
    {
	// Your code here	
	
	int []b=a.clone();
	
	
	Stack<Integer> st=new Stack<>();
	
	
	for(int i=0;i<n;i++){
	    
	    
	    if(st.isEmpty()){
	        
	        st.push(i);
	    }
	    else{
	        
	        while(!st.isEmpty() && a[st.peek()]>a[i]){
	            
	            
	            a[st.pop()]=a[i];
	        }
	        
	        st.push(i);
	    }
	}
	
	
	while(!st.isEmpty()){
	    a[st.pop()]=0;
	}
	
		Stack<Integer> st1=new Stack<>();
	
	
	for(int i=n-1;i>=0;i--){
	    
	    
	    if(st1.isEmpty()){
	        
	        st1.push(i);
	    }
	    else{
	        
	        while(!st1.isEmpty() && b[st1.peek()]>b[i]){
	            
	            
	            b[st1.pop()]=b[i];
	        }
	        
	        st1.push(i);
	    }
	}
	
	
	while(!st1.isEmpty()){
	    b[st1.pop()]=0;
	}
	
	
	int ans=0;
	for(int i=0;i<n;i++){
	    ans=Math.max(ans,Math.abs(a[i]-b[i]));
	}
	return ans;
    }
}