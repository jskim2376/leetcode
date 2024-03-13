class Solution {
    public int equalPairs(int[][] grid) {
        int result = 0;
        for(int row=0;row<grid.length; row++){
            for(int column=0;column<grid.length;column++){
                if(isEqualRowAndColumn(grid,row,column))
                    result++;
            }
        }

        return result;
    }

    public boolean isEqualRowAndColumn(int[][] grid, int row, int column){
        for(int i=0;i<grid.length;i++){
            if(grid[row][i] != grid[i][column]){
               return false;
            }
        }
        return true;
    }
}