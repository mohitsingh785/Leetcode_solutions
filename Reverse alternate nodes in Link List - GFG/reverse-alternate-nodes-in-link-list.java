//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Rearr
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                temp.next = new Node(a);
                temp = temp.next;
            }
            
            Solution ob = new Solution();
            ob.rearrange(head);
            printLast(head);
            System.out.println();
        }
    }
    
    public static void printLast(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
class Solution
{
    public static void rearrange(Node odd)
    {
        // add your code here
        
        Node first=null;
        Node tail=null;
        Node second=null;
        int i=0;
        Node temp=odd;
        while(temp!=null){
             Node new_node=new Node(temp.data);
            if(i%2==0){
                
                if(tail==null && first==null){
                   
                    
                    first=new_node;
                    tail=new_node;
                }
                else{
                    
                    tail.next=new_node;
                    tail=tail.next;
                }
            }
            else{
                
                new_node.next=second;
                second=new_node;
            }
            temp=temp.next;
            i++;
        }
        
        Node temp1=first;
        
        while(temp1!=null){
            odd.data=temp1.data;
            odd=odd.next;
            temp1=temp1.next;
        }
        
          temp1=second;
        
        while(temp1!=null){
            odd.data=temp1.data;
            odd=odd.next;
            temp1=temp1.next;
        }
        
    }
}
