// You are climbing a staircase. It takes n steps to reach the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

// Example 1:

// Input: n = 2
// Output: 2
// Explanation: There are two ways to climb to the top.
// 1. 1 step + 1 step
// 2. 2 steps

// 0, 1, 2, 3
// 1, 1, 2, 2

// Example 2:
// Input: n = 3
// Output: 3
// Explanation: There are three ways to climb to the top.
// 1. 1 step + 1 step + 1 step
// 2. 1 step + 2 steps
// 3. 2 steps + 1 step

public class L070_E_ClimbingStairs{
    public int climbStairs(int n) {
        // base case
        if(n == 1){
            return 1;
        }

        // make table
        int[] dynTable = new int[n + 1];
        dynTable[0] = 1;
        dynTable[1] = 1;

        for(int i = 2; i < n + 1; i++){
            dynTable[i] = dynTable[i - 1] + dynTable[i - 2];
        }
        

        return dynTable[n];
    }
}