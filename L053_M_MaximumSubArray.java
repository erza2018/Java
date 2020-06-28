public class L053_M_MaximumSubArray {
    public int maxSubArray(int[] nums) {
        
        int max = nums[0];
        int sum = 0;
        int j = 0;
        for(int i = 0;i < nums.length; i++){
            sum += nums[i];
            if( sum > max) max = sum;
            while(j <= i && sum < 0){
                sum -= nums[j];
                j++;
            }            
        }
        return max;
    }
}