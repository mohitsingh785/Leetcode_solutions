//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String S = read.readLine();
            Solution obj = new Solution();
            System.out.println(obj.printSequence(S));
            
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    
    
    
    String printSequence(String S) 
    { 
        // code here
        
        HashMap<Character,String> map=new HashMap<>();
        
        map.put('A',"12");
         map.put('B',"22");
          map.put('C',"32");
           map.put('D',"13");
         map.put('E',"23");
          map.put('F',"33");
         map.put('G',"14");
         map.put('H',"24");
          map.put('I',"34");
           map.put('J',"15");
         map.put('K',"25");
          map.put('L',"35");
           map.put('M',"16");
         map.put('N',"26");
          map.put('O',"36");
           map.put('P',"17");
         map.put('Q',"27");
          map.put('R',"37");
          map.put('S',"47");
            map.put('T',"18");
         map.put('U',"28");
          map.put('V',"38");
              map.put('W',"19");
         map.put('X',"29");
          map.put('Y',"39");
           map.put('Z',"49");
           
           
           String ans="";
           for(int i=0;i<S.length();i++){
               
               char a=S.charAt(i);
               
               if(map.containsKey(a)){
                   
                   int j=Integer.parseInt(map.get(a).charAt(0)+"");
                   for(int k=0;k<j;k++){
                       ans+=map.get(a).charAt(1)+"";
                   }
               }
               else{
                   ans+="0";
               }
           }
           return ans;
    }
}