import java.util.ArrayList;
import java.util.Collections;


public class L1365_NumbersSmaller {
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] values = new int[nums.length];

        ArrayList<Integer> sorted = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++){
                sorted.add(nums[i]);
            
        }
        Collections.sort(sorted);

        for(int i = 0; i < nums.length; i++){
            values[i] = sorted.indexOf(nums[i]);
        }

        return values;
    }

    
    public static void main(String[] args) {
        System.out.println(smallerNumbersThanCurrent(new int[]{8,1,2,2,3}));
    }
}