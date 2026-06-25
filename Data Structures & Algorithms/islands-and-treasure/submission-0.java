class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        int rows = grid.length;
        int cols = grid[0].length;

        for(int r=0;r<rows;r++){
            for(int c =0;c<cols;c++){
                if(grid[r][c] == 0)
                    queue.add(new int[]{r,c});
            }
        }
        int[][] directions = {{0,1}, {0,-1},{1,0},{-1,0}};

        while(!queue.isEmpty()){
            int[] curr = queue.poll();

            for(int[] direction:directions){
                int nr = curr[0] + direction[0];
                int nc = curr[1] + direction[1];

                if(nr>=0 && nc>=0 && nr<rows && nc < cols && grid[nr][nc] == Integer.MAX_VALUE){
                    grid[nr][nc] = grid[curr[0]][curr[1]] +1; 
                    queue.add(new int[]{nr,nc});
                }
            }
         }

        

    }
}
