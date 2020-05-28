public class L011_M_ContainerWithMostWater {
    public int maxArea(int[] height) {
        if(height.length == 0) return 0;
        if(height.length == 1) return 0;
        int curMax = 0;

        //brute force tactic
        // for(int i = 0; i < height.length - 1; i++){
        //     for(int j = i+1; j < height.length; j++){
        //         int testHeight;
        //         if(height[j] > height[i]){
        //             testHeight = height[i];
        //         }
        //         else{
        //             testHeight = height[j];
        //         }
        //         int tempArea = testHeight * (j - i);
        //         if(tempArea > curMax){
        //             curMax = tempArea;
        //         }
        //     }
        // }

        // non n^2 tactic
        int l = 0;
        int r = height.length - 1;
        while(l < r){
            // compare the areas
            curMax = Math.max(curMax, Math.min(height[l], height[r]) * (r-l));

            // by moving the shorter line every time, we don't check the possibilities that ensure a smaller area
            if(height[l] < height[r]){
                l++;
            }
            else{
                r--;
            }
            
        }
        
        return curMax;
    }
}