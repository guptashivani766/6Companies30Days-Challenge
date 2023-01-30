class MaxSumOfHourGlass 
{
	public int maxSum(int[][] grid) {
        int sum =0;
        int result =Integer.MIN_VALUE;
        for(int r=0;r<grid.length-2;r++){
            for(int c=0;c<grid[r].length-2;c++){
                sum = grid[r][c] +grid[r][c+1]+grid[r][c+2]+grid[r+1][c+1]+grid[r+2][c]+grid[r+2][c+1]+grid[r+2][c+2];
                result = Math.max(result,sum);
            }
        }
        return result;
    }
}
