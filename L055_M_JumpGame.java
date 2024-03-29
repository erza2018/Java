public class L055_M_JumpGame {
    public boolean canJump(int[] nums) {
        
        int position = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--){
            if(i + nums[i] >= position){
                position = i;
            } 
        }
        return position == 0;
    }
    
}