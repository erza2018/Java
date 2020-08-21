import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
/*
    Given M sorted lists with N integers each, find the K smallest integers.

    Example:

    [
    [1,3,4,7],
    [2,4,4,7],
    [1,2,3,4],
    ]
    M = 3
    N = 4
    K = 4

    Answer:
    [1, 1, 2, 2]

    */


    public class T003_kSmallest {
    
    /*
    Priority Queue min-heap


    */


    public static int[] kSmallest(int[][] input, int k){

        //Edge Cases
        if(input == null){
            return null;
        }
        if(k < 0){
            return null;
        }

        int m = input.length;
        int n = input[0].length;

        if(m == 0 || n == 0){
            return null;
        }
        
        if(k > m * n){
            return null;
        }


        
        Comparator<Element> elementComparator = new Comparator<Element>(){
            @Override
            public int compare(Element p1, Element p2){
                return p1.value - p2.value;
            
            }
        };
        //Main Logic 
        int[] result = new int[k];

        if(m == 1){
            for(int i = 0; i < k; i++){
                result[i] = input[0][k];
            }
            return result;
        }

        PriorityQueue<Element> pq = new PriorityQueue<Element>(elementComparator);
        
        for(int i = 0; i < m; i++){
            pq.add(new Element(i, input[i][0], 0));
        }
        
        for(int i = 0; i < k; i++){
            Element curr = pq.remove();
            result[i] = curr.value;
            
            if(curr.index < n - 1){
                pq.add(new Element(curr.arrayNum, input[curr.arrayNum][curr.index + 1], curr.index + 1));
            }
        
        
        }
        
        return result;
    }

    public static class Element{
        
        public int arrayNum;
        public int value;
        public int index;
        
        public Element(int arrayNum, int value, int index){
            this.arrayNum = arrayNum;
            this.value = value;
            this.index = index;
            
        }

    }

    public static void main(String[] args) {
        int[] a1 = new int[]{1,3,4,7};
        int[] a2 = new int[]{2,4,4,7};
        int[] a3 = new int[]{1,2,3,4};
        int[][] test = new int[][]{a1, a2, a3};


        System.out.println(Arrays.toString(kSmallest(test, 4)));
    }
}
