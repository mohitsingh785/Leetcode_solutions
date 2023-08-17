//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

  public class LRUDesign {

    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            int capacity = Integer.parseInt(read.readLine());
            int queries = Integer.parseInt(read.readLine());
            LRUCache cache = new LRUCache(capacity);
            String str[] = read.readLine().trim().split(" ");
            int len = str.length;
            int itr = 0;

            for (int i = 0; (i < queries) && (itr < len); i++) {
                String queryType = str[itr++];
                if (queryType.equals("SET")) {
                    int key = Integer.parseInt(str[itr++]);
                    int value = Integer.parseInt(str[itr++]);
                    cache.set(key, value);
                }
                if (queryType.equals("GET")) {
                    int key = Integer.parseInt(str[itr++]);
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// design the class in the most optimal way

class LRUCache
{
    
      static int capacity;
    static Map<Integer, Integer> cache;

    //Constructor for initializing the cache capacity with the given value.
    LRUCache(int cap)
    {
        //code here
          this.capacity = cap;
        cache = new LinkedHashMap<>();
    }

    //Function to return value corresponding to the key.
    public static int get(int key)
    {
        // your code here
        if (cache.containsKey(key)) {
            int value = cache.get(key);
            // Put to the end of the Map to indicate that the element has been used recently
            cache.remove(key);
            cache.put(key, value);
            return value;
        } else
            return -1;
    }

    //Function for storing key-value pair.
    public static void set(int key, int value)
    {
        // your code here
        if (cache.size() >= capacity && !cache.containsKey(key))
            // Remove the (LRU) least recently used element (being in head indicated it's the least recently used)
            cache.remove(cache.entrySet().iterator().next().getKey());

        // Move the element to tail to indicate it has been used recently
        if (cache.containsKey(key))
            cache.remove(key);

        cache.put(key, value);
    }
}
