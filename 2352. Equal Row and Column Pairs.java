class Solution {
    public int equalPairs(int[][] grid) {
        int result = 0;
        for(int row=0;row<grid.length; row++){
            for(int column=0;column<grid.length;column++){
                boolean sameFlag = true;
                for(int i=0;i<grid.length;i++){
                    if(grid[row][i] != grid[i][column]){
                        sameFlag=false;
                        break;
                    }
                }
                if(sameFlag)
                    result++;
            }
        }

        return result;
    }
}