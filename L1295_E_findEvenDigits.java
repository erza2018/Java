public class L1295_E_findEvenDigits {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            String number = "" + nums[i];
            if(number.length() % 2 == 0){
                count++;
            }
        }

        return count;
    }
}