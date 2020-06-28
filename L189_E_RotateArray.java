import java.util.Arrays;

public class L189_E_RotateArray {
    public static void rotate(int[] nums, int k) {
        if(nums.length <= 1){
            // do nothing
        }
        else if(k > nums.length){
            k = k - nums.length;
            rotate(nums, k);
        }
        else{
            // first, reverse all
            reverseArray(nums, 0, nums.length);
            // second, reverse k to the end
            reverseArray(nums, k, nums.length);
            // third, reverse 0 to k
            reverseArray(nums, 0, k);
        }
        


    }
    public static void reverseArray(int[] s, int start, int end) {
        for (int i = start; i < (end-start) / 2 + start; i++) {
            int temp = s[i];
            s[i] = s[end - 1 - i + start];
            s[end - 1 - i + start] = temp;
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[] {1,2};
        rotate(nums, 3);
        for(int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }

    }

}