public class L674_E_LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        
        // EDGE CASES
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;

        // MAIN LOGIC
        // Keep two pointers counting the largest or two largest sequences at a time
        int counter = 1;
        int previousHigh = 0;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                counter++;
            }
            else{
                if(counter > previousHigh){
                    previousHigh = counter;
                }

                counter = 1;
            }
        }

        if(counter >= previousHigh){
            return counter;
        }
        else{
            return previousHigh;
        }
        
    }
}