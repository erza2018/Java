import java.util.Arrays;

public class L1470_E_ShuffleArray {
    public int[] shuffle(int[] nums, int n) {
        int[] toReturn = new int[2*n];
        int[] xValues = Arrays.copyOfRange(nums, 0, n);
        int[] yValues = Arrays.copyOfRange(nums, n, 2*n);

        for(int i = 0; i < n; i++){
            toReturn[2*i] = xValues[i];
            toReturn[2*i+1] = yValues[i];
        }
        
        return toReturn;
    }
}