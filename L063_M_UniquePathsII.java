import java.util.LinkedList;
import java.util.Queue;

// A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
// The robot can only move either down or right at any point in time. 
// The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
// Now consider if some obstacles are added to the grids. How many unique paths would there be?
// An obstacle and space is marked as 1 and 0 respectively in the grid.

// Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
// Output: 2
// Explanation: There is one obstacle in the middle of the 3x3 grid above.
// There are two ways to reach the bottom-right corner:
// 1. Right -> Right -> Down -> Down
// 2. Down -> Down -> Right -> Right

// Input: obstacleGrid = [[0,1],[0,0]]
// Output: 1
public class L063_M_UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // edge cases
        if(obstacleGrid.length <= 0) return 0;
        if(obstacleGrid[0][0] == 1) return 0;

        // main logic 
        int m = obstacleGrid.length - 1;
        int n = obstacleGrid[0].length - 1;
        if(obstacleGrid[m][n] == 1) return 0;

        int paths  = 0;
        Queue<Coordinate> queue = new LinkedList<Coordinate>();
        Coordinate start = new Coordinate(0,0);
        queue.add(start);

        while(!queue.isEmpty()){
            Coordinate curr = queue.poll();
            if(curr.x == m && curr.y == n){
                paths++;
            }
            else if(curr.x == m){
                if(obstacleGrid[curr.x][curr.y + 1] != 1){
                    queue.add(new Coordinate(curr.x, curr.y + 1));
                }
            }
            else if(curr.y == n){
                if(obstacleGrid[curr.x + 1][curr.y] != 1){
                    queue.add(new Coordinate(curr.x + 1, curr.y));
                }
            }
            else{
                if(obstacleGrid[curr.x][curr.y + 1] != 1){
                    queue.add(new Coordinate(curr.x, curr.y + 1));
                }
                if(obstacleGrid[curr.x + 1][curr.y] != 1){
                    queue.add(new Coordinate(curr.x + 1, curr.y));
                }
            }
        }

        return paths;
    }

    public static int uniquePathsWithObstaclesDP(int[][] obstacleGrid){
        // GRID
        // 0 1 0
        // 0 1 0
        // 0 0 0 

        //DP 
        // 1 0 0
        // 1 0 0
        // 1 1 1

        // [0,1,0,0,0],
        // [1,0,0,0,0],
        // [0,0,0,0,0],
        // [0,0,0,0,0]


        // 

        // edge cases
        if(obstacleGrid.length <= 0) return 0;
        if(obstacleGrid[0][0] == 1) return 0;

        // main logic 
        int m = obstacleGrid.length - 1;
        int n = obstacleGrid[0].length - 1;
        if(obstacleGrid[m][n] == 1) return 0;

        int[][] paths = new int[m + 1][n + 1]; 
        for(int i = 0; i <= n; i++){
            if (obstacleGrid[0][i] == 0){
                paths[0][i] = 1;
            }
            else{
                break;
            }
        }
        for(int j = 0; j <= m; j++){
            if (obstacleGrid[j][0] == 0){
                paths[j][0] = 1;
            }
            else{
                break;
            }
        }

        for(int row = 1; row <= m; row++){
            for(int col = 1; col <= n; col++){
                if(obstacleGrid[row][col] != 1){
                    paths[row][col] = paths[row-1][col] + paths[row][col-1];
                }
            }
        }

        return paths[m][n];

    }

    private static class Coordinate{
        public int x;
        public int y; 

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        int[][] test = new int[][]{
            {0,1,0,0,0},
            {1,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0}
        };
    
        System.out.println(uniquePathsWithObstaclesDP(test));
        
    }
}



