import java.util.*;

public class L078_M_Subset {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        output.add(new ArrayList<Integer>());

        for(int n : nums){
            List<List<Integer>> toAdd = new ArrayList<List<Integer>>();
            for(List<Integer> l : output){
                List<Integer> newSub = new ArrayList<Integer>();
                newSub.addAll(l);
                newSub.add(n);
                toAdd.add(newSub);
            }

            for(List<Integer> l : toAdd){
                output.add(l);
            }
        }
        return output;
    }
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3};
        subsets(nums);
    }
}
