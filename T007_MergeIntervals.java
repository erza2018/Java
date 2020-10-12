import java.util.ArrayList;
import java.util.PriorityQueue;

public class T007_MergeIntervals {
        /*
    Given a collection of intervals, merge all overlapping intervals.

    Example 1:

    Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
    Example 2:

    Input: intervals = [[1,4],[4,5]]
    Output: [[1,5]]
    Explanation: Intervals [1,4] and [4,5] are considered overlapping.
    NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

    

    Constraints:

    intervals[i][0] <= intervals[i][1]
    */

    /* 
    e.g. [ [1,5], [1,3], [8, 10], [2, 6], [15, 18] ]
    => [ [1,3], [1,5], [2,6], [8,10], [15,18] ]
    => [1, 5], [2, 6]
    => [1, 6] [8, 10] [15, 18]


    1.     [1       3]
                [3      ]
    2.     [1       3 ]
                [2           5]
    3.     [         ]
            [      ] 
                                
    */
        public static int[][] merge(int[][] intervals) {
            // array 1 : 1, 2, 8, 15
            // array 2 : 3, 6, 10, 18
            // because 2 <= 3 that means 
            // del 2 and 3 
            // res: array 1: 1, 8, 15
            // res: array 2: 6, 10, 18
            
            // map 
            // 1 -> 5
            // 1 -> 3
            // if two values are both a key of the map, you replace whichever val is larger
            if(intervals.length == 0) return intervals;
            if(intervals.length == 1) return intervals;

            PriorityQueue<Interval> pq = new PriorityQueue<Interval>();
            ArrayList<Interval> merged = new ArrayList<Interval>();
            
            int index = 0;
            for(int[] i : intervals){
                Interval toAdd = new Interval(i[0], i[1]);
                pq.add(toAdd);
            }


            // remove the head and compare with new head
            Interval curr = pq.remove();
            while(!pq.isEmpty()){
                Interval next = pq.remove();
                if(next.start <= curr.end){
                    if(next.end > curr.end){
                        curr = new Interval(curr.start, next.end);
                    }    
                        ////////////

                }
                else{
                    merged.add(curr);
                    curr = next;
                }      

            }
            merged.add(curr);
            //merged[index] = new int[] {curr.start, curr.end};

            int[][] mergedIntervals = new int[merged.size()][2];
            for(Interval i : merged){
                int[] add = new int[]{i.start, i.end};
                mergedIntervals[index++] = add;
            }
            
            return mergedIntervals;
        }

        public static class Interval implements Comparable<Interval>{
            public int start;
            public int end;


            public Interval(int start, int end){
                this.start = start;
                this.end = end;
            }
            
            @Override
            public int compareTo(Interval y){
                if(this.start < y.start){
                    return -1;
                }
                if(this.start == y.start){
                    if(this.end < y.end){
                        return -1;
                    }
                    else{
                        return 1;
                    }
                }
                else{
                    return 1;
                }
            }

        }
        
    public static void main(String[] args) {
        int[][] test = new int[][]{{1,3}, {2,6}, {8,10}, {15, 18}};
        System.out.println(merge(test));
    }
}
