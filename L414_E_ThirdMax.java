import java.util.Arrays;

public class L414_E_ThirdMax {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int newSize = removeDuplicates(nums);
        if(newSize < 3){
            return nums[newSize - 1];
        }
        else{
            return nums[newSize - 3];
        }
        
    }

    public static int removeDuplicates(int[] nums) {
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