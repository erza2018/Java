import java.util.LinkedList;
import java.util.Queue;

/*
    Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
    You may assume all four edges of the grid are all surrounded by water.

    Example 1:

    11110
    11010
    11000
    00000
    Answer: 1

    Example 2:

    11000
    11000
    00100
    00011
    Answer: 3
*/

public class T005_NumberOfIslands {
    
    public class Coordinate{
        public final int x;
        public final int y;

        public Coordinate(){
            this.x = -1;
            this.y = -1;
        }
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int numberOfIslands(char[][] map){
        if(map == null){
            return -1;
        }
        // stores the number of islands
        int count = 0;

        // iterates through the matrix
        for(int i = 0; i < map.length; i++){
            for(int j = 0; i < map[i].length; j++){
                if(map[i][j] == '0' || map[i][j] == 'X'){
                    break;
                }
                else{
                    count++;
                    numIslandsDFS(map, i, j);
                }
                
            }
        }

        return count;
    }

    public void numIslandsDFS(char[][] map, int i, int j){
        if( i < 0 || i > map.length || j < 0 || j > map[i].length){
            return;
        }
        if(map[i][j] == 0){
            return;
        }
        if(map[i][j] == 'X'){
            return;
        }
 
        
        map[i][j] = 'X';
        numIslandsDFS(map, i+1, j);
        numIslandsDFS(map, i, j+1);
        numIslandsDFS(map, i-1, j);
        numIslandsDFS(map, i, j-1);

    }

    public int numIslandsQueue(char[][] map){
        if(map == null){
            return -1;
        }
        int count = 0;
        Queue<Coordinate> toCheck = new LinkedList<Coordinate>();

        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                // if(map[i][j] == 0 || map[i][j] == 'X'){
                //     break;
                // }
                if(map[i][j] == '1'){
                    map[i][j] = 'X';
                    count++;
                    toCheck.add(new Coordinate(i, j));
                    while(!toCheck.isEmpty()){
                        Coordinate curr = toCheck.remove();
                        if(curr.x - 1 >= 0){
                            if(map[curr.x - 1][curr.y] == '1'){
                                map[curr.x - 1][curr.y] = 'X';
                                toCheck.add(new Coordinate(curr.x - 1, curr.y));
                            }
                        }
                        if(curr.x + 1 < map.length){
                            if(map[curr.x + 1][curr.y] == '1'){
                                map[curr.x + 1][curr.y] = 'X';
                                toCheck.add(new Coordinate(curr.x + 1, curr.y));
                            }
                        }
                        if(curr.y - 1 >= 0){
                            if(map[curr.x][curr.y - 1] == '1'){
                                map[curr.x][curr.y - 1] = 'X';
                                toCheck.add(new Coordinate(curr.x, curr.y - 1));
                            }
                        }
                        if(curr.y + 1 < map[curr.x].length){
                            map[curr.x][curr.y + 1] = 'X';
                            if(map[curr.x][curr.y + 1] == '1'){
                                toCheck.add(new Coordinate(curr.x, curr.y + 1));
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
    

}
