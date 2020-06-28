import java.util.Arrays;

public class L1464_E_MaxProduct {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        

        return (nums[nums.length-1] - 1) * (nums[nums.length-2] - 1);
    }
}