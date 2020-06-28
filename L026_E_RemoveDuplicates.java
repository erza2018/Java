public class L026_E_RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        
        int counter = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                counter++;
                nums[counter-1] = nums[i];
            }
            
        }
        return counter;
    }
    
}