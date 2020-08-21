import java.util.Arrays;

import java.util.HashSet;

public class L532_E_KdiffPairs {
    public static int findPairs(int[] nums, int k) {
        Arrays.sort(nums);

        HashSet<Integer> pairs = new HashSet<Integer>();

        for(int i = 0; i < nums.length - 1; i++){
            int j = i + 1;
            int difference = Integer.MIN_VALUE;
            while(j < nums.length && difference <=k){
                difference = nums[j] - nums[i];
                if(difference == k){
                    pairs.add(nums[i]);
                } 

                j++;
            }
        }

        return pairs.size();
    }


    public static void main(String[] args) {
        findPairs(new int[]{1,1,1,1,1}, 0);
    }
}