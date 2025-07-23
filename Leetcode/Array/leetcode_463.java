package Java_Bootcamp.Leetcode.Array;

public class leetcode_463 {
    public int islandPerimeter(int[][] grid) {

        int res = 0;

        for(int i=0 ; i < grid.length ; i++){
            for(int j=0 ; j< grid[i].length ; j++){

                if(grid[i][j] == 1){
                    res += 4;

                    if(j != 0 && grid[i][j-1] == 1) res--;
                    if(j != grid[i].length-1 && grid[i][j+1] == 1) res--;
                    if(i != 0 && grid[i-1][j] == 1) res--;
                    if(i != grid.length -1 && grid[i+1][j] == 1) res--;
                }
            }
        }

        return res;
    }
}
