public class L283_E_MoveZeros {
    public void moveZeroes(int[] nums) {
        if(nums.length <= 1);
        else{
            int nextNonZero = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] != 0){
                    nums[nextNonZero] = nums[i];
                    nums[i] = 0;
                    nextNonZero++;
                }
            }
        }
    }
    
}