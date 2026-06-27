class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int fresh =0;
        for(int r=0;r<rows;r++){
            for(int c =0;c <cols;c++){
                if(grid[r][c] == 2){
                    queue.add(new int[]{r,c});
                }else if(grid[r][c] == 1){
                    fresh++;
                }
            }
        }
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        int mins =0;
        while(fresh>0 && !queue.isEmpty()){
            int size =queue.size();
            for(int i=0;i<size;i++){
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];

                for(int[] direction: directions){
                    int nr = row + direction[0];
                    int nc = col + direction[1];

                    if(nr>=0 && nc>=0 && nr<rows && nc<cols 
                        && grid[nr][nc]==1){
                            grid[nr][nc]=2;
                            fresh--;
                            queue.add(new int[]{nr,nc});
                    }
                }
            }
            mins++;
        }
        return fresh == 0 ? mins: -1;

    }
}
