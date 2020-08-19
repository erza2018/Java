import java.util.Collections;
import java.util.PriorityQueue;

public class L295_H_MedianInStream {


    class MedianFinder {

        public PriorityQueue<Integer> lessThanMedian; 
        
        public PriorityQueue<Integer> greaterThanMedian;
        /** initialize your data structure here. */
        public MedianFinder() {
            lessThanMedian = new PriorityQueue<Integer>(Collections.reverseOrder());
            greaterThanMedian = new PriorityQueue<Integer>();

        }
        
        public void addNum(int num) {

            greaterThanMedian.add(num);
            lessThanMedian.add(greaterThanMedian.poll());

            if(greaterThanMedian.size() < lessThanMedian.size()){
                greaterThanMedian.add(lessThanMedian.poll());
            }

            
        }
        
        public double findMedian() {

            if(greaterThanMedian.size() == lessThanMedian.size()){
                return (double) (greaterThanMedian.peek() + lessThanMedian.peek())/2.0; 
            }
            else{
                return greaterThanMedian.peek();
            }
            
        }
    }
    
}