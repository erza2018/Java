import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public class T001_NoRepeatedChars {
    /*
    Given a string with repeated characters, return a string with the same set of
    characters without repeated characters next to each other.
    E.g. 
    “aab” -> “aba”
    "aabb" --> "abab" or "baba"
    
    
    null
    r: null
    
    a
    r: a
    
    
    */


    public static String NR(String s){

        //Edge Cases
        if(s == null || s.isEmpty()){
            return s;
        }
        
        if(s.length() == 1){
            return s;
        }
        
        //Main Logic
        ConcurrentHashMap<Character, Integer> hash = new ConcurrentHashMap<Character, Integer>();
        
        for(char curr : s.toCharArray()){
            
            hash.put(curr, hash.getOrDefault(curr, 0) + 1);
        
        }
        
        StringBuilder toReturn = new StringBuilder();


        //Solution 1
        while(toReturn.length() < s.length()){
            for(char curr: hash.keySet()){
                if(hash.size() == 1 && hash.get(curr) > 1){
                    return null;
                }
                else{
                    toReturn.append(curr);
                    if(hash.get(curr) == 1){
                        hash.remove(curr);
                    }
                    else{
                        hash.put(curr, hash.get(curr) - 1);
                    }    
                }
            }
        }

        
        return toReturn.toString();
    }

    // ==================================
    // Solution 2
    // ==================================
    public static String NR2(String s){
        //Edge Cases
        if(s == null || s.isEmpty()){
            return s;
        }
        
        if(s.length() == 1){
            return s;
        }
        
        //Main Logic
        HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
        
        for(char curr : s.toCharArray()){
            
            hash.put(curr, hash.getOrDefault(curr, 0) + 1);
        
        }
        
        StringBuilder toReturn = new StringBuilder();

        Queue<Character> queue = new LinkedList<Character>();
        
        queue.addAll(hash.keySet());

        while(!queue.isEmpty()){
            if(queue.size() == 1 && hash.get(queue.peek()) > 1){
                return null;
            }

            else{
                char curr = queue.poll();
                
                toReturn.append(curr);
                
                if(hash.get(curr) == 1){
                    // do nothing
                }
                else{
                    hash.put(curr, hash.get(curr) - 1);
                    queue.offer(curr);
                } 

            }
            
        }
        return toReturn.toString();
    }

    // ==================================
    // Solution 3
    // ==================================
    public static String NR3(String s){
        //Edge Cases
        if(s == null || s.isEmpty()){
            return s;
        }
        
        if(s.length() == 1){
            return s;
        }
        
        //Main Logic
        HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
        
        for(char curr : s.toCharArray()){
            
            hash.put(curr, hash.getOrDefault(curr, 0) + 1);
        
        }
        
        StringBuilder toReturn = new StringBuilder();
        //Solution 3 - Priority Queue
        
        Comparator<Character> hashComparator = new Comparator<Character>(){
            @Override
            public int compare(Character c1, Character c2){
                return hash.get(c1) - hash.get(c2);
            }
        };

        PriorityQueue<Character> pq = new PriorityQueue<Character>(hashComparator);
        pq.addAll(hash.keySet());

        char holder = '0';
        while(!pq.isEmpty()){
            if(pq.size() == 1 && hash.getOrDefault(holder, 0) == 0 && hash.get(pq.peek()) > 1){
                return null;
            }
            else{
                
                char curr = pq.poll();
                if(holder != '0' && hash.get(holder) != 0){
                    pq.offer(holder);
                }
                holder = curr;
                toReturn.append(holder);
                hash.put(holder, hash.get(holder) - 1);
            }
        }

        
        return toReturn.toString();
    }

    public static void main(String[] args) {

        System.out.println(NR("aabb"));
        System.out.println(NR("aaab"));

        System.out.println(NR2("aabb"));
        System.out.println(NR2("aaab"));

        System.out.println(NR3("aabb"));
        System.out.println(NR3("aaab"));
    }
}