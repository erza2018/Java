// You are given coins of different denominations and a total amount of money amount. 
// Write a function to compute the fewest number of coins that you need to make up that amount. 
// If that amount of money cannot be made up by any combination of the coins, return -1.

// You may assume that you have an infinite number of each kind of coin.

 

// Example 1:

// Input: coins = [5, 10, 20], amount = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1

// 0, 1,  2,  3,  4,  5, 6,  7,  8,  9,  10, 11
// 0, -1, -1, -1, -1, 1, -1, -1, -1, -1, 1,  -1



// Example 2:

// Input: coins = [1, 2], amount = 3
// Output: -1
// 0, 1, 2, 3,
// 0, 1, 1, 2

// i = 1:
// minimum = MAX
// j = 0 (value of 1)
// curr = minumums[0] = 0
// minimum  = 1
// j = 1 (value of 2)

// i = 2:
// minimum = MAX
// j = 0 (1)
// curr = minimums[1] = 1
// minimum = min (MAX, 2) = 2
// j = 1 (2)
// curr  = minimums[0] = 0
// minimum = min (2, 1) = 1
// minimums[2] = 1

// i = 3
// minimum = MAX
// j = 0 (1)
// cur = minimums[2] = 1
// minimum = min (MAX, 2) = 2
// j = 1 (2)
// curr = minimums[1] = 1
// minimum = min(MAX, 2) = 2

// minimums[3] = 3

// Example 3:

// Input: coins = [1], amount = 0
// Output: 0
// Example 4:

// Input: coins = [1], amount = 1
// Output: 1
// Example 5:

// Input: coins = [2], amount = 2
// Output: 2

// 0, 1, 2, 
// 0, 0, 1 
 

// Constraints:

// 1 <= coins.length <= 12
// 1 <= coins[i] <= 231 - 1
// 0 <= amount <= 104


public class L322_M_CoinChange {
    public int coinChange(int[] coins, int amount) {
        // base case
        if (amount == 0) return 0;

        if (coins == null || coins.length == 0)
            return -1;

        // make table
        int[] minimums = new int[amount + 1];
        for(int i = 1; i < amount + 1; i++){
            minimums[i] = -1;  // by default, there is no solution
            for(int j = 0; j < coins.length; j++){
                // only calculate for valid cases
                if(coins[j] <= i && minimums[i - coins[j]] >= 0){
                    minimums[i] = (minimums[i] == -1) ? 
                                    minimums[i - coins[j]] + 1
                                    : Math.min(minimums[i], minimums[i - coins[j]] + 1);
                }
            }
        }

        return minimums[amount];
    }
}
